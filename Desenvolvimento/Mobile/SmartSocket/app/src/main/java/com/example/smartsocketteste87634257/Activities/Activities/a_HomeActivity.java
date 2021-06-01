package com.example.smartsocketteste87634257.Activities.Activities;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass10;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass11;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass12;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass13;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass14;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass15;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass16;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass2;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass3;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass4;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass5;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass6;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass7;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass8;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass9;
import com.example.smartsocketteste87634257.Activities.Activities.Sensor.b_SensorActivity;
import com.example.smartsocketteste87634257.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class a_HomeActivity extends AppCompatActivity implements View.OnClickListener {



    public Toolbar toolbar;
    private CardView cardHub, cardSensor, cardConsumo, cardRotina, cardConfig;
    public FirebaseAuth mAuth;
    public FirebaseUser currentUser;

    public TextView txclose;
    public Button btn_editar;

    Dialog myDialog;

    public TextView UserName;
    public TextView UserMail;
    public ImageView UserPhot;

    public String status;

    private int id;
    private MenuItem led;
    public String iphub;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        myDialog = new Dialog(this);


        //ini
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        //tool bar
        toolbar =findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        //cardViews
        cardHub = findViewById(R.id.hubcardId);
        cardSensor = findViewById(R.id.sensorcardId);
        cardRotina = findViewById(R.id.rotinacardId);

        cardHub.setOnClickListener(this);
        cardSensor.setOnClickListener(this);
        cardRotina.setOnClickListener(this);


        //MÉTODOS
        AtualizarDados();

        InicializarServicos();
        PegarIpHub();




    }

    private void InicializarServicos(){
        startService(new Intent(this, ReceiverClass.class));
        startService(new Intent(this, ReceiverClass2.class));
        startService(new Intent(this, ReceiverClass3.class));
        startService(new Intent(this, ReceiverClass4.class));
        startService(new Intent(this, ReceiverClass5.class));
        startService(new Intent(this, ReceiverClass6.class));
        startService(new Intent(this, ReceiverClass7.class));
        startService(new Intent(this, ReceiverClass8.class));
        startService(new Intent(this, ReceiverClass9.class));
        startService(new Intent(this, ReceiverClass10.class));
        startService(new Intent(this, ReceiverClass11.class));
        startService(new Intent(this, ReceiverClass12.class));
        startService(new Intent(this, ReceiverClass13.class));
        startService(new Intent(this, ReceiverClass14.class));
        startService(new Intent(this, ReceiverClass15.class));
        startService(new Intent(this, ReceiverClass16.class));
    }



    private void AtualizarDados() {

        //dados toolbar

        TextView navUserName = findViewById(R.id.nav_username);

        ImageView navUserPhot = findViewById(R.id.nav_user_phot);

        navUserName.setText("Olá, " + currentUser.getDisplayName());

        Glide.with(this).load(currentUser.getPhotoUrl()).into(navUserPhot);

    }


///////////////////////////////////////////////////////////
    //mostrar popup perfil

    public void ShowPopup(View view) {

        myDialog.setContentView(R.layout.janela_custom_popup_perfil);

        atualizardados2();

        txclose = myDialog.findViewById(R.id.close);

        btn_editar=  myDialog.findViewById(R.id.btn_editar_perfil);

        txclose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();




        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();

                Intent edtPerfil = new Intent(getApplicationContext(), b_Editar_Perfil.class);
                startActivity(edtPerfil);


            }
        });



    }



    public boolean atualizardados2(){
        //dados popup

        UserName = myDialog.findViewById(R.id.nome_perfil);
        UserMail = myDialog.findViewById(R.id.email_perfil);
        UserPhot = myDialog.findViewById(R.id.foto_perfil);

        UserMail.setText(currentUser.getEmail());
        UserName.setText(currentUser.getDisplayName());

        Glide.with(getApplicationContext()).load(currentUser.getPhotoUrl()).into(UserPhot);

        return true;
    }



///////////////////////////////////////////////////////////


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home,menu);

        led = menu.getItem(0);


        verificarLed(led);




        return true;
    }








    public boolean verificarLed(final MenuItem led){

        final DatabaseReference statusLed = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusLed");

        statusLed.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status = dataSnapshot.getValue(String.class);

                if ((status!= null) && (status.equals("on"))) {
                    led.setChecked(true);
                    Log.i("alarme","lig 1 ");

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return true;
    }

    public void ligarLed(){

        OkHttpClient client = new OkHttpClient();

        String url = "http://"+iphub+"/AN";

        Log.i("alarme","teste led lig 1 " +url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

        return;


    }

    public void desligarLed(){

        OkHttpClient client = new OkHttpClient();

        String url = "http://"+iphub+"/AF";

        Log.i("alarme","testeled deslig 1 " +url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

    }

    public void PegarIpHub(){
        final DatabaseReference ipHub =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("ipHub");

        ipHub.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                iphub = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        id = item.getItemId();



        if (id == R.id.led){

            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {

                    if (menuItem.isChecked()){

                        desligarLed();

                        menuItem.setChecked(false);

                        String statusLed = "off";

                        FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusLed")
                                .setValue(statusLed);

                        return true;
                    }
                    else

                    if (!menuItem.isChecked()){

                        ligarLed();

                        menuItem.setChecked(true);

                        String statusLed = "on";

                        FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusLed")
                                .setValue(statusLed);

                        return true;
                    }

                    return false;
                }
            });
        }





        if (id == R.id.sair){


            String statusLed = "off";

            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusLed")
                    .setValue(statusLed);

            desligarLed();

            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada1")
                    .setValue(statusLed);

            DesligarRele1();

            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada2")
                    .setValue(statusLed);

            DesligarRele2();

            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada3")
                    .setValue(statusLed);

            DesligarRele3();

            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada4")
                    .setValue(statusLed);

            DesligarRele4();




            FirebaseAuth.getInstance().signOut();
            Intent loginActivity = new Intent(getApplicationContext(), a_LoginActivity.class);
            startActivity(loginActivity);
            finish();
        }

        if (id == R.id.sobre){
            Intent sobreActivity = new Intent(getApplicationContext(), b_SobreActivity.class);
            startActivity(sobreActivity);
        }

            return  true;
    }


    public void DesligarRele1(){
        OkHttpClient client = new OkHttpClient();

        String url = "http://"+iphub+"/BF";

        Log.i("alarme","teste des 1 " +url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    public void DesligarRele2(){
        OkHttpClient client = new OkHttpClient();

        String url = "http://"+iphub+"/CF";

        Log.i("alarme","teste des 2 " +url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    public void DesligarRele3(){
        OkHttpClient client = new OkHttpClient();

        String url = "http://"+iphub+"/DF";

        Log.i("alarme","teste des 3 " +url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    public void DesligarRele4(){
        OkHttpClient client = new OkHttpClient();

        String url = "http://"+iphub+"/EF";

        Log.i("alarme","teste des 4 " +url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }




    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.hubcardId:
                Toast.makeText(getApplicationContext(), "Carregando...", Toast.LENGTH_LONG).show();

                Intent hub = new Intent(getApplicationContext(), b_HubActivity.class);
                startActivity(hub);
                break;

            case R.id.sensorcardId:

                Intent sensor = new Intent(getApplicationContext(), b_SensorActivity.class);
                startActivity(sensor);
                break;


            case R.id.rotinacardId:
                Toast.makeText(getApplicationContext(), "Carregando...", Toast.LENGTH_LONG).show();
                Intent rot = new Intent(getApplicationContext(), b_RotinasActivity.class);
                startActivity(rot);
                break;






        }


    }




}



