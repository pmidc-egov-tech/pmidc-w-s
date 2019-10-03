
package e_gov.com.ModelApi.Receipt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountHeader {

    @SerializedName("accountHead")
    @Expose
    private String accountHead;
    @SerializedName("paidAmount")
    @Expose
    private String paidAmount;

    public String getAccountHead() {
        return accountHead;
    }

    public void setAccountHead(String accountHead) {
        this.accountHead = accountHead;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

}
