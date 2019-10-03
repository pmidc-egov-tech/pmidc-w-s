package e_gov.com.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import org.json.JSONException;

import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import e_gov.com.ModelApi.Auth.AuthRequest;
import e_gov.com.ModelApi.Auth.AuthResponse;
import e_gov.com.ModelApi.CheckDues.CheckDueResponse;
import e_gov.com.ModelApi.CheckDues.DueRequest;
import e_gov.com.R;
import e_gov.com.Server.ApiClient;
import e_gov.com.Server.DataManager;
import e_gov.com.Server.DataManager.Auth1Callback;
import e_gov.com.Server.progresBar;
import e_gov.com.Utils.SharedPrefrences;
import e_gov.com.Utils.UtilsMethods;
import okhttp3.ResponseBody;

public class CheckduesActivity extends Activity implements DataManager.Auth1Callback,DataManager.CheckDuesCallback {
    // @BindView(R.id.back) ImageView logout;
    @BindView(R.id.back) ImageView back;
    @BindView(R.id.hint) TextView hint;
    @BindView(R.id.btn_logout)
    Button btn_logout;
    @BindView(R.id.et_consumer_No) EditText etConsumerNo;
    String firstFourChars = "";
    DataManager manager;
    progresBar progress ;
    DataManager.Auth1Callback   call;

    @BindView(R.id.planets_spinner)
    public Spinner spinner;
    private static final String[] paths = {"item 1", "item 2"};
    private String service;

    private String ref = "";
    private int resultCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkdues);
        ButterKnife.bind(this);
        call = this;
        manager = new DataManager();
        progress = new progresBar(this);

        ref = SharedPrefrences.get_ref(getApplicationContext());//getIntent().getStringExtra("ref");
    }

    @OnClick(R.id.btn_logout)
    void setBtn_logout() {

        Intent vn = new Intent(CheckduesActivity.this,
                LoginDetail.class);
        startActivity(vn);
        finish();

        //TODO implement
        finish();
        Animatoo.animateSlideRight(CheckduesActivity.this);

    }

    @OnClick(R.id.submit) void onSubmitClick() {
        //TODO implement
        System.out.println("CheckduesActivity.onSubmitClick :: ref :: "+ ref);
        if (etConsumerNo.getText().toString().length()==0){

            UtilsMethods.ShakeEditText(etConsumerNo);
        }else {
            String input = etConsumerNo.getText().toString();
            SharedPrefrences.setConsumerNo(this, input);
            //substring containing first 4 characters

            if (input.length() > 4) {
                firstFourChars = input.substring(0, 4);
            } else {
                firstFourChars = input;
            }

            if (input.startsWith(ref)) {
                progress.Show();
                // AuthRequest req = new AuthRequest("password","restapi_test","12345678");

                service = spinner.getSelectedItem().toString();

                manager.Auth1(ApiClient.Auth, firstFourChars, "restapi_test", "12345678", "password", call);
            } else {
                Toast.makeText(this, "ULB Code didn't match with this consumer no", Toast.LENGTH_SHORT).show();
            }
        }

        }


    @Override
    public void onSucess(int status, AuthResponse message) throws JSONException {

        Log.v("JSONRST", "JSONRST");

        if (status==200){

            SharedPrefrences.set_token(this,message.getToken_type()+" "+message.getAccess_token());
            SharedPrefrences.set_refresh_token(this,message.getToken_type()+" "+message.getRefresh_token());
            Log.e("Token ",">>>>   "+ SharedPrefrences.get_token(this));
            Log.v("TOKEN IS",  SharedPrefrences.get_token(this));
            DueRequest req = new DueRequest(etConsumerNo.getText().toString(),firstFourChars,service);
            manager.CheckDues(SharedPrefrences.get_token(this),req,this);
              }else{


            progress.Dismiss();
            Toast.makeText(this, "Invalid Consumer Number", Toast.LENGTH_SHORT).show();
             }

        }



    @Override
    public void onError(int status, ResponseBody error) {
        System.out.println("------------------------error-------------");
    }

    @Override
    public void onSucess(int status, CheckDueResponse message) throws JSONException {

        progress.Dismiss();
        if (status == 200) {
            Intent i = new Intent(CheckduesActivity.this, DuesdetailActivity.class);
            i.putExtra("name", message.getConsumerDetails().getOwnerName());
            i.putExtra("ulbname", message.getConsumerDetails().getUlbName());
            i.putExtra("mobilenumber", message.getConsumerDetails().getmobileNumber());
            i.putExtra("emailaddress", message.getConsumerDetails().getemailAddress());
            i.putExtra("service", message.getConsumerDetails().getservice());
            i.putExtra("amount", message.getDueDetails().getTotalChargesDue());
            i.putExtra("billdate", message.getDueDetails().getbillDate());
            startActivity(i);
            Animatoo.animateSwipeLeft(CheckduesActivity.this);
        }else {
            Toast.makeText(this, "Invalid Consumer Number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure() {
System.out.println("--------------------------fails--------------------------");
    }

    @Override
    public void onNetworkFailur() {
    }

    @OnClick(R.id.back) void back() {
        //TODO implement
        Intent vn = new Intent(CheckduesActivity.this,
                LoginDetail.class);
        startActivity(vn);
        finish();

    }

    @Override
    public void onBackPressed() {

        finish();
        Animatoo.animateSlideRight(CheckduesActivity.this);

    }
}
