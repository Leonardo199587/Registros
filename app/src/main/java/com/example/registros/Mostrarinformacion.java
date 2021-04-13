package com.example.registros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Mostrarinformacion extends AppCompatActivity {

    private TextView modelo,informacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrarinformacion);

        Bundle bundle = getIntent().getExtras();
        String codigo_modelo=bundle.getString("Modelo");

        modelo=findViewById(R.id.id_mod);
        informacion=findViewById(R.id.id_info);
        modelo.setText(codigo_modelo);



        if (codigo_modelo==  "aa") {
            informacion.setText("informacion aa");
        }
        if (codigo_modelo==  "xd") {
            informacion.setText("informacion xd");
        }
        else{
            informacion.setText("esta en else");
        }

    }


}