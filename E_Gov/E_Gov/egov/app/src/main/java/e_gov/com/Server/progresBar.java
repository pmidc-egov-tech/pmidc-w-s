package e_gov.com.Server;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import e_gov.com.R;


public class progresBar {
    Dialog progressDoalog;
    Context context;

    public progresBar(Context context){
        this.context = context;
        progressDoalog = new Dialog(context);
        progressDoalog.setContentView(R.layout.dialog);
        progressDoalog.setCanceledOnTouchOutside(false);
        progressDoalog.setCancelable(false);
        progressDoalog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public void Show(){
        if(!((Activity) context).isFinishing())
        {
            if(progressDoalog != null){
               progressDoalog.show();
            }
        }

    }

    public void Dismiss(){
        if(!((Activity) context).isFinishing())
        {
          if(progressDoalog != null){
               progressDoalog.dismiss();
         }
         }

    }

}
