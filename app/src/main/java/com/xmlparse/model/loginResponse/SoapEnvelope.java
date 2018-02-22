package com.xmlparse.model.loginResponse;

import com.google.gson.annotations.SerializedName;

public class SoapEnvelope {

    @SerializedName("xmlns:soap")
    private String xmlnsSoap;
    @SerializedName("xmlns:xsi")
    private String xmlnsXsi;
    @SerializedName("xmlns:xsd")
    private String xmlnsXsd;
    @SerializedName("soap:Body")
    private SoapBody soapBody;

    public String getXmlnsSoap() {
        return xmlnsSoap;
    }

    public void setXmlnsSoap(String xmlnsSoap) {
        this.xmlnsSoap = xmlnsSoap;
    }

    public String getXmlnsXsi() {
        return xmlnsXsi;
    }

    public void setXmlnsXsi(String xmlnsXsi) {
        this.xmlnsXsi = xmlnsXsi;
    }

    public String getXmlnsXsd() {
        return xmlnsXsd;
    }

    public void setXmlnsXsd(String xmlnsXsd) {
        this.xmlnsXsd = xmlnsXsd;
    }

    public SoapBody getSoapBody() {
        return soapBody;
    }

    public void setSoapBody(SoapBody soapBody) {
        this.soapBody = soapBody;
    }
}
