package com.xmlparse.http;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHandler extends AsyncTask<String, Void, String> {

    private ProgressDialog progressDialog;
    private String urlToCall;
    private String xmlToSend;
    private GetResultListener resultListener;
    private Activity mActivity;

    public HttpHandler(Activity activity, String urlToCall, String requestXML, GetResultListener resultListener) {
        this.mActivity = activity;
        this.xmlToSend = requestXML;
        this.urlToCall = urlToCall;
        this.resultListener = resultListener;
    }

    public interface GetResultListener {
        void onSuccess(String result);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        HttpURLConnection conn = null;
        try {
            url = new URL(urlToCall);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.setConnectTimeout(20000);
            conn.setReadTimeout(20000);
            //Send request
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(xmlToSend);
            wr.flush();
            wr.close();

            //Get Response
            int status = conn.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK) {
                throw new IOException("Unexpected error response: "
                + conn.getResponseCode() + " "
                + conn.getResponseMessage());
            }

            InputStream is = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer responseBuf = new StringBuffer();
            System.out.println("response from server ");
            while ((line = rd.readLine()) != null) {
                System.out.println("[" + line + "]");
                responseBuf.append(line);
                responseBuf.append('\r');
            }
            System.out.println("response end.");
            rd.close();
            return responseBuf.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception ignored) {
                }
            }
        }
    }

    protected void onPostExecute(String result) {
        progressDialog.dismiss();
        resultListener.onSuccess(result);
    }
}
