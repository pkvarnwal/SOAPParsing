package com.xmlparse.http;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
}
