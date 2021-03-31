package com.example.registros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExitoRegistro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exito_registro);
    }
    public void Siguiente(View view){
        Intent sig = new Intent(this,MainActivity.class);
        startActivity(sig);
    }
}