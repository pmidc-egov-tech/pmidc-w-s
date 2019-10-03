
package e_gov.com.ModelApi.feedback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Instrument {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("instrumentNumber")
    @Expose
    private String instrumentNumber;
    @SerializedName("transactionNumber")
    @Expose
    private String transactionNumber;
    @SerializedName("chequedddate")
    @Expose
    private String chequedddate;
    @SerializedName("chequeddno")
    @Expose
    private String chequeddno;
    @SerializedName("bank")
    @Expose
    private String bank;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstrumentNumber() {
        return instrumentNumber;
    }

    public void setInstrumentNumber(String instrumentNumber) {
        this.instrumentNumber = instrumentNumber;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getChequedddate() {
        return chequedddate;
    }

    public void setChequedddate(String chequedddate) {
        this.chequedddate = chequedddate;
    }

    public String getChequeddno() {
        return chequeddno;
    }

    public void setChequeddno(String chequeddno) {
        this.chequeddno = chequeddno;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

}
