package com.xmlparse.SoapRequestManager;

public class SoapRequestXml {

private static SoapRequestXml sInstance;

private SoapRequestXml() {

}

public static SoapRequestXml getInstance() {

    if (sInstance == null) sInstance = new SoapRequestXml();

    return sInstance;
}

    public String getRequestXML(String userName, String password, String deviceId, String deviceType) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "    xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n" +
                "    xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <soap:Body>\n" +
                "        <LoginAuthenticityV3\n" +
                "            xmlns=\"http://tempuri.org/\">\n" +
                "            <DistributorId>"+ userName + "</DistributorId>\n" +
                "            <Password>" + password + "</Password>\n" +
                "            <DeviceId>" + deviceId + "</DeviceId>\n" +
                "            <DeviceToken>" + "" + "</DeviceToken>\n" +
                "            <DeviceType>" + deviceType + "</DeviceType>\n" +
                "        </LoginAuthenticityV3>\n" +
                "    </soap:Body>\n" +
                "</soap:Envelope>";
    }
}
