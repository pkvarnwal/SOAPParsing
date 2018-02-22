package com.xmlparse.model.loginResponse;

import com.google.gson.annotations.SerializedName;

public class SoapEnvelopeResponse {

    @SerializedName("soap:Envelope")
    private SoapEnvelope soapEnvelope;

    public SoapEnvelope getSoapEnvelope() {
        return soapEnvelope;
    }

    public void setSoapEnvelope(SoapEnvelope soapEnvelope) {
        this.soapEnvelope = soapEnvelope;
    }
}
