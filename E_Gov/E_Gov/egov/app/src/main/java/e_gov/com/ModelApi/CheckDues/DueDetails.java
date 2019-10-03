package e_gov.com.ModelApi.CheckDues;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class DueDetails {


    public String getTotalChargesDue() {
        return totalChargesDue;
    }

    public void setTotalChargesDue(String totalChargesDue) { this.totalChargesDue = totalChargesDue; }

    public String getbillDate() {
        return billDate;
    }

    public void setbillDate(String billDate) { this.billDate = billDate; }

    public DueDetails(String totalChargesDue , String billDate) {
        this.totalChargesDue = totalChargesDue;
        this.billDate = billDate;
    }

    @SerializedName("totalChargesDue")
    private String totalChargesDue ;

    @SerializedName("billDate")
    private String billDate ;



}
