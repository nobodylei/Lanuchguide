package com.lei.lanuchguide.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.lei.lanuchguide.MainActivity;
import com.lei.lanuchguide.R;

/**
 * Created by yanle on 2018/2/25.
 */

public class SplashActivity extends Activity {
    //起始页停留时间
    private static final long DELAY_TIME = 3000L;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("Test","起始页面");
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, DELAY_TIME);
    }
}
