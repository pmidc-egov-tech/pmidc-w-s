package e_gov.com.Server;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;


import e_gov.com.ModelApi.Auth.AuthRequest;
import e_gov.com.ModelApi.Auth.AuthResponse;
import e_gov.com.ModelApi.feedback.FeedbackResponse;
import e_gov.com.ModelApi.cashback.CashbackResponse;
import e_gov.com.ModelApi.CheckDues.CashRequest;
import e_gov.com.ModelApi.CheckDues.CheckDueResponse;
import e_gov.com.ModelApi.CheckDues.DueRequest;
import e_gov.com.ModelApi.CheckDues.Payrequest;

import e_gov.com.ModelApi.Receipt.ReceiptRequest;
import e_gov.com.ModelApi.Receipt.ReceiptResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class  DataManager {

    ApiInterface apiService;




    public interface AuthCallback{
        void onSucess(int status, AuthResponse message) throws JSONException;
        void onError(int status, ResponseBody error);
        void onFailure();
        void onNetworkFailur();
    }

    public void Auth(String Header, String Ulb, AuthRequest req, final AuthCallback callback){
        apiService.Auth(Header,Ulb,req).enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                int statusCode = response.code();

                try {
                    if(statusCode == 200){
                        callback.onSucess(statusCode,response.body());
                    }else if(statusCode == 422){
                        callback.onError(statusCode,response.errorBody());
                    }else if(statusCode == 401){
                        callback.onError(statusCode,response.errorBody());
                    }else if(statusCode == 406){
                        callback.onError(statusCode,response.errorBody());
                    } else if (statusCode == 402) {
                        callback.onError(statusCode, response.errorBody());
                    }else if (statusCode == 404) {
                        callback.onError(statusCode, response.errorBody());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                // Log error here since request failed
                if (t instanceof IOException) {
                    // Network error
                    callback.onNetworkFailur();
                }else{
                    callback.onFailure();
                }
            }
        });
    }
    public interface Auth1Callback{
        void onSucess(int status, AuthResponse message) throws JSONException;
        void onError(int status, ResponseBody error);
        void onFailure();
        void onNetworkFailur();
    }

    public interface FeedbackCallback{
        void onSucess(int status, FeedbackResponse message) throws JSONException;
        void onError(int status, ResponseBody error);
        void onFailure();
        void onNetworkFailur();
    }
    public interface CashbackCallback{
        void onSucess(int status, CashbackResponse message) throws JSONException;
        void onError(int status, ResponseBody error);
        void onFailure();
        void onNetworkFailur();
    }
    public void Auth1(String Header, String Ulb, String username,String password, String type , final Auth1Callback callback){
        apiService.Auth1(Header,Ulb,username,password,type).enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                int statusCode = response.code();

                try {
                    if(statusCode == 200){
                        callback.onSucess(statusCode,response.body());
                    }else if(statusCode == 422){
                        callback.onError(statusCode,response.errorBody());
                    }else if(statusCode == 401){
                        callback.onError(statusCode,response.errorBody());
                    }else if(statusCode == 406){
                        callback.onError(statusCode,response.errorBody());
                    } else if (statusCode == 402) {
                        callback.onError(statusCode, response.errorBody());
                    }else if (statusCode == 404) {
                        callback.onError(statusCode, response.errorBody());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                // Log error here since request failed
                if (t instanceof IOException) {
                    // Network error
                    callback.onNetworkFailur();
                }else{
                    callback.onFailure();
                }

            }
        });
    }

    public void cashback(String Auth,String consumerCode, String ulbCode, String paymentMode,
                         String paymentAmount, String paidBy, String transactionId, String service, String deviceId,

                         final CashbackCallback callback){

        final CashRequest cashrequest = new CashRequest();
        cashrequest.setConsumerCode(consumerCode);
        cashrequest.setUlbCode(ulbCode);
        cashrequest.setPaymentMode(paymentMode);
        cashrequest.setPaymentAmount( paymentAmount);
        cashrequest.setPaidBy(paidBy);
        cashrequest.setTransactionId( transactionId);
        cashrequest.setService(service);
        cashrequest.setDeviceId( deviceId);

        apiService.payChargeCashback("application/json",Auth,cashrequest).enqueue(new Callback<CashbackResponse>() {
            @Override
            public void onResponse(Call<CashbackResponse> call, Response<CashbackResponse> response) {

                Log.v("Response Code",String.valueOf(response.code()));
                //  Log.v("TAG", "Actual Response" + response.body().getConsumerName() );
                Log.v("Actual Response" , response.body().getConsumerName() );
                int statusCode = response.code();
                try {
                    if(statusCode == 200){
                        callback.onSucess(statusCode,response.body());
                    }else if(statusCode == 422){
                        callback.onError(statusCode,response.errorBody());
                    }else if(statusCode == 401){
                        callback.onError(statusCode,response.errorBody());
                    }else if(statusCode == 406){
                        callback.onError(statusCode,response.errorBody());
                    } else if (statusCode == 402) {
                        callback.onError(statusCode, response.errorBody());
                    }else if (statusCode == 404) {
                        callback.onError(statusCode, response.errorBody());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<CashbackResponse> call, Throwable t) {
                Log.e("TAG", "Cashcharge onFailure: " + t.getLocalizedMessage() );
            }
        });


    }
    public void feedback(String Auth,String consumerCode, String ulbCode, String paymentMode,
                         String paymentAmount, String paidBy, String transactionId,String transactionNumber,String instrumentNumber,
                         String service, String deviceId,

                         final FeedbackCallback callback){
        final Payrequest payrequest = new Payrequest();

        payrequest.setConsumerCode(consumerCode);
        payrequest.setUlbCode(ulbCode);
        payrequest.setPaymentMode(paymentMode);
        payrequest.setPaymentAmount( paymentAmount);
        payrequest.setPaidBy(paidBy);
        payrequest.setTransactionId( transactionId);
        payrequest .setTransactionNumber(transactionNumber);
        payrequest .setInstrumentNumber(instrumentNumber);
        payrequest.setService(service);
        payrequest.setDeviceId( deviceId);

        apiService.payChargeFeedback("application/json",Auth,payrequest).enqueue(new Callback<FeedbackResponse>() {
            @Override
            public void onResponse(Call<FeedbackResponse> call, Response<FeedbackResponse> response) {

                Log.v("Response Code",String.valueOf(response.code()));
                //  Log.v("TAG", "Actual Response" + response.body().getConsumerName() );
                Log.v("Actual Response" , response.body().getConsumerName() );
                int statusCode = response.code();
                try {
                    if(statusCode == 200){
                        callback.onSucess(statusCode,response.body());
                    }else if(statusCode == 422){
                        callback.onError(statusCode,response.errorBody());
                    }else if(statusCode == 401){
                        callback.onError(statusCode,response.errorBody());
                    }else if(statusCode == 406){
                        callback.onError(statusCode,response.errorBody());
                    } else if (statusCode == 402) {
                        callback.onError(statusCode, response.errorBody());
                    }else if (statusCode == 404) {
                        callback.onError(statusCode, response.errorBody());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<FeedbackResponse> call, Throwable t) {
                Log.e("TAG", "Paycharge onFailure: " + t.getLocalizedMessage() );
            }
        });

    }



    public interface CheckDuesCallback{
        void onSucess(int status, CheckDueResponse message) throws JSONException;
        void onError(int status, ResponseBody error);
        void onFailure();
        void onNetworkFailur();
    }

    public void CheckDues(String Header, DueRequest req, final CheckDuesCallback callback){
        apiService.CheckDues(Header,req).enqueue(new Callback<CheckDueResponse>() {
            @Override
            public void onResponse(Call<CheckDueResponse> call, Response<CheckDueResponse> response) {
                int statusCode = response.code();
                System.out.println("-----------------------------------code status-----------------------"+statusCode);
                try {
                    if(statusCode == 200){
                        callback.onSucess(statusCode,response.body());
                    }else if(statusCode == 422){
                        callback.onError(statusCode,response.errorBody());
                    }else if(statusCode == 401){
                        callback.onError(statusCode,response.errorBody());
                    }else if(statusCode == 406){
                        callback.onError(statusCode,response.errorBody());
                    } else if (statusCode == 402) {
                        callback.onError(statusCode, response.errorBody());
                    }else if (statusCode == 404) {
                        callback.onError(statusCode, response.errorBody());
                    }else if(statusCode==400){
                        callback.onSucess(statusCode,response.body());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<CheckDueResponse> call, Throwable t) {
                // Log error here since request failed
                if (t instanceof IOException) {
                    // Network error
                    callback.onNetworkFailur();
                }else{
                    callback.onFailure();
                    System.out.println("---------------------------------api fails----------"+t.getMessage());
                }

            }
        });
    }

    public void getReceipt(String Header, ReceiptRequest req, final GetReceiptCallback callback){
        apiService.getReceipt(Header,req).enqueue(new Callback<ReceiptResponse>() {
            @Override
            public void onResponse(Call<ReceiptResponse> call, Response<ReceiptResponse> response) {
                int statusCode = response.code();

                try {
                    if(statusCode == 200){
                        callback.onSucess(statusCode,response.body());
                    }else if(statusCode == 422){
                        callback.onError(statusCode,response.errorBody());
                    }else if(statusCode == 401){
                        callback.onError(statusCode,response.errorBody());
                    }else if(statusCode == 406){
                        callback.onError(statusCode,response.errorBody());
                    } else if (statusCode == 402) {
                        callback.onError(statusCode, response.errorBody());
                    }else if (statusCode == 404) {
                        callback.onError(statusCode, response.errorBody());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ReceiptResponse> call, Throwable t) {
                // Log error here since request failed
                if (t instanceof IOException) {
                    // Network error
                    callback.onNetworkFailur();
                }else{
                    callback.onFailure();
                }
            }
        });
    }

    public interface GetReceiptCallback{
        void onSucess(int status, ReceiptResponse message) throws JSONException;
        void onError(int status, ResponseBody error);
        void onFailure();
        void onNetworkFailur();
    }

    public DataManager() {
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    public DataManager(Context context){
        apiService = ApiClient.getClientPaycharge().create(ApiInterface.class);
    }


}
