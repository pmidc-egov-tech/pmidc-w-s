package e_gov.com.ModelApi.Auth;


import e_gov.com.ModelApi.CheckDues.CheckDueResponse;
import e_gov.com.ModelApi.CheckDues.DueRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {

    @POST("oauth/token")
    Call<AuthResponse> Auth(@Header("Authorization") String auth, @Query("ulbCode") String ulbcode, @Body AuthRequest req);

    @POST("watersewerage/dues")
    Call<CheckDueResponse> CheckDues(@Header("Authorization") String auth, @Body DueRequest req);

    //FormData Type Request

    @FormUrlEncoded
    @POST("oauth/token")
    Call<AuthResponse> Auth1(@Header("Authorization") String auth, @Query("ulbCode") String ulbcode,
                             @Field("username") String username, @Field("password") String password, @Field("grant_type") String grant_type);


}
