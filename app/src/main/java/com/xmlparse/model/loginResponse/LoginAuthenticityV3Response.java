package com.xmlparse.model.loginResponse;

import com.google.gson.annotations.SerializedName;

public class LoginAuthenticityV3Response {

    @SerializedName("LoginAuthenticityV3Result")
    private LoginAuthenticityV3Result loginAuthenticityV3Result;
    @SerializedName("xmlns")
    private String xmlns;


    public LoginAuthenticityV3Result getLoginAuthenticityV3Result() {
        return loginAuthenticityV3Result;
    }

    public void setLoginAuthenticityV3Result(LoginAuthenticityV3Result loginAuthenticityV3Result) {
        this.loginAuthenticityV3Result = loginAuthenticityV3Result;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }
}
