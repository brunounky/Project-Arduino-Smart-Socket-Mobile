package com.example.smartsocketteste87634257.Activities.Activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.smartsocketteste87634257.R;

public class b_PopupAddTomada extends AppCompatActivity {

    Dialog myDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.janela_custom_popup_add_tomada);



        myDialog2 = new Dialog(this);


    }
}
