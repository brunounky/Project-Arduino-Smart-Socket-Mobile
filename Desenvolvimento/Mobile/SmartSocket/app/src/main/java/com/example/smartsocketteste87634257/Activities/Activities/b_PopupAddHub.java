package com.example.smartsocketteste87634257.Activities.Activities;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartsocketteste87634257.R;

public class b_PopupAddHub extends AppCompatActivity {

    Dialog myDialog3;
    public EditText addnome,edt_nomeHub;
    public String nomeHub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.janela_custom_popup_add_hub);


        //popup excluir conta
        myDialog3 = new Dialog(this);


    }


}
