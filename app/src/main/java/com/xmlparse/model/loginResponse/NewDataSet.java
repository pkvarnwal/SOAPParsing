package com.xmlparse.model.loginResponse;

import com.google.gson.annotations.SerializedName;

public class NewDataSet {

    @SerializedName("xmlns")
    private String xmlns;
    @SerializedName("Table")
    private Table table;

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
