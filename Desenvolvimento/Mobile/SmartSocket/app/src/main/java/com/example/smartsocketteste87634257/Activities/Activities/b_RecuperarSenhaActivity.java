package com.example.smartsocketteste87634257.Activities.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartsocketteste87634257.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class b_RecuperarSenhaActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText userMail;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        //ini
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        userMail = findViewById(R.id.edt_email_recuperar_senha);

        //tool bar
        toolbar =findViewById(R.id.toolBar2);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            Intent aa = new Intent(getApplicationContext(),a_LoginActivity.class);
            startActivity(aa);
            finish();
        }

        return  super.onOptionsItemSelected(item);
    }



    public void RecuperarSenha(View view) {
        mAuth.sendPasswordResetEmail(userMail.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    userMail.setText("");
                    Toast.makeText(getApplicationContext(),"Recuperação  de acesso iniciada. Email  enviado",Toast.LENGTH_SHORT).show();
                    Intent aa = new Intent(getApplicationContext(),a_LoginActivity.class);
                    startActivity(aa);
                } else{

                    Toast.makeText(b_RecuperarSenhaActivity.this,"Falha no envio ou email não cadastrado!",Toast.LENGTH_SHORT).show();

                }


            }
        });


    }

}