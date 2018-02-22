package constraint.com.xmlparserusingretrofitr.http;

import android.app.Activity;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.util.concurrent.TimeUnit;

import constraint.com.xmlparserusingretrofitr.model.UsStatesRequestEnvelope;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class DataManager {

    private DataManager() {

    }

    private static class DataManagerSingleton {
        private static final DataManager INSTANCE = new DataManager();
    }

    public static DataManager getInstance() {
        return DataManagerSingleton.INSTANCE;
    }


    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

    Strategy strategy = new AnnotationStrategy();

    Serializer serializer = new Persister(strategy);

    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .build();

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
            .baseUrl("http://www.webservicex.net/")
            .client(okHttpClient)
            .build();

    private ServiceInterface getService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                    .baseUrl("http://www.webservicex.net/")
                    .client(okHttpClient)
                    .build();
        }
        return retrofit.create(ServiceInterface.class);
    }


    public interface DataManagerListener {
        void onSuccess(Object response);

        void onError(Object error);
    }


    public void requestStateInfo(Activity activity, UsStatesRequestEnvelope usStatesRequestEnvelope, final DataManagerListener dataManagerListener) {
        Call<UsStatesRequestEnvelope> call = getService().requestStateInfo(usStatesRequestEnvelope);
        call.enqueue(new Callback<UsStatesRequestEnvelope>() {
            @Override
            public void onResponse(Call<UsStatesRequestEnvelope> call, Response<UsStatesRequestEnvelope> response) {
                if (response.isSuccessful()) {
                    response.body();
                } else dataManagerListener.onError(response.body());
            }

            @Override
            public void onFailure(Call<UsStatesRequestEnvelope> call, Throwable t) {

            }
        });

    }
}
