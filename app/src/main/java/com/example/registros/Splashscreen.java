package com.example.registros;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.CountDownTimer;

import java.nio.charset.MalformedInputException;

public class Splashscreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nuevo = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(nuevo);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}