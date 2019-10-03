package e_gov.com.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.eze.api.EzeAPI;

import org.json.JSONException;
import org.json.JSONObject;

import e_gov.com.Ezetap.Setting;
import e_gov.com.R;
import e_gov.com.Utils.SharedPrefrences;
import android.os.Handler;

import java.io.File;
public class LoginDetail extends Activity implements View.OnClickListener {
    Handler mHandler;
    String  Auth2="";
    EditText et_pswd;
    private ImageView back;
    private TextView user;
    private TextView hint;
    private final int REQUEST_CODE_INITIALIZE = 10001;
    private final int REQUESTCODE_PREP=10002;
    private Intent intent;
    String successvar = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        back = (ImageView) findViewById(R.id.back);
        user = (TextView) findViewById(R.id.user);
        hint = (TextView) findViewById(R.id.hint);
        findViewById(R.id.submit).setOnClickListener(this);
        // EzeConstants.AppMode appMode = EzeConstants.AppMode.EZETAP_DEMO;
        if (SharedPrefrences.getDoAutoLogin(this)){
            SharedPrefrences.setDoAutoLogin(this,false);
            doInitializeEzeTap(SharedPrefrences.getUsername(this),SharedPrefrences.getPassword(this));
        }
    }


    private void doInitializeEzeTap(String userName,String password) {
        JSONObject jsonRequest = new JSONObject();
        if (Setting.config != null) {
            try {

                jsonRequest.put("demoAppKey", Setting.config.getAppKey());
                jsonRequest.put("prodAppKey", Setting.config.getAppKey());
                jsonRequest.put("merchantName", Setting.config.getMerchantName());
                jsonRequest.put("userName", Setting.config.getUsername());
                jsonRequest.put("currencyCode", "INR");
                jsonRequest.put("appMode", Setting.config.getAppMode());
                jsonRequest.put("captureSignature", "true");
                jsonRequest.put("prepareDevice", "false");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else {
            try {

                jsonRequest.put("loginType", "USERID");
                jsonRequest.put("demoAppKey", "1a1e3805-394e-4928-a95e-1d1f61085677");
                jsonRequest.put("prodAppKey", "1a1e3805-394e-4928-a95e-1d1f61085677");
                jsonRequest.put("merchantName", " PUNJAB_MUNICIPAL_INFRASTR");
                jsonRequest.put("userName", userName);
                jsonRequest.put("password", password);
                jsonRequest.put("currencyCode", "INR");
                jsonRequest.put("appMode", "Demo");
                jsonRequest.put("captureSignature", "true");
                jsonRequest.put("prepareDevice", "false");
            } catch (JSONException e) {
                e.printStackTrace();


            }
        }
        EzeAPI.initialize(this, REQUEST_CODE_INITIALIZE, jsonRequest);

        /**********************************************

         **********************************************/
    }


    private EditText getEtUsername(){
        return (EditText) findViewById(R.id.et_username);
    }

    private EditText getEtPswd(){
        return (EditText) findViewById(R.id.et_pswd);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:
                //TODO implement
                String email=getEtUsername().getText().toString().trim();
                String password=getEtPswd().getText().toString().trim();
                SharedPrefrences.setUsername(LoginDetail.this,email);
                SharedPrefrences.setPassword(LoginDetail.this,password);
                doInitializeEzeTap(email,password);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("SampleAppLogs", "requestCode = " + requestCode + "resultCode = " + resultCode);

        if(requestCode==REQUEST_CODE_INITIALIZE){
            if( resultCode==RESULT_OK) {
                String refNo = "";
                try{
                    refNo =  new JSONObject(data.getStringExtra("response")).getJSONObject("result").getString("externalRef");

                    SharedPrefrences.set_ref(getApplicationContext(), refNo);

                    Intent intent = new Intent(LoginDetail.this, CheckduesActivity.class);
                    intent.putExtra("ref", refNo);
                    startActivity(intent);
                    Animatoo.animateSwipeLeft(LoginDetail.this);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(this, "Invalid ULB Code", Toast.LENGTH_SHORT).show();
                }

            }
            else {
                Toast.makeText(this, "Credentials error", Toast.LENGTH_SHORT).show();
            }

        }


        System.out.println("-------------------------------------"+"requestCode = " + requestCode + "resultCode = " + resultCode);

    }
}






