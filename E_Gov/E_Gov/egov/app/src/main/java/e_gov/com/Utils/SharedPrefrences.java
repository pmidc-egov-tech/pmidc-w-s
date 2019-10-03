package e_gov.com.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.io.File;

import e_gov.com.Activity.CheckduesActivity;
import e_gov.com.Activity.DuesdetailActivity;

public class SharedPrefrences {
    static SharedPreferences preferences;
    static SharedPreferences.Editor editor;
    static String value = "";
    static Boolean boolValue = false;

    public static void set_token(Context activity, String uid) {

        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        editor = preferences.edit();
        editor.putString("token", uid);
        editor.commit();

    }
    public static void setUIDNo(Context context, int UIDNo) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putInt("no", UIDNo);
        editor.commit();

    }



    public static void setReferenceNo(Context context, int refNo) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putInt("refNo", refNo);
        editor.commit();

    }

    public static void set_ref(Context activity, String uid) {

        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        editor = preferences.edit();
        editor.putString("ref", uid);
        editor.commit();

    }

    public static String get_ref(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        value = preferences.getString("ref", "");
        return value;
    }

    public static String get_token(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        value = preferences.getString("token", "");
        return value;
    }

    public static String get_refresh_token(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        value = preferences.getString("refresh_token", "");
        return value;
    }

    public static int getRefNo(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getInt("refNo", 1);
    }


    public static void setConsumerNo(Context context, String consNo) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("consNo", consNo);
        editor.commit();

    }

    public static String getConsumerNo(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("consNo", "");
    }

    public static void setReceiptNo(Context context, String consNo) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("ReceiptNo", consNo);
        editor.commit();

    }

    public static void clearSharePref(Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor=preferences.edit();
        editor.clear();
        editor.apply();
        editor.commit();
    }

    public static String getReceiptNo(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("ReceiptNo", "");
    }


    public static void setPayAmount(Context context, String payAmt) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("payAmt", payAmt);
        editor.commit();

    }


    public static String getPayAmount(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("payAmt", "");
    }

    public static void setservice(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("service", service);
        editor.commit();
    }

    public static String getservice(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("service", "");
    }

    /* --------------------- Saving data for receipt ---------------------- */

    public static void setReceiptNumber(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("receiptNumber", service);
        editor.commit();
    }

    public static void setReceiptDate(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("receiptDate", service);
        editor.commit();
    }

    public static void setTotalAmountpaid(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("totalAmountpaid", service);
        editor.commit();
    }

    public static void setConsumerName(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("consumerName", service);
        editor.commit();
    }

    public static void setConsumerNumber(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("consumerNumber", service);
        editor.commit();
    }

    public static void setAddress(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("address", service);
        editor.commit();
    }

    public static void setPaidBy(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("paidBy", service);
        editor.commit();
    }

    public static void setTransactionId(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("transactionId", service);
        editor.commit();
    }

    public static void setDeviceId(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("deviceId", service);
        editor.commit();
    }

    public static void setType(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("type", service);
        editor.commit();
    }

    public static void setUlbName(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("ulbName", service);
        editor.commit();
    }

    public static void setService(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("Service", service);
        editor.commit();
    }

    public static void setPaidFrom(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("paidFrom", service);
        editor.commit();
    }

    public static void setPaidTo(Context context, String service) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("paidTo", service);
        editor.commit();
    }

    public static void setInstrumentNo(Context context, String instrumentNumber) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("instrumentNumber", instrumentNumber);
        editor.commit();
    }

    public static void setTransactionNo(Context context, String transactionNumber) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("transactionNumber", transactionNumber);
        editor.commit();
    }

    /* --------------------- Getting data for receipt ---------------------- */

    public static String getReceiptNumber(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("receiptNumber", "");
    }

    public static String getReceiptDate(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("receiptDate", "");
    }

    public static String getTotalAmountpaid(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("totalAmountpaid", "");
    }

    public static String getConsumerName(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("consumerName", "");
    }

    public static String getConsumerNumber(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("consumerNumber", "");
    }

    public static String getAddress(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("address", "");
    }

    public static String getPaidBy(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("paidBy", "");
    }

    public static String getTransactionId(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("transactionId", "");
    }

    public static String getDeviceId(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("deviceId", "");
    }

    public static String getType(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("type", "");
    }

    public static String getUlbName(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("ulbName", "");
    }

    public static String getService(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("Service", "");
    }

    public static String getPaidFrom(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("paidFrom", "");
    }

    public static String getPaidTo(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("paidTo", "");
    }

    public static String getInstrumentNo(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("instrumentNumber", "");
    }

    public static String getTransactionNo(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("transactionNumber", "");
    }

    public static String getUsername(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("username", "");
    }

    public static String getPassword(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString("password", "");
    }

    public static void setUsername(Context context, String username) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("username", username);
        editor.commit();
    }

    public static void setPassword(Context context, String password) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("password", password);
        editor.commit();
    }

    public static boolean getDoAutoLogin(Context activity) {
        preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getBoolean("autoLogin", false);
    }

    public static void setDoAutoLogin(Context context, boolean autoLogin) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putBoolean("autoLogin", autoLogin);
        editor.commit();
    }

    public static void set_refresh_token(CheckduesActivity checkduesActivity, String s) {
    }

}