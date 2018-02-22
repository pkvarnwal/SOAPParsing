package com.xmlparse.model.loginResponse;

import com.google.gson.annotations.SerializedName;

public class DiffgrDiffgram {

    @SerializedName("xmlns:diffgr")
    private String xmlnsDiffgr;
    @SerializedName("NewDataSet")
    private NewDataSet newDataSet;
    @SerializedName("xmlns:msdata")
    private String xmlnsMsdata;

    public String getXmlnsDiffgr() {
        return xmlnsDiffgr;
    }

    public void setXmlnsDiffgr(String xmlnsDiffgr) {
        this.xmlnsDiffgr = xmlnsDiffgr;
    }

    public NewDataSet getNewDataSet() {
        return newDataSet;
    }

    public void setNewDataSet(NewDataSet newDataSet) {
        this.newDataSet = newDataSet;
    }

    public String getXmlnsMsdata() {
        return xmlnsMsdata;
    }

    public void setXmlnsMsdata(String xmlnsMsdata) {
        this.xmlnsMsdata = xmlnsMsdata;
    }
}
