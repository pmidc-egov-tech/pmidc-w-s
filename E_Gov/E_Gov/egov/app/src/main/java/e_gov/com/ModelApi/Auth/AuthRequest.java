package e_gov.com.ModelApi.Auth;

import com.google.gson.annotations.SerializedName;

public class AuthRequest {

    public AuthRequest(String grant_type, String username, String password) {
        this.grant_type = grant_type;
        this.username = username;
        this.password = password;
    }

    @SerializedName("grant_type")
    private String grant_type ;

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @SerializedName("username")
    private String username ;

    @SerializedName("password")
    private String password ;
}
