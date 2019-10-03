package e_gov.com.ModelApi.CheckDues;

import com.google.gson.annotations.SerializedName;

public class CheckDueResponse {
    public Consumerdetail getConsumerDetails() {
        return consumerDetails;
    }

    public void setConsumerDetails(Consumerdetail consumerDetails) {
        this.consumerDetails = consumerDetails;
    }

    public e_gov.com.ModelApi.CheckDues.DueDetails getDueDetails() {
        return DueDetails;
    }

    public void setDueDetails(e_gov.com.ModelApi.CheckDues.DueDetails dueDetails) {
        DueDetails = dueDetails;
    }

    public CheckDueResponse(Consumerdetail consumerDetails, e_gov.com.ModelApi.CheckDues.DueDetails dueDetails) {
        this.consumerDetails = consumerDetails;
        DueDetails = dueDetails;
    }

    @SerializedName("consumerDetails")
    private Consumerdetail consumerDetails;

    @SerializedName("dueDetails")
    private DueDetails DueDetails;

}
