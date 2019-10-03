package e_gov.com.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.FrameLayout;
//import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.pax.neptunelite.api.DALProxyClient;
import android.os.Handler;
import android.widget.Button;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.pax.dal.IDAL;
import com.pax.neptunelite.api.DALProxyClient;
import com.eze.api.EzeAPI;
import butterknife.BindView;
import butterknife.ButterKnife;
import dalvik.system.BaseDexClassLoader;
import e_gov.com.R;
import e_gov.com.Utils.SharedPrefrences;

public class PrintReceiptActivity extends AppCompatActivity {
    Handler mHandler;
    @BindView(R.id.btPrint)
    Button btPrint;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvReceiptType)
    TextView tvReceiptType;
    //    @BindView(R.id.tvStarsTop)
//    TextView tvStarsTop;
    @BindView(R.id.tvConsumerNo)
    TextView tvConsumerNo;
    @BindView(R.id.tvReceiptNo)
    TextView tvReceiptNo;
    @BindView(R.id.tvReceiptDate)
    TextView tvReceiptDate;
    @BindView(R.id.tvOwnerName)
    TextView tvOwnerName;
    @BindView(R.id.tvHouseNo)
    TextView tvHouseNo;
    @BindView(R.id.tvMode)
    TextView tvMode;
    @BindView(R.id.tvInstructionNo)
    TextView tvInstructionNo;
    @BindView(R.id.tvTransactionNo)
    TextView tvTransactionNo;
    @BindView(R.id.tvAmountPaid)
    TextView tvAmountPaid;
    @BindView(R.id.tvService)
    TextView tvService;
    @BindView(R.id.tvPaidBy)
    TextView tvPaidBy;
    //    @BindView(R.id.tvStarsBottom)
//    TextView tvStarsBottom;
    @BindView(R.id.llOuter)
    FrameLayout llOuter;
    @BindView(R.id.svReceipt)
    ScrollView svReceipt;
    private String receiptNumber ;
    private String receiptDate ;
    private String totalAmountpaid ;
    private String consumerNumber ;
    private String consumerName ;
    private String address ;
    private String transactionId ;
    private String type ;
    private String service ;
    private String ulbName ;
    private String paidBy;
    private String instructionNo;
    private String transactionNo;
    Context context;
    private final int REQUEST_CODE_CLOSE = 10001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receipt_layout);
        ButterKnife.bind(this);
        context = PrintReceiptActivity.this;
        getReceiptData();
        if (!type.equals("online")){
            tvInstructionNo.setVisibility(View.GONE);
            tvTransactionNo.setVisibility(View.GONE);
        } else {
            tvInstructionNo.setVisibility(View.VISIBLE);
            tvTransactionNo.setVisibility(View.VISIBLE);
        }
        showReceipt();
    }

    private void showReceipt() {
        tvTitle.setText(ulbName);
        tvConsumerNo.setText(tvConsumerNo.getText().toString()+consumerNumber);
        tvReceiptNo.setText(tvReceiptNo.getText().toString()+receiptNumber);
        tvReceiptDate.setText(tvReceiptDate.getText().toString()+receiptDate);
        tvOwnerName.setText(tvOwnerName.getText().toString()+consumerName);
        tvHouseNo.setText(tvHouseNo.getText().toString()+address);
        tvMode.setText(tvMode.getText().toString()+type);
        tvInstructionNo.setText(tvInstructionNo.getText().toString()+instructionNo);
        tvTransactionNo.setText(tvTransactionNo.getText().toString()+transactionNo);
        tvAmountPaid.setText(tvAmountPaid.getText().toString()+totalAmountpaid);
        tvService.setText(tvService.getText().toString()+service);
        tvPaidBy.setText(tvPaidBy.getText().toString()+paidBy);
    }

    private void getReceiptData() {
        receiptNumber = SharedPrefrences.getReceiptNumber(context);
        receiptDate = SharedPrefrences.getReceiptDate(context);
        totalAmountpaid = SharedPrefrences.getTotalAmountpaid(context);
        consumerNumber = SharedPrefrences.getConsumerNumber(context);
        consumerName = SharedPrefrences.getConsumerName(context);
        address = SharedPrefrences.getAddress(context);
        transactionId = SharedPrefrences.getTransactionId(context);
        type = SharedPrefrences.getType(context);
        service = SharedPrefrences.getService(context);
        ulbName = SharedPrefrences.getUlbName(context);
        paidBy = SharedPrefrences.getPaidBy(context);
        instructionNo = SharedPrefrences.getInstrumentNo(context);
        transactionNo = SharedPrefrences.getTransactionNo(context);
    }

    void onClick(View view){
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.btPrint:
                if (btPrint.getText().toString().equals("PRINT")) {
                    printReceipt(llOuter);
                }
                else {
                    SharedPrefrences.setDoAutoLogin(getApplicationContext(),true);
                    doRestart(context);
                }
                break;
        }
    }


    /**
     * Print Receipt method is invoked to print receipt for a payment transaction
     */
    private void printReceipt(FrameLayout view) {
        try {
            Bitmap bitmap = getWebViewBitmap(view);
            String s = "/system/lib/libpaxapijni.so";

            IDAL dal = DALProxyClient.getInstance().getDal(this);
            dal.getPrinter().init();
            dal.getPrinter().printBitmapWithMonoThreshold(bitmap, 230);
            //dal.getPrinter().getDotLine();
            dal.getPrinter().step(200);
            dal.getPrinter().start();
            btPrint.setText("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }


        //EzeAPI.printReceipt(this, REQUEST_CODE_PRINT_RECEIPT, strTxnId);// pass your transaction id value here
    }
    public Bitmap getWebViewBitmap(FrameLayout view) {
        Bitmap bitmap = null;

        int widthSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), View.MeasureSpec.AT_MOST);
        // height measure spec
        int heightSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), View.MeasureSpec.AT_MOST);

        // measure the view
        view.measure(widthSpec, heightSpec);

        // set the layout sizes
        int left = view.getLeft();
        int top = view.getTop();
        int width = view.getMeasuredWidth();
        int height = view.getMeasuredHeight();
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        view.layout(left, top, view.getMeasuredWidth(), view.getMeasuredHeight());
        //view.layout(left, top, width + left, height + top);

        // create the bitmap
        bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        //Create a canvas with the specified bitmap to draw into
        Canvas c = new Canvas(bitmap);
        c.translate(-view.getScrollX(), -view.getScrollY());

        //Render this view (and all of its children) to the given Canvas
        view.draw(c);
        return bitmap;


//
//
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
//                (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        view.setLayoutParams(params);

        //Pre-measure the view so that height and width don't remain null.
//        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
//                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

//        //Assign a size and position to the view and all of its descendants
//        view.layout(100, 100, view.getMeasuredWidth(), view.getMeasuredHeight());
//
//        //Create the bitmap
//        bitmap = Bitmap.createBitmap(view.getMeasuredWidth(),
//                view.getMeasuredHeight(),
//                Bitmap.Config.ARGB_8888);


//        int widthSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), View.MeasureSpec.AT_MOST);
//        // height measure spec
//        int heightSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), View.MeasureSpec.AT_MOST);
//
//        // measure the view
//        view.measure(widthSpec, heightSpec);
//
//        // set the layout sizes
//        int left = view.getLeft();
//        int top = view.getTop();
//        int width = view.getMeasuredWidth();
//        int height = view.getMeasuredHeight();
//        int scrollX = view.getScrollX();
//        int scrollY = view.getScrollY();
//        view.layout(left, top, view.getMeasuredWidth(), view.getMeasuredHeight());
//        //view.layout(left, top, width + left, height + top);
//
//        // create the bitmap
//        bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        //Create a canvas with the specified bitmap to draw into
        // Canvas c = new Canvas(bitmap);
//        c.translate(-view.getScrollX(), -view.getScrollY());
//
//        //Render this view (and all of its children) to the given Canvas
//        view.draw(c);
//        return bitmap;
    }


    public void doRestart(Context c) {
        try {
            //check if the context is given
            if (c != null) {
                //fetch the packagemanager so we can get the default launch activity
                // (you can replace this intent with any other activity if you want
                PackageManager pm = c.getPackageManager();
                //check if we got the PackageManager
                if (pm != null) {
                    //create the intent with the default start activity for your application
                    Intent mStartActivity = pm.getLaunchIntentForPackage(
                            c.getPackageName()
                    );
                    if (mStartActivity != null) {
                        mStartActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //create a pending intent so the application is restarted after System.exit(0) was called.
                        // We use an AlarmManager to call this intent in 100ms
                        int mPendingIntentId = 223344;
                        PendingIntent mPendingIntent = PendingIntent
                                .getActivity(c, mPendingIntentId, mStartActivity,
                                        PendingIntent.FLAG_CANCEL_CURRENT);
                        AlarmManager mgr = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
                        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
                        //kill the application
                        System.exit(0);
                    } else {
                        Log.e("PrintReceiptActivity", "Was not able to restart application, mStartActivity null");
                    }
                } else {
                    Log.e("PrintReceiptActivity", "Was not able to restart application, PM null");
                }
            } else {
                Log.e("PrintReceiptActivity", "Was not able to restart application, Context null");
            }
        } catch (Exception ex) {
            Log.e("PrintReceiptActivity", "Was not able to restart application");
        }
    }
}
