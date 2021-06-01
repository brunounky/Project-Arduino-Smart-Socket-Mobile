package com.example.smartsocketteste87634257.Activities.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.smartsocketteste87634257.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;




public class a_LoginActivity extends AppCompatActivity  implements View.OnClickListener {

    private EditText userMail, userPassword;
    private Button btnLogin;
    private ProgressBar loginProgress;
    private FirebaseAuth mAuth;
    private Intent HomeActivity;
    private TextView loginReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userMail = findViewById(R.id.loginMail);
        userPassword = findViewById(R.id.loginPassword);
        btnLogin = findViewById(R.id.loginBtn);
        loginProgress = findViewById(R.id.loginProgressBar);
        mAuth = FirebaseAuth.getInstance();
        loginReg = findViewById(R.id.loginBtnCriar);


        loginReg.setOnClickListener(this);




        HomeActivity = new Intent(this, a_HomeActivity.class);
        loginProgress.setVisibility(View.INVISIBLE);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginProgress.setVisibility(View.VISIBLE);
                btnLogin.setVisibility(View.INVISIBLE);

                final String mail = userMail.getText().toString().trim();
                final String password = userPassword.getText().toString().trim();

                if (!validarEntradas(userMail,userPassword));


                else{
                    signIn(mail, password);
                }
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginBtnCriar:

                Intent registerActivity = new Intent(getApplicationContext(), a_RegisterActivity.class);
                startActivity(registerActivity);
                break;

        }
    }



    public void btnRecuperarAcesso(View view) {

        Intent recuperarDados = new Intent(getApplicationContext(), b_RecuperarSenhaActivity.class);
        startActivity(recuperarDados);
        finish();
    }


    //////////////////////////////////////////////
    private boolean validarEntradas(EditText userMail, EditText userPassword){

        final String mail = userMail.getText().toString().trim();
        final String password = userPassword.getText().toString().trim();

        if (mail.isEmpty()) {
            userMail.setError("Informe o endereço de email!");
            Toast.makeText(this, "Informe o endereço de email!", Toast.LENGTH_SHORT).show();
            loginProgress.setVisibility(View.INVISIBLE);
            btnLogin.setVisibility(View.VISIBLE);
            return false;
        }

        if (password.isEmpty()) {
            userPassword.setError("Informe a senha!");
            Toast.makeText(this, "Informe a senha!", Toast.LENGTH_SHORT).show();
            loginProgress.setVisibility(View.INVISIBLE);
            btnLogin.setVisibility(View.VISIBLE);
            return false;
        }

        return true;

    }
    //////////////////////////////////////////////

    private void signIn(final String mail, String password) {

        mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    loginProgress.setVisibility(View.INVISIBLE);
                    btnLogin.setVisibility(View.VISIBLE);
                    showMessage("Login feito com sucesso!");
                    updateUI();
                }
                else
                    showMessage("Email ou senha inválidos!");
                loginProgress.setVisibility(View.INVISIBLE);
                btnLogin.setVisibility(View.VISIBLE);




            }
        });

    }

    private void updateUI() {

        startActivity(HomeActivity);
        finish();

    }





    private void showMessage(String text) {
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null){

            updateUI();
        }

    }



}
