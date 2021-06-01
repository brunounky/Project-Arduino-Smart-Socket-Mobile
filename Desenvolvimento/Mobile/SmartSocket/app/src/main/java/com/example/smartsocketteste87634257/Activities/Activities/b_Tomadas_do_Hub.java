package com.example.smartsocketteste87634257.Activities.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.example.smartsocketteste87634257.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

public class b_Tomadas_do_Hub extends AppCompatActivity  {

    private TextView tvNome;
    private Toolbar toolbar;
    Dialog myDialog2;
    public  String value1,value2,value3,value4;
    public CardView card1,card2,card3,card4;


    public String NomeTomada;
    public EditText NomeTomadaEdt;


    private TextView txclose;
    private Button btn_addTomada;

    public FirebaseUser currentUser;
    public FirebaseAuth mAuth;

    public  TextView tv_nome_tomada1,tv_nome_tomada2,tv_nome_tomada3,tv_nome_tomada4;
    public String txt_nome_tomada1,txt_nome_tomada2,txt_nome_tomada3,txt_nome_tomada4;
    public Switch switch1,switch2,switch3,switch4;
    public String statusTomada1,statusTomada2,statusTomada3,statusTomada4;
    public TextView textView_opcoes_tomada1,textView_opcoes_tomada2,textView_opcoes_tomada3,textView_opcoes_tomada4;
    public int teste1,teste2,teste3,teste4;
    public String statusSwitch1,statusSwitch2,statusSwitch3,statusSwitch4;

    public TextView txt1,txt2,txt3,txt4;
    public String iphub;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tomadas_hub);

        //ini
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);



        myDialog2 = new Dialog(this);

        tvNome = findViewById(R.id.tv_nomeHub);


        card1 = findViewById(R.id.cardview_id);
        card2 = findViewById(R.id.cardview_id2);
        card3 = findViewById(R.id.cardview_id3);
        card4 = findViewById(R.id.cardview_id4);

        tv_nome_tomada1=  findViewById(R.id.tv_nome_tomada);
        tv_nome_tomada2=  findViewById(R.id.tv_nome_tomada2);
        tv_nome_tomada3=  findViewById(R.id.tv_nome_tomada3);
        tv_nome_tomada4=  findViewById(R.id.tv_nome_tomada4);

        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        switch3 = findViewById(R.id.switch3);
        switch4 = findViewById(R.id.switch4);

        textView_opcoes_tomada1 = findViewById(R.id.textView_opcoes_tomada);
        textView_opcoes_tomada2 = findViewById(R.id.textView_opcoes_tomada2);
        textView_opcoes_tomada3 = findViewById(R.id.textView_opcoes_tomada3);
        textView_opcoes_tomada4 = findViewById(R.id.textView_opcoes_tomada4);



        //tool bar
        toolbar =findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Gerenciar Tomadas");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        PegarIpHub();

        trazerDadosHub();

        TrazerDadosCardView();

        AtualizarSwitchComFirebase();









        //on click switches

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch1.isChecked()){
                    statusTomada1 = "on";
                    FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada1")
                            .setValue(statusTomada1);

                    LigarRele1();

                } else{
                    statusTomada1 ="off";
                    FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada1")
                            .setValue(statusTomada1);

                    DesligarRele1();
                }
            }
        });

        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch2.isChecked()){
                    statusTomada2 = "on";
                    FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada2")
                            .setValue(statusTomada2);

                    LigarRele2();
                } else{
                    statusTomada2 ="off";
                    FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada2")
                            .setValue(statusTomada2);

                    DesligarRele2();
                }
            }
        });

        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch3.isChecked()){
                    statusTomada3 = "on";
                    FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada3")
                            .setValue(statusTomada3);

                    LigarRele3();
                } else {
                    statusTomada3 = "off";
                    FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada3")
                            .setValue(statusTomada3);

                    DesligarRele3();
                }
            }
        });

        switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch4.isChecked()){
                    statusTomada4 = "on";
                    FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada4")
                            .setValue(statusTomada4);

                    LigarRele4();
                } else{
                    statusTomada4 ="off";
                    FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada4")
                            .setValue(statusTomada4);

                    DesligarRele4();
                }
            }
        });


    }

    public void PegarIpHub(){
        final DatabaseReference ipHub =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("ipHub");

        ipHub.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                iphub = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void LigarRele1(){

        OkHttpClient client = new OkHttpClient();

        String url = "http://"+iphub+"/BN";

        Log.i("alarme","teste lig 1 " +url);

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

    public void LigarRele2(){

        OkHttpClient client = new OkHttpClient();

        String url = "http://"+iphub+"/CN";

        Log.i("alarme","teste lig 2 " +url);

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

    public void LigarRele3(){
        OkHttpClient client = new OkHttpClient();

        String url = "http://"+iphub+"/DN";

        Log.i("alarme","teste lig 3 " +url);

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

    public void LigarRele4(){
        OkHttpClient client = new OkHttpClient();

        String url = "http://"+iphub+"/EN";

        Log.i("alarme","teste lig 4 " +url);

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


    public void AtualizarSwitchComFirebase(){

        DatabaseReference status1 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada1");
        DatabaseReference status2 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada2");
        DatabaseReference status3 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada3");
        DatabaseReference status4 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada4");


    status1.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            statusSwitch1 = dataSnapshot.getValue(String.class);

            if (statusSwitch1 != null){

                if (statusSwitch1.equals("on")){
                    switch1.setChecked(true);


                    ////////////////////////

                }

                ////////////////////////////////////


                if (statusSwitch1.equals("off")){
                    switch1.setChecked(false);



                }

                //////////////////////////////////////////

            }

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });

        status2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                statusSwitch2 = dataSnapshot.getValue(String.class);

                if (statusSwitch2 != null){

                    if (statusSwitch2.equals("on")){
                        switch2.setChecked(true);


                    }

                }

                if (statusSwitch2 != null){

                    if (statusSwitch2.equals("off")){
                        switch2.setChecked(false);

                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        status3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                statusSwitch3 = dataSnapshot.getValue(String.class);

                if (statusSwitch3 != null){

                    if (statusSwitch3.equals("on")){
                        switch3.setChecked(true);

                    }

                }

                if (statusSwitch3 != null){

                    if (statusSwitch3.equals("off")){
                        switch3.setChecked(false);


                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        status4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                statusSwitch4 = dataSnapshot.getValue(String.class);

                if (statusSwitch4 != null){

                    if (statusSwitch4.equals("on")){
                        switch4.setChecked(true);


                    }
                    if (statusSwitch4.equals("off")){
                        switch4.setChecked(false);


                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }





    public void popup1(View view) {

        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.delete);
        popupMenu.show();


        final DatabaseReference tomadaa1 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada1");
        final DatabaseReference statuss1 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada1");

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                tomadaa1.removeValue();
                statuss1.removeValue();
                txt1.setVisibility(View.VISIBLE);
                DesligarRele1();
                finish();


                Intent tom1 = new Intent(getApplicationContext(), b_Tomadas_do_Hub.class);
                startActivity(tom1);
                return false;
            }
        });
    }

    public void popup2(View view) {

        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.delete);
        popupMenu.show();


        final DatabaseReference tomadaa2 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada2");
        final DatabaseReference statuss2 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada2");

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                tomadaa2.removeValue();
                statuss2.removeValue();
                txt2.setVisibility(View.VISIBLE);
                DesligarRele2();
                finish();

                Intent tom2 = new Intent(getApplicationContext(), b_Tomadas_do_Hub.class);
                startActivity(tom2);

                return false;
            }
        });
    }

    public void popup3(View view) {

        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.delete);
        popupMenu.show();


        final DatabaseReference tomadaa3 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada3");
        final DatabaseReference statuss3 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada3");

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                tomadaa3.removeValue();
                statuss3.removeValue();
                txt3.setVisibility(View.VISIBLE);
                DesligarRele3();
                finish();


                Intent tom3 = new Intent(getApplicationContext(), b_Tomadas_do_Hub.class);
                startActivity(tom3);
                return false;
            }
        });
    }

    public void popup4(View view) {

        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.delete);
        popupMenu.show();


        final DatabaseReference tomadaa4 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada4");
        final DatabaseReference statuss4 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada4");

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                tomadaa4.removeValue();
                statuss4.removeValue();
                txt4.setVisibility(View.VISIBLE);
                DesligarRele4();
                finish();

                Intent tom4 = new Intent(getApplicationContext(), b_Tomadas_do_Hub.class);
                startActivity(tom4);

                return false;
            }
        });
    }


    public void trazerDadosHub(){


        DatabaseReference hub = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeHub");

        hub.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value1 = dataSnapshot.getValue(String.class);

                if (value1!= null){
                    tvNome.setText(value1);

                }
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });




    }

    public void TrazerDadosCardView(){

        DatabaseReference tomada1 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada1");
        DatabaseReference tomada2 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada2");
        DatabaseReference tomada3 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada3");
        DatabaseReference tomada4 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada4");

        tomada1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value1 = dataSnapshot.getValue(String.class);

                if (value1 != null ){
                    card1.setVisibility(View.VISIBLE);
                    txt1.setVisibility(View.INVISIBLE);
                    tv_nome_tomada1.setText(value1);

                    teste1 = 1;


                } else{
                    teste1 = 0;

                }

                VerificarSeHaTomadas(teste1,teste2,teste3,teste4);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Erro ao carregar a tomada 1!", Toast.LENGTH_SHORT).show();
            }
        });


        tomada2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value2 = dataSnapshot.getValue(String.class);

                if (value2 != null){
                    card2.setVisibility(View.VISIBLE);
                    txt2.setVisibility(View.INVISIBLE);
                    tv_nome_tomada2.setText(value2);

                    teste2 = 1;


                } else{
                    teste2 = 0;

                }

                VerificarSeHaTomadas(teste1,teste2,teste3,teste4);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Erro ao carregar a tomada 2!", Toast.LENGTH_SHORT).show();
            }
        });



        tomada3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value3 = dataSnapshot.getValue(String.class);

                if (value3 != null){
                    card3.setVisibility(View.VISIBLE);
                    txt3.setVisibility(View.INVISIBLE);
                    tv_nome_tomada3.setText(value3);

                    teste3 = 1;

                } else{
                    teste3 = 0;
                }

                VerificarSeHaTomadas(teste1,teste2,teste3,teste4);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Erro ao carregar a tomada 3!", Toast.LENGTH_SHORT).show();
            }
        });


        tomada4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value4 = dataSnapshot.getValue(String.class);

                if (value4 != null){
                    card4.setVisibility(View.VISIBLE);
                    txt4.setVisibility(View.INVISIBLE);
                    tv_nome_tomada4.setText(value4);

                   teste4 = 1;

                   //VerificarSeHaTomadas(teste1,teste2,teste3,teste4);

                }else{
                    teste4 = 0;

                    //VerificarSeHaTomadas(teste1,teste2,teste3,teste4);

                }

                VerificarSeHaTomadas(teste1,teste2,teste3,teste4);
                Log.i("alarme","tomadas!" + ","+teste1+ ","+teste2+ ","+teste3+ ","+teste4);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Erro ao carregar a tomada 4!", Toast.LENGTH_SHORT).show();
            }
        });




    }


    public void VerificarSeHaTomadas(int t1, int t2,int t3,int t4){





        if ((t1+t2+t3+t4)> 0) {

            Toast.makeText(getApplicationContext(), "Tomadas carregadas!",Toast.LENGTH_SHORT).show();

        }
        if ((t1+t2+t3+t4)==0){
            Toast.makeText(getApplicationContext(), "Nenhuma tomada cadastrada!",Toast.LENGTH_SHORT).show();
        }


    }



    public void ShowPopupAddTomada(View view) {




            myDialog2.setContentView(R.layout.janela_custom_popup_add_tomada);

            myDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog2.show();

            txclose = myDialog2.findViewById(R.id.close);
            txclose.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    myDialog2.dismiss();


                }
            });


            btn_addTomada = myDialog2.findViewById(R.id.btn_addTomada);
            btn_addTomada.setOnClickListener(new View.OnClickListener() {




                @Override
                public void onClick(View view) {

                    txt_nome_tomada1 = tv_nome_tomada1.getText().toString().trim();
                    txt_nome_tomada2 = tv_nome_tomada2.getText().toString().trim();
                    txt_nome_tomada3 = tv_nome_tomada3.getText().toString().trim();
                    txt_nome_tomada4 = tv_nome_tomada4.getText().toString().trim();

                    NomeTomadaEdt = myDialog2.findViewById(R.id.edt_nomeTomada);


                    NomeTomada = NomeTomadaEdt.getText().toString().trim();


                    final String gg = "off";




                        if (txt_nome_tomada1.equals("nome tomada 1")) {

                            if (!validarEntradas(NomeTomadaEdt)) {

                            } else {

                                card1.setVisibility(View.VISIBLE);
                                txt1.setVisibility(View.INVISIBLE);

                                tv_nome_tomada1.setText(NomeTomada);


                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada1")
                                        .setValue(NomeTomada).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(Task<Void> task) {

                                        NomeTomadaEdt.setText("");


                                    }
                                });

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada1")
                                        .setValue(gg);


                                myDialog2.dismiss();
                                return;
                            }


                        } else if (txt_nome_tomada2.equals("nome tomada 2")) {

                            if (!validarEntradas(NomeTomadaEdt)) {

                            } else {


                                card2.setVisibility(View.VISIBLE);
                                txt2.setVisibility(View.INVISIBLE);

                                tv_nome_tomada2.setText(NomeTomada);


                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada2")
                                        .setValue(NomeTomada).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(Task<Void> task) {

                                        NomeTomadaEdt.setText("");

                                    }
                                });

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada2")
                                        .setValue(gg);


                                myDialog2.dismiss();
                                return;
                            }

                        } else if (txt_nome_tomada3.equals("nome tomada 3")) {

                            if (!validarEntradas(NomeTomadaEdt)) {

                            } else {


                                card3.setVisibility(View.VISIBLE);
                                txt3.setVisibility(View.INVISIBLE);

                                tv_nome_tomada3.setText(NomeTomada);


                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada3")
                                        .setValue(NomeTomada).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(Task<Void> task) {

                                        NomeTomadaEdt.setText("");

                                    }
                                });

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada3")
                                        .setValue(gg);


                                myDialog2.dismiss();
                                return;
                            }


                        } else if (txt_nome_tomada4.equals("nome tomada 4")) {
                            if (!validarEntradas(NomeTomadaEdt)) {

                            } else {


                                card4.setVisibility(View.VISIBLE);
                                txt4.setVisibility(View.INVISIBLE);

                                tv_nome_tomada4.setText(NomeTomada);


                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada4")
                                        .setValue(NomeTomada).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(Task<Void> task) {


                                        NomeTomadaEdt.setText("");

                                    }
                                });

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada4")
                                        .setValue(gg);


                                myDialog2.dismiss();

                                return;
                            }

                        } else {

                            Toast.makeText(getApplicationContext(), "Limite de tomadas atingido! Limite: 4", Toast.LENGTH_SHORT).show();

                        }

                    }


            });






    }

    public boolean validarEntradas(EditText NomeTomadaEdt){

        if (NomeTomada.isEmpty()){

            NomeTomadaEdt.setError("Informe um valor válido!");
            return false;
        }
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home){
            Intent home = new Intent(getApplicationContext(), b_HubActivity.class);
            startActivity(home);
            finish();
        }
        return  super.onOptionsItemSelected(item);

        }



}
