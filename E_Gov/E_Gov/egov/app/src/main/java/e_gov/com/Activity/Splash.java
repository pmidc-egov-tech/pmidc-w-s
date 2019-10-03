package e_gov.com.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import e_gov.com.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this, LoginDetail.class));
                Animatoo.animateSwipeLeft(Splash.this);
                finish();
            }
        }, 4000);
    }
}
