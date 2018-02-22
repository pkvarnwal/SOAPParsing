package com.xmlparse.model.loginResponse;

import com.google.gson.annotations.SerializedName;

public class SoapBody {

    @SerializedName("LoginAuthenticityV3Response")
    private LoginAuthenticityV3Response loginAuthenticityV3Response;

    public LoginAuthenticityV3Response getLoginAuthenticityV3Response() {
        return loginAuthenticityV3Response;
    }

    public void setLoginAuthenticityV3Response(LoginAuthenticityV3Response loginAuthenticityV3Response) {
        this.loginAuthenticityV3Response = loginAuthenticityV3Response;
    }
}
