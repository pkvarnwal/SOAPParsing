package constraint.com.xmlparserusingretrofitr.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "GetInfoByState", strict = false)
@Namespace(reference = "http://www.webserviceX.NET")
public class UsStatesRequestData {

    @Element(name = "USCity", required = false)
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
