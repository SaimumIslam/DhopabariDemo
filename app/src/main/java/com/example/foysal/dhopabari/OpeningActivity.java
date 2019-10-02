package com.example.foysal.dhopabari;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;


public class OpeningActivity extends AppCompatActivity {

    ImageView logo;
    TextView txt;

    SharedPreferences sharedPreferences;
    Boolean save_login=true;
    SharedPreferences.Editor edit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        /*
       sharedPreferences = getSharedPreferences(getString(R.string. PREF_FILE), 0);
        edit = sharedPreferences.edit();

        save_login = sharedPreferences.getBoolean(getString(R.string.SAVE), false);
        */

        logo=(ImageView)findViewById(R.id.logo);
        txt=(TextView)findViewById(R.id.txt);

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        AlphaAnimation fade_in = new AlphaAnimation(0.0f, 2.0f);
                        logo.startAnimation(fade_in);
                        txt.startAnimation(fade_in);
                        fade_in.setDuration(1500);
                    }
                },0);

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        AlphaAnimation fade_out = new AlphaAnimation(2.0f, 0.0f);
                        logo.startAnimation(fade_out);
                        txt.startAnimation(fade_out);
                        fade_out.setDuration(2000);
                    }
                },1200);

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        if (!save_login){
                            Intent intent = new Intent(OpeningActivity.this, LogInActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                            finish();
                        }
                        else
                        {
                            Intent intent = new Intent(OpeningActivity.this, MainActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                            finish();
                        }
                    }
                },3000);
    }
}