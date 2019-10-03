package e_gov.com.ModelApi.CheckDues;

import com.google.gson.annotations.SerializedName;

/**
 * Created by IT-Meeting on 03-07-2019.
 */

public class Payrequest {



    @SerializedName("consumerCode")
    private String consumerCode ;

    @SerializedName("ulbCode")
    private String ulbCode ;

    @SerializedName("paymentMode")
    private String paymentMode ;

    @SerializedName("paymentAmount")
    private String paymentAmount ;

    @SerializedName("paidBy")
    private String paidBy ;


    @SerializedName("transactionId")
    private String transactionId ;

    @SerializedName("transactionNumber")
    private String transactionNumber ;

    @SerializedName("instrumentNumber")
    private String instrumentNumber ;
    @SerializedName("service")
    private String service ;

    @SerializedName("deviceId")
    private String deviceId ;



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

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }
    public String getInstrumentNumber() {
        return instrumentNumber;
    }

    public void setInstrumentNumber(String instrumentNumber) {
        this.instrumentNumber = instrumentNumber;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

}
