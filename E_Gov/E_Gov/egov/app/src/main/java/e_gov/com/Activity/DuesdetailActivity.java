package e_gov.com.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.Button;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import e_gov.com.R;
import e_gov.com.Utils.SharedPrefrences;

public class DuesdetailActivity extends Activity  {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.hint) TextView hint;
    @BindView(R.id.et_consumer_Name) TextView etConsumerName;
    @BindView(R.id.ulbhint) TextView ulbhint;
    @BindView(R.id.et_ulbname) TextView etUlbname;
    @BindView(R.id.ambhint) TextView ambhint;
    @BindView(R.id.et_amtdue) TextView etAmtdue;
    @BindView(R.id.mblhint) TextView mblhint;
    @BindView(R.id.et_mobile_no) TextView etMobileNumber;
    @BindView(R.id.billhint) TextView billhint;
    @BindView(R.id.et_bill_date) TextView etBilldate;
    @BindView(R.id.servicehint) TextView servicehint;
    @BindView(R.id.et_service) TextView etService;
    @BindView(R.id.emailhint) TextView emailhint;
    @BindView(R.id.et_email_adrs) TextView etEmailAddress;
    @BindView(R.id.payhint) TextView payhint;
    @BindView(R.id.et_pay) EditText et_pay;
    @BindView(R.id.btn_logout)
    Button btn_logout;
    Bundle bundle = new Bundle();
    private String pay;
    private String mobileNo;
    String Serviceval = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duesdetail);
        ButterKnife.bind(this);
        bundle = getIntent().getExtras();
        if (bundle != null) {
            etConsumerName.setText(  bundle.getString("name"));
            etUlbname.setText(   bundle.getString("ulbname"));
            etAmtdue.setText(   bundle.getString("amount"));
            etMobileNumber.setText(   bundle.getString("mobilenumber"));
            etBilldate.setText(   bundle.getString("billdate"));
            etEmailAddress.setText(   bundle.getString("emailaddress"));
            etService.setText(   bundle.getString("service"));
            Serviceval=bundle.getString("service");
            SharedPrefrences.setservice(this,Serviceval);
        }

    }


    @OnClick(R.id.btn_logout)
    void setBtn_logout() {

        Intent vn = new Intent(DuesdetailActivity.this,
                LoginDetail.class);
        startActivity(vn);
        finish();

        //TODO implement
        finish();
        Animatoo.animateSlideRight(DuesdetailActivity.this);

    }
    //pay now button
    @OnClick(R.id.submit) void onSubmitClick() {
        //TODO implement
        if(!TextUtils.isEmpty(et_pay.getText().toString()) && !etAmtdue.getText().toString().equalsIgnoreCase("0.00")){

            pay = et_pay.getText().toString();
            SharedPrefrences.setPayAmount(this,pay);

            Intent i = new Intent(DuesdetailActivity.this,PaymentoptionActivity.class);
            i.putExtra("mobilenumber",mobileNo);
            i.putExtra("email",bundle.getString("email"));
            i.putExtra("name", bundle.getString("name"));
            // i.putExtra("ulbname",message.getConsumerDetails().getUlbName());
            i.putExtra("amount",  pay );
            startActivity(i);
            Animatoo.animateSwipeLeft(DuesdetailActivity.this);
            //


        } else {
            Toast.makeText(this, "Amount must be greater than 0", Toast.LENGTH_SHORT).show();
            pay =bundle.getString("amount");

            SharedPrefrences.setPayAmount(this,pay);
        }

    }

    @OnClick(R.id.back) void back() {
        //TODO implement
        finish();
        Animatoo.animateSlideRight(DuesdetailActivity.this);

    }

    @Override
    public void onBackPressed() {

        finish();
        Animatoo.animateSlideRight(DuesdetailActivity.this);

    }
}
