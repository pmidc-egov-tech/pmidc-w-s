package e_gov.com.ModelApi.Auth;

import com.google.gson.annotations.SerializedName;

public class AuthResponse {

    public AuthResponse(String access_token, String token_type) {
        this.access_token = access_token;
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    @SerializedName("access_token")
    private String access_token ;


    @SerializedName("token_type")
    private String token_type ;
    @SerializedName("refresh_token")
    private String refresh_token ;

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}

