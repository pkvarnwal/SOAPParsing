package constraint.com.xmlparserusingretrofitr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import constraint.com.xmlparserusingretrofitr.http.DataManager;
import constraint.com.xmlparserusingretrofitr.http.HttpHandler;
import constraint.com.xmlparserusingretrofitr.model.UsStatesRequestBody;
import constraint.com.xmlparserusingretrofitr.model.UsStatesRequestData;
import constraint.com.xmlparserusingretrofitr.model.UsStatesRequestEnvelope;
import fr.arnaudguyon.xmltojsonlib.XmlToJson;

public class MainActivity extends AppCompatActivity {

    String urlToCall = "http://vestigews.skinformula9.com/services/wsvestigeapp.asmx?op=LoginAuthenticityV3";
    String userName = "11000076";
    String password = "123";
    String deviceType = "Android";
    String deviceId = "351892082793956";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new HttpHandler(this, urlToCall, getRequestXML(), new HttpHandler.GetResultListener() {
            @Override
            public void onSuccess(String result) {
                parseLoginResponse(result);
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        }).execute();
    }

    private void getUsStateInfo() {

        UsStatesRequestEnvelope usStatesRequestEnvelope = new UsStatesRequestEnvelope();
        UsStatesRequestBody usStatesRequestBody = new UsStatesRequestBody();
        UsStatesRequestData usStatesRequestData = new UsStatesRequestData();
        usStatesRequestData.setCity("Alaska");
        usStatesRequestBody.setUsStatesRequestData(usStatesRequestBody);
        usStatesRequestEnvelope.setBody(usStatesRequestBody);
        DataManager.getInstance().requestStateInfo(this, usStatesRequestEnvelope, new DataManager.DataManagerListener() {
            @Override
            public void onSuccess(Object response) {

            }

            @Override
            public void onError(Object error) {

            }
        });
    }

    public String getRequestXML() {

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

    private void parseLoginResponse(String result) {
        XmlToJson xmlToJson = new XmlToJson.Builder(result).build();
        Log.d("Data",xmlToJson.toString());
    }
}
