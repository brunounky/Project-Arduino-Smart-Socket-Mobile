package com.example.smartsocketteste87634257.Activities.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.smartsocketteste87634257.R;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class b_Editar_Perfil extends AppCompatActivity {

    private Toolbar toolbar;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private EditText  Mail2, Password2, Mail3, Password3;
    Dialog myDialog2;
    public TextView txclose;
    private Button btn_excluir, btn_cancelar;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        //ini
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        //popup excluir conta
        myDialog2 = new Dialog(this);

        





        //tool bar
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Editar Perfil");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //traz dados nos campos
        trazerDados();

    }


    private void trazerDados() {

        //dados toolbar

        TextView edtUserName = findViewById(R.id.nome_editar);

        ImageView edtUserPhot = findViewById(R.id.photo_editar);

        edtUserName.setText(currentUser.getDisplayName());

        Glide.with(this).load(currentUser.getPhotoUrl()).into(edtUserPhot);


    }


    //mostrar popup perfil

    public void ExcluirConta(View view) {

        myDialog2.setContentView(R.layout.janela_custom_popup_excluir_conta);

        txclose = myDialog2.findViewById(R.id.close);



        txclose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view4) {

                myDialog2.dismiss();
            }
        });


        myDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog2.show();



        btn_cancelar = myDialog2.findViewById(R.id.btn_cancelar);

        btn_cancelar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view1) {

                myDialog2.dismiss();


            }
        });

        btn_excluir=  myDialog2.findViewById(R.id.btn_excluir);

        btn_excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){

                            FirebaseAuth.getInstance().signOut();
                            Intent loginActivity = new Intent(getApplicationContext(), a_LoginActivity.class);
                            startActivity(loginActivity);
                            finish();
                            Toast.makeText(getApplicationContext(),"Conta deletada com sucesso!",Toast.LENGTH_LONG).show();

                        }else{

                            Toast.makeText(getApplicationContext(),"Erro. Tente novamente mais tarde!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                FirebaseDatabase.getInstance().getReference("Usuario").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(null).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });



            }


        });







    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent home = new Intent(getApplicationContext(), a_HomeActivity.class);
            startActivity(home);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }







    public boolean validarEntradasEmail(EditText Mail2) {
        Mail3 = findViewById(R.id.emailedit);


        final String mail2 = Mail3.getText().toString().trim();


        if (mail2.equals(currentUser.getEmail())){
            Mail3.setError("Informe um email diferente do atual!");
            Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();

            return false;
        }


        if (mail2.isEmpty()) {
            Mail3.setError("Informe o endereço de email!");
            Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();

            return false;
        }


        String emailInput = Mail3.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            Mail3.setError("Informe um email válido!");
           Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();
           return false;
         }



        return true;

    }

    public boolean validarEntradasSenha(EditText Password2){

        Password3 = findViewById(R.id.senhaedit);
        final String password2 = Password3.getText().toString().trim();


        if (password2.isEmpty()) {
            Password3.setError("Informe uma senha!");
            Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password2.length() < 6) {
            Password3.setError("A senha deve seis ou mais caracteres!");
            Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return  true;
    }


    public void MudarSenha(View view) {

        if (!validarEntradasSenha(Password2)) {


        }else{

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            //mudar senha
            final EditText senhaedt = findViewById(R.id.senhaedit);
            final String bb = senhaedt.getText().toString().trim();


            user.updatePassword(bb).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(b_Editar_Perfil.this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show();
                        senhaedt.setText("");


                    }else{
                        Toast.makeText(b_Editar_Perfil.this, "Erro. Tente novamente mais tarde!", Toast.LENGTH_SHORT).show();


                    }
                }
            });

        }

    }

    public void MudarEmail(View view) {

        if (!validarEntradasEmail(Mail2)) {


        }else{


            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            final EditText emailedt5 = findViewById(R.id.emailedit);
            final String aa = emailedt5.getText().toString().trim();


            user.updateEmail(aa).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(b_Editar_Perfil.this, "Edição de Email completa.", Toast.LENGTH_SHORT).show();
                        emailedt5.setText("");


                    }else{
                        Toast.makeText(b_Editar_Perfil.this, "Erro. Tente novamente mais tarde!", Toast.LENGTH_SHORT).show();
                        

                    }
                }

            });
        }
    }


}
