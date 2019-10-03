package e_gov.com.Activity;


import android.app.AlertDialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.RequiresApi;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.eze.api.EzeAPI;
import com.ezetap.sdk.EzeConstants;
import java.io.ByteArrayOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import e_gov.com.Ezetap.Setting;
import e_gov.com.ModelApi.cashback.CashbackResponse;
import e_gov.com.ModelApi.feedback.FeedbackResponse;
import e_gov.com.R;
import e_gov.com.Server.DataManager;
import e_gov.com.Server.progresBar;
import e_gov.com.Utils.SharedPrefrences;
import okhttp3.ResponseBody;

public class PaymentoptionActivity extends Activity implements DataManager.FeedbackCallback,
        DataManager.CashbackCallback {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.btn_logout)
    Button btn_logout;

    private final int REQUEST_CODE_INITIALIZE = 10001;
    private final int REQUEST_CODE_PREPARE = 10002;
    private final int REQUEST_CODE_WALLET_TXN = 10003;
    private final int REQUEST_CODE_CHEQUE_TXN = 10004;
    private final int REQUEST_CODE_SALE_TXN = 10006;
    private final int REQUEST_CODE_CASH_BACK_TXN = 10007;
    private final int REQUEST_CODE_CASH_AT_POS_TXN = 10008;
    private final int REQUEST_CODE_CASH_TXN = 10009;
    private final int REQUEST_CODE_SEARCH = 10010;
    private final int REQUEST_CODE_VOID = 10011;
    private final int REQUEST_CODE_ATTACH_SIGN = 10012;
    private final int REQUEST_CODE_UPDATE = 10013;
    private final int REQUESTCODE_CHEQUE = 100086;
    private final int REQUEST_CODE_CLOSE = 10014;
    private final int REQUEST_CODE_GET_TXN_DETAIL = 10015;
    private final int REQUEST_CODE_GET_INCOMPLETE_TXN = 10016;
    private final int REQUEST_CODE_PAY = 10017;
    private final int REQUEST_CODE_UPI = 10018;
    private final int REQUEST_CODE_REMOTE_PAY = 10019;
    private final int REQUEST_CODE_QR_CODE_PAY = 10020;
    private final int REQUEST_CODE_NORMAL_EMI = 10021;
    private final int REQUEST_CODE_BRAND_EMI = 10022;
    private final int REQUEST_CODE_PRINT_RECEIPT = 10021;
    private final int REQUEST_CODE_PRINT_BITMAP = 10022;
    private final int REQUESTCODE_CASH = 10005;
    //private final int REQUEST_CODE_CHEQUE_TXN = 100086;
    private String mandatoryErrMsg = "Please fill up mandatory params.";
    private String name, amount, mobilenumber, email;
    Bundle bundle = new Bundle();
    DataManager manager;
    DataManager.FeedbackCallback feedbackCallback;
    DataManager.CashbackCallback cashbackCallback;
    DataManager.GetReceiptCallback receiptCallback;
    progresBar progress;
    String Auth2 = "";
    String successvar = "";
    private ProgressDialog progressDialog;
    String bankName = "";
    String branchName = "";
    String chqddDate = "";
    String chqddNo = "";
    String consumerCode = "";
    String deviceId = "";
    String instrumentNumber = "";
    String miscText2 = "";
    String paidBy = "";
    String paymentAmount = "";
    String paymentMode = "";
    String service = "";
    String transactionId = "";
    String transactionNumber = "";
    String ulbCode = "";
    private ImageView img;
    Context context;
    /**
     * unique ID for a transaction in EzeTap EMI Id associated with the
     * transaction
     */
    private String strTxnId = null, emiID = null;
    /**
     * Error message
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paymentoption);
        ButterKnife.bind(this);
        feedbackCallback = this;
        cashbackCallback = this;
        context = PaymentoptionActivity.this;
        bundle = getIntent().getExtras();
        manager = new DataManager(this);
        progress = new progresBar(this);

        if (bundle != null) {
            name = bundle.getString("name");
            amount = bundle.getString("amount");
            mobilenumber = bundle.getString("mobilenumber");
            email = bundle.getString("email");
        }

        EzeConstants.AppMode appMode = EzeConstants.AppMode.EZETAP_DEMO;
        doInitializeEzeTap();
    }


    private void doInitializeEzeTap() {
        JSONObject jsonRequest = new JSONObject();
        if (Setting.config != null) {

            try {
                jsonRequest.put("demoAppKey", "1a1e3805-394e-4928-a95e-1d1f61085677");
                jsonRequest.put("prodAppKey", "1a1e3805-394e-4928-a95e-1d1f61085677");
                jsonRequest.put("merchantName", " PUNJAB_MUNICIPAL_INFRASTR");
                jsonRequest.put("userName", "");
                jsonRequest.put("currencyCode", "INR");
                jsonRequest.put("appMode", "Demo");
                jsonRequest.put("captureSignature", "true");
                jsonRequest.put("prepareDevice", "false");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            try {
                jsonRequest.put("demoAppKey", "1a1e3805-394e-4928-a95e-1d1f61085677");
                jsonRequest.put("prodAppKey", "1a1e3805-394e-4928-a95e-1d1f61085677");
                jsonRequest.put("merchantName", " PUNJAB_MUNICIPAL_INFRASTR");
                jsonRequest.put("userName", "");
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

    @OnClick(R.id.Online)
    void onOnlineClick() {
        //TODO implement

        //    Intent in= new Intent(this, EzeNativeSampleActivity.class);
        //      startActivity(in);

        JSONObject jsonRequest = new JSONObject();
        try {
            jsonRequest = new JSONObject();
            JSONObject jsonOptionalParams = new JSONObject();
            JSONObject jsonReferences = new JSONObject();
            JSONObject josnAdtionakRefrence = new JSONObject();

//            jsonReferences.put("reference1", UIDNo+ "_gtax");
//
//            jsonReferences.put("reference3", "gtax");



            int refNo = SharedPrefrences.getRefNo(PaymentoptionActivity.this);
            // Building References Object
            jsonReferences.put("reference1", "ref" + refNo);
            SharedPrefrences.setReferenceNo(PaymentoptionActivity.this, (refNo + 1));

            // Passing Additional References
            JSONArray array = new JSONArray();
            array.put("addRef_xx1");
            array.put("addRef_xx2");
            jsonReferences.put("additionalReferences", array);

            // Building Optional params Object
          //  jsonOptionalParams.put("amountCashback", cashBackAmountEditText.getText().toString() + "");
            jsonOptionalParams.put("amountCashback", "100");// Cannot
            // have
            // amount cashback in SALE transaction.
            jsonOptionalParams.put("amountTip", 0.00);
            jsonOptionalParams.put("references", jsonReferences);



            JSONObject jsonCustomer = new JSONObject();
            // Building Customer Object
            jsonCustomer.put("name", name);
            jsonCustomer.put("mobileNo", mobilenumber);
            jsonCustomer.put("email", email);

            jsonRequest.put("amount", amount);
            jsonRequest.put("options", jsonOptionalParams);

            jsonRequest.put("references", jsonReferences);
            jsonRequest.put("additionalReferences", josnAdtionakRefrence);
            jsonRequest.put("mode", "SALE");//Card payment Mode
            doSaleTxn(jsonRequest);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Take credit card transactions for Visa, Mastercard and Rupay. Debit card
     * transactions for Indian banks. Ability to perform EMI option.
     */
    private void doSaleTxn(JSONObject jsonRequest) {
        /******************************************
         {
         "amount": "123",
         "options": {
         "amountCashback": 0,
         "amountTip": 0,
         "references": {
         "reference1": "1234",
         "additionalReferences": [
         "addRef_xx1",
         "addRef_xx2"
         ]
         },
         "customer": {
         "name": "xyz",
         "mobileNo": "1234567890",
         "email": "abc@xyz.com"
         }
         },
         "mode": "SALE"
         }
         ******************************************/
        EzeAPI.cardTransaction(this, REQUEST_CODE_SALE_TXN, jsonRequest);
    }

    @OnClick(R.id.cash)
    void onCashClick() {
        //TODO implement
        try {
            //  REQUEST


            JSONObject jsonRequest = new JSONObject();
            JSONObject jsonOptionalParams = new JSONObject();
            JSONObject jsonReferences = new JSONObject();
            JSONObject jsonCustomer = new JSONObject();

            //Building Customer Object
            jsonCustomer.put("name", name);
            jsonCustomer.put("mobileNo", mobilenumber);
            jsonCustomer.put("email", email);

            int refNo = SharedPrefrences.getRefNo(PaymentoptionActivity.this);
            jsonReferences.put("reference1", "" + refNo);
            SharedPrefrences.setReferenceNo(PaymentoptionActivity.this, (refNo + 1));

            //Passing Additional References
            JSONArray array = new JSONArray();
            array.put("addRef_xx1");
            array.put("addRef_xx2");
            jsonReferences.put("additionalReferences", array);

            //Building Optional params Object
            //Cannot have amount cashback in cash transaction.
            jsonOptionalParams.put("amountCashback", "20.00");
            jsonOptionalParams.put("amountTip", "20.00");
            jsonOptionalParams.put("references", jsonReferences);
            jsonOptionalParams.put("customer", jsonCustomer);


            //Building final request object
            jsonRequest.put("amount", amount);
            jsonRequest.put("options", jsonOptionalParams);

            doCashTxn(jsonRequest);

            //EzeAPI.cashTransaction(this, REQUESTCODE_, jsonRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void doCashTxn(JSONObject jsonRequest) {
        /******************************************
         {
         "amount": "123",
         "options": {
         "references": {
         "reference1": "1234",
         "additionalReferences": [
         "addRef_xx1",
         "addRef_xx2"
         ]
         },
         "customer": {
         "name": "xyz",
         "mobileNo": "1234567890",
         "email": "abc@xyz.com"
         }
         }
         }
         ******************************************/
        EzeAPI.cashTransaction(this, REQUEST_CODE_CASH_TXN, jsonRequest);
    }

//    @OnClick(R.id.cheque)
//    void onChequeClick() {
//        try {
//            //  REQUEST
//            JSONObject jsonRequest = new JSONObject();
//            JSONObject jsonOptionalParams = new JSONObject();
//            JSONObject jsonReferences = new JSONObject();
//            JSONObject jsonCheque = new JSONObject();
//            JSONObject jsonCustomer = new JSONObject();
//
//            // Building Customer Object
//            jsonCustomer.put("name", name);
//            jsonCustomer.put("mobileNo", mobilenumber);
//            jsonCustomer.put("email", email);
//
//            int refNo = SharedPrefrences.getRefNo(PaymentoptionActivity.this);
//            jsonReferences.put("reference1", "ref" + refNo);
//            jsonReferences.put("reference2", "ref" + (refNo + 1));
//            jsonReferences.put("reference3", "ref" + (refNo + 2));
//            SharedPrefrences.setReferenceNo(PaymentoptionActivity.this, (refNo + 3));
//            //Passing Additional References
//            JSONArray array = new JSONArray();
//            array.put("addRef_xx1");
//            array.put("addRef_xx2");
//            jsonReferences.put("additionalReferences", array);
//
//            // Building Cheque Object
//            jsonCheque.put("chequeNumber", "");
//            jsonCheque.put("bankCode", "");
//            jsonCheque.put("bankName", "");
//            jsonCheque.put("bankAccountNo", "");
//            jsonCheque.put("chequeDate", "");
//
//            jsonOptionalParams.put("references", jsonReferences);
//            jsonOptionalParams.put("customer", jsonCustomer);
//
//            // Building final request object
//            jsonRequest.put("amount", amount);
//            jsonRequest.put("options", jsonOptionalParams);
//            jsonRequest.put("cheque", jsonCheque);
//            jsonRequest.put("userName", "Demo user");
//            Log.v("JSONREQ", jsonRequest.toString());
//            // EzeAPI.chequeTransaction(this, REQUESTCODE_CHEQUE, jsonRequest);
//            //  System.out.println("----------------------ok---------------");
//            doChequeTxn(jsonRequest);
//        } catch (JSONException e) {
//            e.printStackTrace();
//            System.out.println("----------------------error---------------" + e.getMessage());
//        }
//    }

    private void doChequeTxn(JSONObject jsonRequest) {
        /*****************************************
         {
         "amount": "123",
         "options": {
         "references": {
         "reference1": "1234",
         "additionalReferences": [
         "addRef_xx1",
         "addRef_xx2"
         ]
         },
         "customer": {
         "name": "xyz",
         "mobileNo": "1234567890",
         "email": "abc@xyz.com"
         }
         },
         "cheque": {
         "chequeNumber": "1234",
         "bankCode": "1234",
         "bankName": "xyz",
         "bankAccountNo": "1234",
         "chequeDate": "YYYY-MM-DD"
         }
         }
         *****************************************/
        EzeAPI.chequeTransaction(this, REQUEST_CODE_CHEQUE_TXN, jsonRequest);
    }

    @OnClick(R.id.back)
    void back() {
        //TODO implement
        finish();
        Animatoo.animateSlideRight(PaymentoptionActivity.this);

    }



    @OnClick(R.id.btn_logout)
    void setBtn_logout() {

            Intent vn = new Intent(PaymentoptionActivity.this,
                    LoginDetail.class);
            startActivity(vn);
            finish();

    //TODO implement
        finish();
        Animatoo.animateSlideRight(PaymentoptionActivity.this);

    }
    @Override
    public void onBackPressed() {

        finish();
        Animatoo.animateSlideRight(PaymentoptionActivity.this);

    }
    private void openTXNIdEnterPopup(final int requestCode) {
        try {
            LayoutInflater layoutInflater = LayoutInflater.from(PaymentoptionActivity.this);
            final View customView = layoutInflater.inflate(R.layout.txn_id_enter_popup, null);
            AlertDialog.Builder editCustomerPopup = new AlertDialog.Builder(PaymentoptionActivity.this);
            editCustomerPopup.setCancelable(false);
            editCustomerPopup.setView(customView);
            final AlertDialog alertDialog = editCustomerPopup.create();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog.show();

            Button cancelButton = (Button) customView.findViewById(R.id.cancel_button);
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.cancel();
                }
            });

            final EditText txnIdEditText = (EditText) customView.findViewById(R.id.txn_id_number);
            Button confirmButton = (Button) customView.findViewById(R.id.confirm_button);
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    strTxnId = txnIdEditText.getText().toString() + "";
                    switch (requestCode) {
                        case REQUEST_CODE_VOID:
                            doVoidTxn();
                            break;
                        case REQUEST_CODE_GET_TXN_DETAIL:
                            doGetTxnDetails();
                            break;
                        case REQUEST_CODE_ATTACH_SIGN:
                            doAttachSignature();
                            break;
                    }
                    alertDialog.cancel();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void openPaymentPayloadPopup(final int REQUEST_CODE) {
        try {
            LayoutInflater layoutInflater = LayoutInflater.from(PaymentoptionActivity.this);
            final View customView = layoutInflater.inflate(R.layout.payment_payload_popup, null);
            AlertDialog.Builder editCustomerPopup = new AlertDialog.Builder(PaymentoptionActivity.this);
            editCustomerPopup.setCancelable(false);
            editCustomerPopup.setView(customView);
            final AlertDialog alertDialog = editCustomerPopup.create();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog.show();

            Button cancelButton = (Button) customView.findViewById(R.id.cancel_button);
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.cancel();
                }
            });


            final EditText customerNameEditText = (EditText) customView.findViewById(R.id.user_name);
            final EditText emailIdEditText = (EditText) customView.findViewById(R.id.user_email);
            final EditText mobileNumberEditText = (EditText) customView.findViewById(R.id.user_mobile);
            final EditText orderNumberEditText = (EditText) customView.findViewById(R.id.order_number);
            final EditText payableAmountEditText = (EditText) customView.findViewById(R.id.payable_amount);
            final EditText cashBackAmountEditText = (EditText) customView.findViewById(R.id.cashback_amount);
            final EditText accountLabelEditTet = (EditText) customView.findViewById(R.id.acc_lab);
            final EditText serviceFeeEditText = (EditText) customView.findViewById(R.id.serv_fee);
            final EditText paymentByEditText = (EditText) customView.findViewById(R.id.pay_by);


//            if (REQUEST_CODE == REQUEST_CODE_CASH_BACK_TXN || REQUEST_CODE == REQUEST_CODE_CASH_AT_POS_TXN
//                    || REQUEST_CODE == REQUEST_CODE_BRAND_EMI || REQUEST_CODE == REQUEST_CODE_NORMAL_EMI) {
//                serviceFeeEditText.setVisibility(View.GONE);
//                paymentByEditText.setVisibility(View.GONE);
//                accountLabelEditTet.setVisibility(View.GONE);
//            }
//            if (REQUEST_CODE == REQUEST_CODE_CASH_AT_POS_TXN) {
//                payableAmountEditText.setVisibility(View.GONE);
//            }
//
//            if (REQUEST_CODE == REQUEST_CODE_BRAND_EMI || REQUEST_CODE == REQUEST_CODE_PAY) {
//                productBrandEditText.setVisibility(View.VISIBLE);
//                productCodeEditText.setVisibility(View.VISIBLE);
//                productSerialEditText.setVisibility(View.VISIBLE);
//                cashBackAmountEditText.setVisibility(View.GONE);
//            }
            Button confirmButton = (Button) customView.findViewById(R.id.confirm_button);
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (orderNumberEditText.getText().toString().equalsIgnoreCase("")
                            || payableAmountEditText.getText().toString().equalsIgnoreCase("")
                            && (REQUEST_CODE != REQUEST_CODE_CASH_AT_POS_TXN)) {
                        displayToast(mandatoryErrMsg);
                        return;
                    }
                    try {
                        JSONObject jsonRequest = new JSONObject();
                        JSONObject jsonOptionalParams = new JSONObject();
                        JSONObject jsonReferences = new JSONObject();
                        JSONObject jsonCustomer = new JSONObject();
                        // Building Customer Object
                        jsonCustomer.put("name", "");
                        jsonCustomer.put("mobileNo", mobileNumberEditText.getText().toString().trim());
                        jsonCustomer.put("email", emailIdEditText.getText().toString().trim());
                        jsonRequest.put("amount", payableAmountEditText.getText().toString().trim());
                        jsonRequest.put("options", jsonOptionalParams);

                        // doSaleTxn(JSONObject jsonRequest);t

                        InputMethodManager imm = (InputMethodManager) PaymentoptionActivity.this
                                .getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(emailIdEditText.getWindowToken(), 0);

                        alertDialog.cancel();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
            alertDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @return transaction id is valid
     */
    private boolean isTransactionIdValid() {
        if (strTxnId == null)
            return false;
        else
            return true;
    }
    private void doVoidTxn() {
        if (isTransactionIdValid()) {
            EzeAPI.voidTransaction(this, REQUEST_CODE_VOID, strTxnId);// pass your transaction id value here
        } else
            displayToast("Inorrect txn Id, please make a Txn.");
    }
    private void doGetTxnDetails() {
        if (!strTxnId.equals(null)) {
            EzeAPI.getTransaction(this, REQUEST_CODE_GET_TXN_DETAIL, strTxnId);// pass your reference id value here
        } else {
            displayToast("Inorrect txn Id, please pass txnId");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);


        Log.e("SampleAppLogs", "requestCode = " + requestCode + "resultCode = " + resultCode);
        try {
            switch (requestCode) {

                case REQUEST_CODE_CASH_TXN:
                    if (resultCode == RESULT_OK) {
                       // printReceipt(strTxnId);
                        Log.v("JSONRST", intent.getStringExtra("response"));
                        JSONObject mainObject = new JSONObject(intent.getStringExtra("response"));
                        successvar = mainObject.getString("status");
                        consumerCode = SharedPrefrences.getConsumerNo(PaymentoptionActivity.this);
                        Log.v("CONSUMERCODE", consumerCode);
                        ulbCode = consumerCode.substring(0, 4);
                        Log.v("ULBCODE", ulbCode);
                        paymentMode = "CASH";
                        paymentAmount = SharedPrefrences.getPayAmount(PaymentoptionActivity.this);
                        Log.v("PAYMENTAMOUNT", paymentAmount);
                        JSONObject resultObject = mainObject.getJSONObject("result");
                        JSONObject customerobject=resultObject.getJSONObject("customer");
                        paidBy = customerobject.getString("name");
                        Log.v("PAIDBY", paidBy);

                        JSONObject txnObject = resultObject.getJSONObject("txn");
                        transactionId = txnObject.getString("txnId");
                        Log.v("TRANSACTIONID", transactionId);
                        deviceId = "Android 6";
                        service = SharedPrefrences.getservice(PaymentoptionActivity.this);
                        Log.v("SERVICE", service);

                        if (successvar.equals("success")) {
                            Auth2 = SharedPrefrences.get_token(PaymentoptionActivity.this);
                            Log.v("AUTH 2 val", Auth2);
                            Toast.makeText(this, "payment success", Toast.LENGTH_SHORT).show();
                            progress.Show();
                            manager.cashback(Auth2, consumerCode, ulbCode, paymentMode,
                                    paymentAmount, paidBy, transactionId, service, deviceId, cashbackCallback);
                        }

                    } else if (resultCode == RESULT_CANCELED) {
//                        JSONObject response = new JSONObject(intent.getStringExtra("response"));
//                        response = response.getJSONObject("error");
//                        String errorCode = response.getString("code");
//                        String errorMessage = response.getString("message");
//                        Toast.makeText(this, "payment faild", Toast.LENGTH_SHORT).show();
                        System.out.println("------------------------api cashbackCallback-------4");
                        JSONObject response = new JSONObject(intent.getStringExtra("response"));
                        response = response.getJSONObject("error");
                        String errorCode = response.getString("code");
                        String errorMessage = response.getString("message");
                        Toast.makeText(this, "payment fail", Toast.LENGTH_SHORT).show();
                    }
                    break;
             //Use for online transaction
                case REQUEST_CODE_SALE_TXN:

                    //case REQUESTCODE_CHEQUE:
                    String paymentmethod = "";
                    if (requestCode == REQUEST_CODE_CASH_TXN) {
                        paymentmethod = "CASH";
                    } else if (requestCode == REQUEST_CODE_CHEQUE_TXN) {
                        paymentmethod = "CHEQUE";
                    } else if (requestCode == REQUEST_CODE_SALE_TXN) {
                        paymentmethod = "CARD";
                    }
                    if (resultCode == RESULT_OK) {
                        Log.v("JSONRST", intent.getStringExtra("response"));
                        JSONObject mainObject = new JSONObject(intent.getStringExtra("response"));
                        //  JSONObject uniObject = mainObject.getJSONObject("success");
                        successvar = mainObject.getString("status");
                        consumerCode = SharedPrefrences.getConsumerNo(PaymentoptionActivity.this);
                        Log.v("CONSUMERCODE", consumerCode);
                        ulbCode = consumerCode.substring(0, 4);
                        Log.v("ULBCODE", ulbCode);
                        paymentMode = "CARD";
                        paymentAmount = SharedPrefrences.getPayAmount(PaymentoptionActivity.this);
                        Log.v("PAYMENTAMOUNT", paymentAmount);
                        //  paidBy=mainObject.getString("name");
                        //  Log.v("PAIDBY",paidBy);
                        JSONObject resultObject = mainObject.getJSONObject("result");
                      JSONObject customerobject=resultObject.getJSONObject("customer");
                      paidBy = customerobject.getString("name");
                      JSONObject txnObject = resultObject.getJSONObject("txn");
                        transactionId = txnObject.getString("txnId");
                        transactionNumber = "123456789";
                        JSONObject cardDetails=resultObject.getJSONObject("cardDetails");
                        String maskNo=cardDetails.getString("maskedCardNo");
                       String[] maskArray = maskNo.split("-");
                        Log.d("Array",maskArray[3]);
                        instrumentNumber = maskArray[3];
                        deviceId = "Android 6";
                        service = SharedPrefrences.getservice(PaymentoptionActivity.this);
                        Log.v("SERVICE", service);
                        if (successvar.equals("success")) {
                            Auth2 = SharedPrefrences.get_token(PaymentoptionActivity.this);
                            Log.v("AUTH 2 val", Auth2);
                            Toast.makeText(this, "payment success", Toast.LENGTH_SHORT).show();
                            progress.Show();

                            manager.feedback(Auth2, consumerCode, ulbCode,
                                    paymentMode, paymentAmount, paidBy, transactionId,
                                    transactionNumber, instrumentNumber, service, deviceId, feedbackCallback);

                        }


                    } else if (resultCode == RESULT_CANCELED) {
                        System.out.println("------------------------api feedbackCallback-------3");
                        JSONObject response = new JSONObject(intent.getStringExtra("response"));
                        response = response.getJSONObject("error");
                        String errorCode = response.getString("code");
                        String errorMessage = response.getString("message");
                        Toast.makeText(this, "payment fail", Toast.LENGTH_SHORT).show();
                    }

                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Print Receipt method is invoked to print receipt for a payment transaction
     */

    private void printReceipt(String strTxnId) {

        EzeAPI.printReceipt(this, REQUEST_CODE_PRINT_RECEIPT, strTxnId);// pass your transaction id value here
    }




    private void doAttachSignature() {
        /*******************************************
         {
         "tipAmount": 0,
         "image": {
         "imageData": "js9bsidvicbi3h",
         "imageType": "JPEG",
         "height": "",
         "weight": ""
         },
         "txnId": "12355356345"
         }
         *******************************************/
        JSONObject jsonRequest = new JSONObject();
        JSONObject jsonImageObj = new JSONObject();
        try {
            img.buildDrawingCache();
            Bitmap bmap = img.getDrawingCache();
            String encodedImageData = getEncoded64ImageStringFromBitmap(bmap);
            // Building Image Object
            jsonImageObj.put("imageData", encodedImageData);
            jsonImageObj.put("imageType", "JPEG");
            jsonImageObj.put("height", "");// optional
            jsonImageObj.put("weight", "");// optional
            // Building final request object
            // jsonRequest.put("emiId", emiID);// pass this field if you have an
            // EMI Id associated with the transaction
            jsonRequest.put("tipAmount", 0.00);// optional
            jsonRequest.put("image", jsonImageObj); // Pass this attribute when you have a valid captured signature image
            jsonRequest.put("txnId", strTxnId);// pass your transaction id value here
            if (strTxnId != null) {
                EzeAPI.attachSignature(this, REQUEST_CODE_ATTACH_SIGN, jsonRequest);
            } else {
                displayToast("Inorrect txn Id, please pass txnId");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    public String getEncoded64ImageStringFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] byteFormat = stream.toByteArray();
        return Base64.encodeToString(byteFormat, Base64.NO_WRAP);
    }


    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSucess(int status, FeedbackResponse message) throws JSONException {
        Log.d("FEEDBACK",""+message);
        progress.Dismiss();
        if (message != null){
            SharedPrefrences.setReceiptNumber(context,message.getReceiptNumber());
            SharedPrefrences.setReceiptDate(context,message.getReceiptDate());
            SharedPrefrences.setTotalAmountpaid(context,message.getTotalAmountpaid());
            SharedPrefrences.setConsumerName(context,message.getConsumerName());
            SharedPrefrences.setConsumerNumber(context,message.getConsumerNumber());
            SharedPrefrences.setAddress(context,message.getAddress());
            SharedPrefrences.setPaidBy(context,message.getPaidBy());
            SharedPrefrences.setTransactionId(context,message.getTransactionId());
            SharedPrefrences.setDeviceId(context,message.getDeviceId());
            SharedPrefrences.setType(context,message.getInstruments().get(0).getType());
            SharedPrefrences.setUlbName(context,message.getUlbName());
            SharedPrefrences.setService(context,message.getService());
            SharedPrefrences.setPaidFrom(context,message.getPaidFrom());
            SharedPrefrences.setPaidTo(context,message.getPaidTo());
            SharedPrefrences.setInstrumentNo(context,message.getInstruments().get(0).
                    getInstrumentNumber());
            SharedPrefrences.setTransactionNo(context,message.getInstruments().get(0).
                    getTransactionNumber());

           // EzeAPI.printReceipt(this, REQUEST_CODE_PRINT_RECEIPT, message.getTransactionId());
            startActivity(new Intent(context, PrintReceiptActivity.class));
        }


    }

    @Override
    public void onSucess(int status, CashbackResponse message) throws JSONException {
        Log.d("CASHBACK",""+message);
        progress.Dismiss();
        if (message != null){
            SharedPrefrences.setReceiptNumber(context,message.getReceiptNumber());
            SharedPrefrences.setReceiptDate(context,message.getReceiptDate());
            SharedPrefrences.setTotalAmountpaid(context,message.getTotalAmountpaid());
            SharedPrefrences.setConsumerName(context,message.getConsumerName());
            SharedPrefrences.setConsumerNumber(context,message.getConsumerNumber());
            SharedPrefrences.setAddress(context,message.getAddress());
            SharedPrefrences.setPaidBy(context,message.getPaidBy());
            SharedPrefrences.setTransactionId(context,message.getTransactionId());
            SharedPrefrences.setDeviceId(context,message.getDeviceId());
            SharedPrefrences.setType(context,message.getInstruments().get(0).getType());
            SharedPrefrences.setUlbName(context,message.getUlbName());
            SharedPrefrences.setService(context,message.getService());
            SharedPrefrences.setPaidFrom(context,message.getPaidFrom());
            SharedPrefrences.setPaidTo(context,message.getPaidTo());

           // EzeAPI.printReceipt(this, REQUEST_CODE_PRINT_RECEIPT, message.getTransactionId());
            startActivity(new Intent(context, PrintReceiptActivity.class));
          //  startActivity(new Intent(context,"PaymentoptionActivity.this",CheckduesActivity.class));
        }
    }

    @Override
    public void onError(int status, ResponseBody error) {

    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onNetworkFailur() {
    }



    }

