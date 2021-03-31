package com.example.registros;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class principal extends AppCompatActivity {
    private EditText name;
    private EditText mail;
    private EditText password;
    private Button reg;


    private String nombre1="";
    private String correo1="";
    private String contra1 ="";

    FirebaseAuth fireAuth;
    DatabaseReference basedatos;

    public void Retroceder(View view){
        Intent sig = new Intent(this,MainActivity.class);
        startActivity(sig);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        name = (EditText) findViewById(R.id.user);
        mail = (EditText) findViewById(R.id.txtCorreo);
        password = (EditText) findViewById(R.id.pass);
        reg = (Button) findViewById(R.id.botonLogin);

        fireAuth = FirebaseAuth.getInstance();
        basedatos = FirebaseDatabase.getInstance().getReference();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre1 = name.getText().toString();
                correo1 = mail.getText().toString();
                contra1 = password.getText().toString();

                if(!nombre1.isEmpty() && !contra1.isEmpty()){
                    if(contra1.length()>=6){
                        registroUser();
                    }
                    else{
                        Toast.makeText(principal.this,"La contraseña debe tener como minimo 6 caracteres-",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(principal.this,"Ingrese datos completos.",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void registroUser() {
        fireAuth.createUserWithEmailAndPassword(correo1, contra1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> tarea1) {
                if(tarea1.isSuccessful()){

                    Map<String, Object> mapa1 = new HashMap<>();
                    mapa1.put("Nombres", nombre1);
                    mapa1.put("Correo",correo1);
                    mapa1.put("Contra",contra1);

                    String id = fireAuth.getCurrentUser().getUid();

                    basedatos.child("User").child(id).setValue(mapa1).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> tarea2) {
                            if(tarea2.isSuccessful()){
                                Toast.makeText(principal.this,"!Registro realizado con éxito¡",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(principal.this,ExitoRegistro.class));
                            }
                            else{
                                Toast.makeText(principal.this,"No se pudo crear el usuario",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(principal.this,"No se pudo registrar el usuario",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}