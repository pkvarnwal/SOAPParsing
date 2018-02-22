package constraint.com.xmlparserusingretrofitr.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap12:Body", strict = false)
public class UsStatesRequestBody extends UsStatesRequestData {

    @Element(name = "GetInfoByCity", required = false)
    private UsStatesRequestData usStatesRequestData;

    public UsStatesRequestData getUsStatesRequestData() {
        return usStatesRequestData;
    }

    public void setUsStatesRequestData(UsStatesRequestData usStatesRequestData) {
        this.usStatesRequestData = usStatesRequestData;
    }
}
