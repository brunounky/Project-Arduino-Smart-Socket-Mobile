package com.example.smartsocketteste87634257.Activities.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.smartsocketteste87634257.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;


public class a_RegisterActivity extends AppCompatActivity {


    ImageView ImgUserPhoto;
    static int PRqCode = 1;
    static int REQUESCODE = 1;
    Uri pickedImgUri;


    public EditText userEmail, userPassword, userPassword2, userName;
    private ProgressBar loadingProgress;
    private Button regBtn;
    private TextView regLoginConta;
    private CircleImageView regUserPhoto;


    private FirebaseAuth mAuth;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseReference = FirebaseDatabase.getInstance().getReference("Usuario");

        //inu views
        regUserPhoto = findViewById(R.id.regUserPhoto);
        userEmail = findViewById(R.id.regMail);
        userName = findViewById(R.id.regNome);
        userPassword = findViewById(R.id.regSenha);
        userPassword2 = findViewById(R.id.regSenha2);
        loadingProgress = findViewById(R.id.progressBar);
        regBtn = findViewById(R.id.regBtn);


        loadingProgress.setVisibility(View.INVISIBLE);

        regLoginConta = findViewById(R.id.regLogin);
        regLoginConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent loginActivity = new Intent(getApplicationContext(), a_LoginActivity.class);
                startActivity(loginActivity);

            }
        });


        mAuth = FirebaseAuth.getInstance();

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                regBtn.setVisibility(View.INVISIBLE);
                //loadingProgress.setVisibility(View.VISIBLE);
                final String email = userEmail.getText().toString().trim();
                final String password = userPassword.getText().toString().trim();
                final String password2 = userPassword2.getText().toString().trim();
                final String name = userName.getText().toString().trim();



                if (!validarEntradas2(userName, userEmail, userPassword, userPassword2)) {


                    regBtn.setVisibility(View.VISIBLE);
                    loadingProgress.setVisibility(View.INVISIBLE);

                } else {

                    CreateUserAccount(email, name, password);


                }
            }
        });

        ImgUserPhoto = findViewById(R.id.regUserPhoto);

        ImgUserPhoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= 22) {
                    checkAndRequestForPermission();

                } else
                    openGallery();


            }


        });

    }



    //////////////////////////////////////////////
    private boolean validarEntradas2(EditText userName, EditText userEmail, EditText userPassword, EditText userPassword2) {

        final String mail2 = userEmail.getText().toString().trim();
        final String password2 = userPassword.getText().toString().trim();
        final String password3 = userPassword2.getText().toString().trim();
        final String name2 = userName.getText().toString().trim();


        if (name2.isEmpty()) {
            userName.setError("Informe um nome de usuário!");
            Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();
            regBtn.setVisibility(View.VISIBLE);
            loadingProgress.setVisibility(View.INVISIBLE);
            return false;
        }

        if (mail2.isEmpty()) {
            userEmail.setError("Informe o endereço de email!");
            Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();
            regBtn.setVisibility(View.VISIBLE);
            loadingProgress.setVisibility(View.INVISIBLE);
            return false;
        }


        String emailInput = userEmail.getText().toString().trim();

        if  (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            userEmail.setError("Informe um email válido!");
            Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();
            regBtn.setVisibility(View.VISIBLE);
            loadingProgress.setVisibility(View.INVISIBLE);
            return false;
        }

        if (password2.isEmpty()) {
            userPassword.setError("Informe uma senha!");
            Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();
            regBtn.setVisibility(View.VISIBLE);
            loadingProgress.setVisibility(View.INVISIBLE);
            return false;
        }

        if (password2.length() < 6) {
            userPassword.setError("A senha deve seis ou mais caracteres!");
            Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();
            regBtn.setVisibility(View.VISIBLE);
            loadingProgress.setVisibility(View.INVISIBLE);
            return false;
        }


        if (password3.isEmpty()) {
            userPassword2.setError("Confirme a senha anterior!");
            Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();
            regBtn.setVisibility(View.VISIBLE);
            loadingProgress.setVisibility(View.INVISIBLE);
            return false;
        }


        if (!password3.equals(password2)) {
            userPassword2.setError("As senhas têm que ser iguais!");
            Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();
            regBtn.setVisibility(View.VISIBLE);
            loadingProgress.setVisibility(View.INVISIBLE);
            return false;
        }

        if (!password2.equals(password3)) {
            userPassword.setError("As senhas têm que ser iguais!");
            Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();
            regBtn.setVisibility(View.VISIBLE);
            loadingProgress.setVisibility(View.INVISIBLE);
            return false;
        }

        if (password3.length() < 6) {
            userPassword2.setError("A senha deve seis ou mais caracteres!");
            Toast.makeText(this, "Por Favor Verifique os Campos!!", Toast.LENGTH_SHORT).show();
            regBtn.setVisibility(View.VISIBLE);
            loadingProgress.setVisibility(View.INVISIBLE);
            return false;
        }


        return true;

    }
    //////////////////////////////////////////////

    private void CreateUserAccount(final String email, final String nome, String password) {




        if (pickedImgUri != null){

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                regBtn.setVisibility(View.INVISIBLE);
                                loadingProgress.setVisibility(View.VISIBLE);

                                showMessage("Analisando!");

                                updateUserInfo(nome, pickedImgUri, mAuth.getCurrentUser());


                            } else {

                                showMessage("Falha na Criação da Conta. Verifique se os campos estão formatados corretamente!" );
                                regBtn.setVisibility(View.VISIBLE);
                                loadingProgress.setVisibility(View.INVISIBLE);
                            }

                        }
                    });

        }
        else{
            Toast.makeText(this, "Forneça a imagem!", Toast.LENGTH_SHORT).show();
            regBtn.setVisibility(View.VISIBLE);
            loadingProgress.setVisibility(View.INVISIBLE);
        }

    }

    private void updateUserInfo(final String nome, Uri pickedImgUri, final FirebaseUser currentUser) {

        StorageReference mStorage= FirebaseStorage.getInstance().getReference().child("users_photos");

        if (pickedImgUri != null) {

            final StorageReference imageFilePath = mStorage.child(pickedImgUri.getLastPathSegment());

            imageFilePath.putFile(pickedImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            //uri contain user image url
                            UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(nome)
                                    .setPhotoUri(uri)
                                    .build();


                            currentUser.updateProfile(profileUpdate)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if (task.isSuccessful()) {

                                                //user info updated successfully
                                                showMessage("Registro Completo!");
                                                updateUI();
                                            }

                                        }
                                    });

                        }
                    });

                }
            });
        }
        else{
            Toast.makeText(this, "Forneça a imagem!", Toast.LENGTH_SHORT).show();
            regBtn.setVisibility(View.VISIBLE);
        }
    }

    private void updateUI() {

        Intent homeActivity = new Intent(getApplicationContext(), a_HomeActivity.class);
        startActivity(homeActivity);
        finish();

    }

    private void showMessage(String message) {

        Toast.makeText(getApplicationContext(), message,Toast.LENGTH_LONG).show();


    }

    private void openGallery() {

        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,REQUESCODE);

    }

    private void checkAndRequestForPermission() {

        if (ContextCompat.checkSelfPermission(a_RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(a_RegisterActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                Toast.makeText(a_RegisterActivity.this, "Por Favor Aceite a Permissão!", Toast.LENGTH_SHORT).show();
            }
            else{
                ActivityCompat.requestPermissions(a_RegisterActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PRqCode);
            }
        }
        else
            openGallery();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode== REQUESCODE && data != null){


            pickedImgUri=data.getData();

            ImgUserPhoto.setImageURI(pickedImgUri);


        }

    }



}
