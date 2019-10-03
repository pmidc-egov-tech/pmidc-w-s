package e_gov.com.ModelApi.cashback;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by IT-Meeting on 08-07-2019.
 */

public class CashbackResponse {

    @SerializedName("receiptNumber")
    private String receiptNumber ;
    @SerializedName("receiptDate")
    private String receiptDate ;
    @SerializedName("totalAmountpaid")
    private String totalAmountpaid ;
    @SerializedName("consumerNumber")
    private String consumerNumber ;
    @SerializedName("consumerName")
    private String consumerName ;
    @SerializedName("address")
    private String address ;
    @SerializedName("paidBy")
    private String paidBy ;
    @SerializedName("transactionId")
    private String transactionId ;
    @SerializedName("deviceId")
    private String deviceId ;
    @SerializedName("miscText1")
    private String miscText1 ;
    @SerializedName("miscText2")
    private String miscText2 ;

    @SerializedName("receiptDetails")
    private List<JsonObject> receiptDetails;
    @SerializedName("instruments")
    private List<Instrument> instruments = null;

    @SerializedName("paidFrom")
    private String paidFrom ;
    @SerializedName("paidTo")
    private String paidTo ;
    @SerializedName("ulbName")
    private String ulbName ;
    @SerializedName("ulbCode")
    private String ulbCode ;
    @SerializedName("service")
    private String service ;

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getTotalAmountpaid() {
        return totalAmountpaid;
    }

    public void setTotalAmountpaid(String totalAmountpaid) {
        this.totalAmountpaid = totalAmountpaid;
    }

    public String getConsumerNumber() {
        return consumerNumber;
    }

    public void setConsumerNumber(String consumerNumber) {
        this.consumerNumber = consumerNumber;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getMiscText2() {
        return miscText2;
    }

    public void setMiscText2(String miscText2) {
        this.miscText2 = miscText2;
    }

    public String getPaidFrom() {
        return paidFrom;
    }

    public void setPaidFrom(String paidFrom) {
        this.paidFrom = paidFrom;
    }

    public String getPaidTo() {
        return paidTo;
    }

    public void setPaidTo(String paidTo) {
        this.paidTo = paidTo;
    }

    public String getUlbName() {
        return ulbName;
    }

    public void setUlbName(String ulbName) {
        this.ulbName = ulbName;
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

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }
}
