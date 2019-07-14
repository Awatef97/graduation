package com.awatef.loggin.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.awatef.loggin.R;
import com.awatef.loggin.model.User;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by awatef on 6/28/2019.
 */

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        //wait 3000 mSecs  --------------------------------
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), content.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 3000);

    }
}
