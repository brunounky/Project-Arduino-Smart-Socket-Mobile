package com.example.smartsocketteste87634257.Activities.Activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.smartsocketteste87634257.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class b_PopupPerfilUsuarioActivity extends AppCompatActivity  {

    Dialog myDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.janela_custom_popup_perfil);

        myDialog = new Dialog(this);



    }


}
