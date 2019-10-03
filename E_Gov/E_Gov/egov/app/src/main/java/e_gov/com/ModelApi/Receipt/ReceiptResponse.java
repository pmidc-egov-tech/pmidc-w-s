
package e_gov.com.ModelApi.Receipt;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReceiptResponse {

    @SerializedName("receiptNumber")
    @Expose
    private String receiptNumber;
    @SerializedName("receiptDate")
    @Expose
    private String receiptDate;
    @SerializedName("totalAmountpaid")
    @Expose
    private String totalAmountpaid;
    @SerializedName("consumerNumber")
    @Expose
    private String consumerNumber;
    @SerializedName("consumerName")
    @Expose
    private String consumerName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("paidBy")
    @Expose
    private String paidBy;
    @SerializedName("transactionId")
    @Expose
    private String transactionId;
    @SerializedName("deviceId")
    @Expose
    private String deviceId;
    @SerializedName("miscText1")
    @Expose
    private String miscText1;
    @SerializedName("miscText2")
    @Expose
    private String miscText2;
    @SerializedName("accountHeader")
    @Expose
    private List<AccountHeader> accountHeader = null;
    @SerializedName("instruments")
    @Expose
    private List<Instrument> instruments = null;
    @SerializedName("paidFrom")
    @Expose
    private String paidFrom;
    @SerializedName("paidTo")
    @Expose
    private String paidTo;
    @SerializedName("ulbName")
    @Expose
    private String ulbName;
    @SerializedName("ulbCode")
    @Expose
    private String ulbCode;
    @SerializedName("service")
    @Expose
    private String service;

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

    public String getMiscText1() {
        return miscText1;
    }

    public void setMiscText1(String miscText1) {
        this.miscText1 = miscText1;
    }

    public String getMiscText2() {
        return miscText2;
    }

    public void setMiscText2(String miscText2) {
        this.miscText2 = miscText2;
    }

    public List<AccountHeader> getAccountHeader() {
        return accountHeader;
    }

    public void setAccountHeader(List<AccountHeader> accountHeader) {
        this.accountHeader = accountHeader;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
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

}
