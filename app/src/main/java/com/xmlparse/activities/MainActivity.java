package com.xmlparse.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.xmlparse.SoapRequestManager.SoapRequestXml;
import com.xmlparse.http.HttpHandler;
import com.xmlparse.model.loginResponse.SoapEnvelope;
import com.xmlparse.model.loginResponse.SoapEnvelopeResponse;
import com.xmlparse.model.loginResponse.Table;
import com.xmlparse.utils.AppConstant;

import constraint.com.xmlparserusingretrofitr.R;
import fr.arnaudguyon.xmltojsonlib.XmlToJson;

public class MainActivity extends AppCompatActivity implements AppConstant {

    String userName = "11000076";
    String password = "123";
    String deviceType = "Android";
    String deviceId = "351892082793956";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new HttpHandler(this, LOGIN_REQUEST, METHOD_TYPE_POST, SoapRequestXml.getInstance().getRequestXML(userName, password, deviceId, deviceType), new HttpHandler.GetResultListener() {
            @Override
            public void onSuccess(String result) {
                parseLoginResponse(result);
            }
        }).execute();
    }

    private void parseLoginResponse(String result) {
        if (result == null) return;
        
        XmlToJson xmlToJson = new XmlToJson.Builder(result).build();
        String convertToString = xmlToJson.toFormattedString();
        SoapEnvelopeResponse soapEnvelopeResponse = new Gson().fromJson(convertToString, SoapEnvelopeResponse.class);
        if (soapEnvelopeResponse  == null) return;

        if (soapEnvelopeResponse.getSoapEnvelope() != null && soapEnvelopeResponse.getSoapEnvelope().getSoapBody() != null
                && soapEnvelopeResponse.getSoapEnvelope().getSoapBody().getLoginAuthenticityV3Response() != null
                && soapEnvelopeResponse.getSoapEnvelope().getSoapBody().getLoginAuthenticityV3Response().getLoginAuthenticityV3Result() != null
                && soapEnvelopeResponse.getSoapEnvelope().getSoapBody().getLoginAuthenticityV3Response().getLoginAuthenticityV3Result().getDiffgrDiffgram() != null
                && soapEnvelopeResponse.getSoapEnvelope().getSoapBody().getLoginAuthenticityV3Response().getLoginAuthenticityV3Result().getDiffgrDiffgram().getNewDataSet() != null
                && soapEnvelopeResponse.getSoapEnvelope().getSoapBody().getLoginAuthenticityV3Response().getLoginAuthenticityV3Result().getDiffgrDiffgram().getNewDataSet().getTable() != null) {

            Table table = soapEnvelopeResponse.getSoapEnvelope().getSoapBody().getLoginAuthenticityV3Response().getLoginAuthenticityV3Result().getDiffgrDiffgram().getNewDataSet().getTable();
            System.out.println("TABLE: " + table.getDistributorEMailID() + ", " + table.getDiffgrId() + ", " + table.getDistributorName()
            + ", " + table.getDistributorLevel() + ", " + table.getProfileImagePath() + ", " + table.getDistibutorAddress()
            + ", " + table.getIsTrainer_Distributor() + ", " + table.getRANK() + ", " + table.getDistributorId()
            + ", " + table.getStaus() + ", " + table.getDistributorMobNumber() + ", " + table.getMsdataRowOrder());
        }
    }
}
