package com.xmlparse.model.loginResponse;

import com.google.gson.annotations.SerializedName;

public class LoginAuthenticityV3Result {

    @SerializedName("diffgr:diffgram")
    private DiffgrDiffgram diffgrDiffgram;

    @SerializedName("xs:schema")
    private XsSchema xsSchema;

    public DiffgrDiffgram getDiffgrDiffgram() {
        return diffgrDiffgram;
    }

    public void setDiffgrDiffgram(DiffgrDiffgram diffgrDiffgram) {
        this.diffgrDiffgram = diffgrDiffgram;
    }

    public XsSchema getXsSchema() {
        return xsSchema;
    }

    public void setXsSchema(XsSchema xsSchema) {
        this.xsSchema = xsSchema;
    }
}
