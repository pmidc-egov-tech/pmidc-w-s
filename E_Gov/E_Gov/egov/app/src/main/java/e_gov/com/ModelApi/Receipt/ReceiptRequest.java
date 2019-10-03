package e_gov.com.ModelApi.Receipt;

import com.google.gson.annotations.SerializedName;

public class ReceiptRequest {

    @SerializedName("consumerCode")
    private String consumerCode ;

    @SerializedName("ulbCode")
    private String ulbCode ;

    @SerializedName("service")
    private String service ;

    @SerializedName("receiptNumber")
    private String receiptNumber;

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

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

    public ReceiptRequest(String consumerCode, String ulbCode, String service,String receiptNumber) {
        this.consumerCode = consumerCode;
        this.ulbCode = ulbCode;
        this.service = service;
        this.receiptNumber = receiptNumber;
    }

}
