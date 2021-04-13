package com.example.registros;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button login;

    private String name1 ="";
    private String password1 ="";

    private FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fAuth = FirebaseAuth.getInstance();

        name = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.botonLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = name.getText().toString();
                password1 = password.getText().toString();

                if(!name1.isEmpty() && !password1.isEmpty()){
                    loginUser();
                }
                else{
                    Toast.makeText(Login.this,"Complete los campos",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loginUser(){
        fAuth.signInWithEmailAndPassword(name1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(Login.this,PantallaLogin.class));
                    finish();
                }
                else{
                    Toast.makeText(Login.this,"No se pudo logear",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Retroceder(View view){
        Intent sig = new Intent(this,MainActivity.class);
        startActivity(sig);
    }



}