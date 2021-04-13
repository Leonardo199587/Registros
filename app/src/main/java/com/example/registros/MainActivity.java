package com.example.registros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button inicio;
    private Button registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Sig(View view){
        Intent sig = new Intent(this,principal.class);
        startActivity(sig);
    }

    public void Sig1(View view){
        Intent sig = new Intent(this,Login.class);
        startActivity(sig);
    }

    public void Sig2(View view){
        Intent sig = new Intent(this,Home.class);
        startActivity(sig);
    }

}