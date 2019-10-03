package e_gov.com.Server;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import e_gov.com.Utils.SharedPrefrences;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

//  public static final String BASE_URL = "http://18.188.223.209/api/v1/";
 public static final String BASE_URL = "https://sunam-uat.egovernments.org/restapi/";
 public static final String PAYCHARGE_BASE_URL = "https://sunam-uat.egovernments.org/restapi/";

    private static Retrofit retrofit = null;
    public static String Auth ="Basic cG9zLWNsaWVudDoxMjM0NTY3OA==";
 public static String Auth2 ="Bearer a2f366c1-03d7-4ac4-82c2-19014dff0617";



//SharedPrefrences.get_token(this)
    public static Retrofit getClient() {


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level .BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)

                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getClientPaycharge() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level .BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                 //   .baseUrl(
                   //         PAYCHARGE_BASE_URL)
                     .baseUrl("https://sunam-uat.egovernments.org/restapi/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofit;
    }
}
