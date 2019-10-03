package e_gov.com.Server;

import e_gov.com.ModelApi.Auth.AuthRequest;
import e_gov.com.ModelApi.Auth.AuthResponse;
import e_gov.com.ModelApi.cashback.CashbackResponse;
import e_gov.com.ModelApi.feedback.FeedbackResponse;
import e_gov.com.ModelApi.CheckDues.CashRequest;
import e_gov.com.ModelApi.CheckDues.CheckDueResponse;
import e_gov.com.ModelApi.CheckDues.DueRequest;
import e_gov.com.ModelApi.CheckDues.Payrequest;

import e_gov.com.ModelApi.Receipt.ReceiptRequest;
import e_gov.com.ModelApi.Receipt.ReceiptResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("oauth/token")
    Call<AuthResponse> Auth( @Header("Authorization")String auth,  @Query("ulbCode")String ulbcode, @Body AuthRequest req);

    @POST("watersewerage/dues")
    Call<CheckDueResponse> CheckDues(@Header("Authorization")String auth, @Body DueRequest req);

    //FormData Type Request

    @FormUrlEncoded
    @POST("oauth/token")
    Call<AuthResponse> Auth1(@Header("Authorization")String auth,@Query("ulbCode")String ulbcode,
                             @Field("username") String username,@Field("password") String password,@Field("grant_type") String grant_type);

    @FormUrlEncoded
    @POST("watersewerage/paycharges")
    Call<FeedbackResponse> feedback(@Header("Content-Type")String type,
                                    @Header("Authorization")String auth,
                                    @Field("consumerCode") String consumerCode,
                                    @Field("ulbCode") String ulbCode,
                                    @Field("paymentMode") String paymentMode,
                                    @Field("paymentAmount") String paymentAmount,
                                    @Field("paidBy") String paidBy,
                                    @Field("transactionId") String transactionId,
                                    @Field("chqddNo") String chqddNo,
                                    @Field("chqddDate")  String chqddDate,
                                    @Field("bankName")  String bankName,
                                    @Field("branchName")  String branchName,
                                    @Field("service" )String service,
                                    @Field("deviceId" )String deviceId,

                                    @Field("miscText2") String miscText2,
                                    @Field("receiptDate")String receiptDate);

    @POST("watersewerage/paycharges")
    Call<FeedbackResponse> payChargeFeedback(@Header("Content-Type")String type,
                                             @Header("Authorization")String auth, @Body Payrequest req);




    @POST("watersewerage/paycharges")
    Call<CashbackResponse> cashback(@Header("Content-Type")String type,
                                    @Header("Authorization")String auth,
                                    @Field("consumerCode") String consumerCode,
                                    @Field("ulbCode") String ulbCode,
                                    @Field("paymentMode") String paymentMode,
                                    @Field("paymentAmount") String paymentAmount,
                                    @Field("paidBy") String paidBy,
                                    @Field("transactionId") String transactionId,
                                    @Field("service")String service,
                                    @Field("deviceId")String deviceId);



//@FormUrlEncoded
    @POST("watersewerage/paycharges")
        Call<CashbackResponse> payChargeCashback(@Header("Content-Type")String type,
                                                 @Header("Authorization")String auth, @Body CashRequest req);

    @POST("collection/receipts/search")
    Call<ReceiptResponse> getReceipt(@Header("Authorization")String auth, @Body ReceiptRequest req);

}
