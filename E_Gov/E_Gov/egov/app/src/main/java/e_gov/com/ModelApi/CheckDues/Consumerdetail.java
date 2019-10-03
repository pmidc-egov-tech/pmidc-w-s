package e_gov.com.ModelApi.CheckDues;

import com.google.gson.annotations.SerializedName;

public class
Consumerdetail {

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getUlbName() {
        return ulbName;
    }

    public void setUlbName(String ulbName) {
        this.ulbName = ulbName;
    }

    public String getmobileNumber() {
        return mobileNumber;
    }

    public void setmobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getemailAddress() {
        return emailAddress;
    }

    public void setemailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getservice() {
        return service;
    }

    public void setservice(String service) {
        this.service = service;
    }

    public Consumerdetail(String ownerName, String ulbName,  String mobileNumber ,String emailAddress, String service) {
        this.ownerName = ownerName;
        this.ulbName = ulbName;
        this.mobileNumber = mobileNumber;
       this.emailAddress = emailAddress;
      this.service = service;
    }

    @SerializedName("ownerName")
    private  String ownerName ;

    @SerializedName("ulbName")
    private  String ulbName ;
    @SerializedName("mobileNumber")
    private  String mobileNumber ;
    @SerializedName("emailAddress")
    private  String emailAddress ;
    @SerializedName("service")
    private  String service ;
}
