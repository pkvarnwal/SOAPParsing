package constraint.com.xmlparserusingretrofitr.http;

import constraint.com.xmlparserusingretrofitr.model.UsStatesRequestEnvelope;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ServiceInterface {

    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("/uszip.asmx")
    Call<UsStatesRequestEnvelope> requestStateInfo(@Body UsStatesRequestEnvelope body);
}
