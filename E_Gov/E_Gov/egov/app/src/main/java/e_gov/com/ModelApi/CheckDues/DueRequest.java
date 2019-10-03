package e_gov.com.ModelApi.CheckDues;

import com.google.gson.annotations.SerializedName;

public class DueRequest {

    @SerializedName("consumerCode")
    private String consumerCode ;

    @SerializedName("ulbCode")
    private String ulbCode ;

    public String getConsumerCode() {
        return consumerCode;
    }

    public void setConsumerCode(String consumerCode) {
        this.consumerCode = consumerCode;
    }

    public String getUlbCode() {
        return ulbCode;
    }

    public void setUlbCode(String ulbCode) {
        this.ulbCode = ulbCode;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public DueRequest(String consumerCode, String ulbCode, String service) {
        this.consumerCode = consumerCode;
        this.ulbCode = ulbCode;
        this.service = service;
    }

    @SerializedName("service")
    private String service ;
}
