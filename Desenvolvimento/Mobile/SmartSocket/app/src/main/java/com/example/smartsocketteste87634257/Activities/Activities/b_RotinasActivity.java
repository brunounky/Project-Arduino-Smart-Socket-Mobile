package com.example.smartsocketteste87634257.Activities.Activities;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass2;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass3;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass4;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass5;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass6;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass7;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass8;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass9;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass10;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass11;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass12;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass13;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass14;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass15;
import com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio.ReceiverClass16;
import com.example.smartsocketteste87634257.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class b_RotinasActivity extends AppCompatActivity {

    private Toolbar toolbar;
    Dialog myDialog4;

    private TextView txclose;

    public FirebaseUser currentUser;
    public FirebaseAuth mAuth;

    public String iphub;

    public Spinner spinner2, spinner1;
    public Button btnAddHoraLigar;

    public CardView card1, card2, card3, card4, card5, card6, card7, card8;

    public EditText editHora,editMinuto,editMinutoDois,editHoraDois;
    public String editHora1, editMinuto1, editHora2, editMinuto2;
    public EditText edtNome;
    public String edtNome1;

    public Calendar calendar1,calendar2,calendar3,calendar4,calendar5,calendar6,calendar7,calendar8,calendar9,calendar10,calendar11,calendar12,
    calendar13,calendar14,calendar15,calendar16;


    public TextView nomeRot1Tom1,nomeRot2Tom1,nomeRot1Tom2,nomeRot2Tom2,nomeRot1Tom3,nomeRot2Tom3,nomeRot1Tom4,nomeRot2Tom4;
    public TextView horaRot1Tom1,horaRot2Tom1,horaRot1Tom2,horaRot2Tom2,horaRot1Tom3,horaRot2Tom3,horaRot1Tom4,horaRot2Tom4;


    public String nomeRot1,nomeRot2,nomeRot3,nomeRot4,nomeRot5,nomeRot6,nomeRot7,nomeRot8;
    public Long HoraLig1,HoraLig2,HoraLig3,HoraLig4,HoraLig5,HoraLig6,HoraLig7,HoraLig8;
    public Long HoraDeslig1,HoraDeslig2,HoraDeslig3,HoraDeslig4,HoraDeslig5,HoraDeslig6,HoraDeslig7,HoraDeslig8;
    public Long MinutoLig1,MinutoLig2,MinutoLig3,MinutoLig4,MinutoLig5,MinutoLig6,MinutoLig7,MinutoLig8;
    public Long MinutoDeslig1,MinutoDeslig2,MinutoDeslig3,MinutoDeslig4,MinutoDeslig5,MinutoDeslig6,MinutoDeslig7,MinutoDeslig8;

    public  String txtNomeRot1Tom1,txtNomeRot2Tom1,txtNomeRot1Tom2,txtNomeRot2Tom2,txtNomeRot1Tom3,txtNomeRot2Tom3,txtNomeRot1Tom4,txtNomeRot2Tom4;

    public ImageView img_tom1rot1,img_tom1rot2,img_tom2rot1,img_tom2rot2,img_tom3rot1,img_tom3rot2,img_tom4rot1,img_tom4rot2;

    public int a1,a2,a3,a4,a5,a6,a7,a8;
    public String HoraLig11,HoraLig22,HoraLig33,HoraLig44,HoraLig55,HoraLig66,HoraLig77,HoraLig88;

    public PendingIntent tarefaPendingIntent1,tarefaPendingIntent2,tarefaPendingIntent3,tarefaPendingIntent4,tarefaPendingIntent5,tarefaPendingIntent6,tarefaPendingIntent7,tarefaPendingIntent8,
                        tarefaPendingIntent9,tarefaPendingIntent10,tarefaPendingIntent11,tarefaPendingIntent12,tarefaPendingIntent13,tarefaPendingIntent14,tarefaPendingIntent15,tarefaPendingIntent16;

    public Intent tarefaIntent1,tarefaIntent2,tarefaIntent3,tarefaIntent4,tarefaIntent5,tarefaIntent6,tarefaIntent7,tarefaIntent8,
            tarefaIntent9,tarefaIntent10,tarefaIntent11,tarefaIntent12,tarefaIntent13,tarefaIntent14,tarefaIntent15,tarefaIntent16;

    public AlarmManager alarmManager1,alarmManager2,alarmManager3,alarmManager4,alarmManager5,alarmManager6,alarmManager7,alarmManager8,
                        alarmManager9,alarmManager10,alarmManager11,alarmManager12,alarmManager13,alarmManager14,alarmManager15,alarmManager16;

    public String hora1,hora2,hora3,hora4,hora5,hora6,hora7,hora8,hora9,hora10,hora11,hora12,hora13,hora14,hora15,hora16;
    public String minuto1,minuto2,minuto3,minuto4,minuto5,minuto6,minuto7,minuto8,minuto9,minuto10,minuto11,minuto12,minuto13,minuto14,minuto15,minuto16;

    public String tomadaa1, tomadaa2, tomadaa3, tomadaa4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotinas);


        img_tom1rot1 = findViewById(R.id.img_tom1rot1);
        img_tom1rot2 = findViewById(R.id.img_tom1rot2);
        img_tom2rot1 = findViewById(R.id.img_tom2rot1);
        img_tom2rot2 = findViewById(R.id.img_tom2rot2);
        img_tom3rot1 = findViewById(R.id.img_tom3rot1);
        img_tom3rot2 = findViewById(R.id.img_tom3rot2);
        img_tom4rot1 = findViewById(R.id.img_tom4rot1);
        img_tom4rot2 = findViewById(R.id.img_tom4rot2);

        nomeRot1Tom1 = findViewById(R.id.nomeRot1Tom1);
        nomeRot2Tom1 = findViewById(R.id.nomeRot2Tom1);
        nomeRot1Tom2 = findViewById(R.id.nomeRot1Tom2);
        nomeRot2Tom2 = findViewById(R.id.nomeRot2Tom2);
        nomeRot1Tom3 = findViewById(R.id.nomeRot1Tom3);
        nomeRot2Tom3 = findViewById(R.id.nomeRot2Tom3);
        nomeRot1Tom4 = findViewById(R.id.nomeRot1Tom4);
        nomeRot2Tom4 = findViewById(R.id.nomeRot2Tom4);

        horaRot1Tom1 = findViewById(R.id.horaRot1Tom1);
        horaRot2Tom1 = findViewById(R.id.horaRot2Tom1);
        horaRot1Tom2 = findViewById(R.id.horaRot1Tom2);
        horaRot2Tom2 = findViewById(R.id.horaRot2Tom2);
        horaRot1Tom3 = findViewById(R.id.horaRot1Tom3);
        horaRot2Tom3 = findViewById(R.id.horaRot2Tom3);
        horaRot1Tom4 = findViewById(R.id.horaRot1Tom4);
        horaRot2Tom4 = findViewById(R.id.horaRot2Tom4);


        card1 = findViewById(R.id.rot1tom1);
        card2 = findViewById(R.id.rot2tom1);
        card3 = findViewById(R.id.rot1tom2);
        card4 = findViewById(R.id.rot2tom2);
        card5 = findViewById(R.id.rot1tom3);
        card6 = findViewById(R.id.rot2tom3);
        card7 = findViewById(R.id.rot1tom4);
        card8 = findViewById(R.id.rot2tom4);

        card1.setEnabled(false);
        card2.setEnabled(false);
        card3.setEnabled(false);
        card4.setEnabled(false);
        card5.setEnabled(false);
        card6.setEnabled(false);
        card7.setEnabled(false);
        card8.setEnabled(false);




        //ini
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();


        myDialog4 = new Dialog(this);


        //tool bar
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Gerenciar rotinas");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        trazerDadosCardView();
        longClickCards();
        verificarseharotinas();
        PegarIpHub();

    }

    public void verificarseharotinas(){

        final DatabaseReference d1 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina1");
        final DatabaseReference d2 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina2");
        final DatabaseReference d3 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina3");
        final DatabaseReference d4 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina4");
        final DatabaseReference d5 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina5");
        final DatabaseReference d6 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina6");
        final DatabaseReference d7 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina7");
        final DatabaseReference d8 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina8");


        d1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HoraLig11 = dataSnapshot.getValue(String.class);

                if (HoraLig11!=null){
                    a1=1;
                }else{
                    a1=0;

                }

                VerificarSeHaRotinas(a1, a2, a3, a4, a5, a6, a7, a8);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        d2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HoraLig22 = dataSnapshot.getValue(String.class);

                if (HoraLig22!=null){
                    a2=1;

                }else{
                    a2=0;

                }

                VerificarSeHaRotinas(a1, a2, a3, a4, a5, a6, a7, a8);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        d3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HoraLig33 = dataSnapshot.getValue(String.class);

                if (HoraLig33!=null){
                    a3=1;

                }else{
                    a3=0;

                }

                VerificarSeHaRotinas(a1, a2, a3, a4, a5, a6, a7, a8);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        d4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HoraLig44 = dataSnapshot.getValue(String.class);

                if (HoraLig44!=null){
                    a4=1;

                }else{
                    a4=0;

                }

                VerificarSeHaRotinas(a1, a2, a3, a4, a5, a6, a7, a8);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        d5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HoraLig55 = dataSnapshot.getValue(String.class);

                if (HoraLig55!=null){
                    a5=1;

                }else{
                    a5=0;

                }

                VerificarSeHaRotinas(a1, a2, a3, a4, a5, a6, a7, a8);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        d6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HoraLig66 = dataSnapshot.getValue(String.class);

                if (HoraLig66!=null){
                    a6=1;

                }else{
                    a6=0;

                }

                VerificarSeHaRotinas(a1, a2, a3, a4, a5, a6, a7, a8);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        d7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HoraLig77 = dataSnapshot.getValue(String.class);

                if (HoraLig77!=null){
                    a7=1;

                }else{
                    a7=0;

                }

                VerificarSeHaRotinas(a1, a2, a3, a4, a5, a6, a7, a8);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        d8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HoraLig88 = dataSnapshot.getValue(String.class);

                if (HoraLig88 != null) {
                    a8 = 1;

                } else {
                    a8 = 0;

                }
                VerificarSeHaRotinas(a1, a2, a3, a4, a5, a6, a7, a8);
                Log.i("alarme","valores: "+a1+","+a2+","+a3+","+a4+","+a5+","+a6+","+a7+","+a8);
            }


                @Override
                public void onCancelled (DatabaseError databaseError){

                }

        });

    }

    public void VerificarSeHaRotinas(int teste1,int teste2,int teste3,int teste4,int teste5,int teste6,int teste7,int teste8){

            if (teste1+teste2+teste3+teste4+teste5+teste6+teste7+teste8>0){
                Toast.makeText(getApplicationContext(), "Rotinas carregadas!", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(getApplicationContext(), "Nenhuma rotina cadastrada!", Toast.LENGTH_SHORT).show();
            }

        }



    public void trazerDadosCardView(){



        //VERIFICAR SE HÁ ROTINAS
        final DatabaseReference HoraLigarRot1 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar1");
        final DatabaseReference HoraLigarRot2 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar2");
        final DatabaseReference HoraLigarRot3 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar3");
        final DatabaseReference HoraLigarRot4 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar4");
        final DatabaseReference HoraLigarRot5 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar5");
        final DatabaseReference HoraLigarRot6 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar6");
        final DatabaseReference HoraLigarRot7 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar7");
        final DatabaseReference HoraLigarRot8 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar8");

        final DatabaseReference MinutoLigarRot1 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar1");
        final DatabaseReference MinutoLigarRot2 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar2");
        final DatabaseReference MinutoLigarRot3 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar3");
        final DatabaseReference MinutoLigarRot4 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar4");
        final DatabaseReference MinutoLigarRot5 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar5");
        final DatabaseReference MinutoLigarRot6 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar6");
        final DatabaseReference MinutoLigarRot7 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar7");
        final DatabaseReference MinutoLigarRot8 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar8");

        final DatabaseReference HoraDesligarRot1 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar1");
        final DatabaseReference HoraDesligarRot2 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar2");
        final DatabaseReference HoraDesligarRot3 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar3");
        final DatabaseReference HoraDesligarRot4 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar4");
        final DatabaseReference HoraDesligarRot5 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar5");
        final DatabaseReference HoraDesligarRot6 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar6");
        final DatabaseReference HoraDesligarRot7 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar7");
        final DatabaseReference HoraDesligarRot8 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar8");

        final DatabaseReference MinutoDesligarRot1 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar1");
        final DatabaseReference MinutoDesligarRot2 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar2");
        final DatabaseReference MinutoDesligarRot3 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar3");
        final DatabaseReference MinutoDesligarRot4 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar4");
        final DatabaseReference MinutoDesligarRot5 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar5");
        final DatabaseReference MinutoDesligarRot6 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar6");
        final DatabaseReference MinutoDesligarRot7 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar7");
        final DatabaseReference MinutoDesligarRot8 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar8");

        final DatabaseReference NomeRot1 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina1");
        final DatabaseReference NomeRot2 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina2");
        final DatabaseReference NomeRot3 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina3");
        final DatabaseReference NomeRot4 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina4");
        final DatabaseReference NomeRot5 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina5");
        final DatabaseReference NomeRot6 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina6");
        final DatabaseReference NomeRot7 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina7");
        final DatabaseReference NomeRot8 =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina8");

        //////////////////////////////////////////////////////////////////////////////

        NomeRot1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nomeRot1 = dataSnapshot.getValue(String.class);



                if (nomeRot1 != null){


                    HoraLigarRot1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraLig1 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoLigarRot1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoLig1 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    HoraDesligarRot1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraDeslig1 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoDesligarRot1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoDeslig1 = dataSnapshot.getValue(Long.class);


                            //colocar valores nos campos
                            card1.setVisibility(View.VISIBLE);
                            nomeRot1Tom1.setText(nomeRot1);
                            img_tom1rot1.setImageResource(R.drawable.b_icone_alarm_on);
                            card1.setEnabled(true);
                            img_tom1rot1.setBackgroundResource(R.drawable.b_shape_redondo_verde);


                        if (MinutoDeslig1 != null) {
                            String ak1 = HoraLig1.toString();
                            String ak2 = MinutoLig1.toString();
                            String ak3 = HoraDeslig1.toString();
                            String ak4 = MinutoDeslig1.toString();


                            if (ak1.length() == 1) {
                                int al = Integer.parseInt(ak1);
                                hora1 = String.format("%02d", al);
                            }else{
                                hora1= ak1;

                            }

                            if (ak2.length() == 1) {
                                int al = Integer.parseInt(ak2);
                                minuto1 = String.format("%02d", al);

                            }else{
                                minuto1= ak2;

                            }


                            if (ak3.length() == 1) {
                                int al = Integer.parseInt(ak3);
                                hora2 = String.format("%02d", al);

                            }else{
                                hora2= ak3;

                            }

                            if (ak4.length() == 1) {
                                int al = Integer.parseInt(ak4);
                                minuto2 = String.format("%02d", al);

                            } else{
                                minuto2= ak4;

                            }

                            horaRot1Tom1.setText(hora1+":"+minuto1+" - "+ hora2+ ":" + minuto2);


                        }




                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ////////////////////////////////////////////////////////////////////////

        NomeRot2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nomeRot2 = dataSnapshot.getValue(String.class);



                if (nomeRot2 != null){


                    HoraLigarRot2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraLig2 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoLigarRot2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoLig2 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    HoraDesligarRot2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraDeslig2 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoDesligarRot2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoDeslig2 = dataSnapshot.getValue(Long.class);


                            //colocar valores nos campos
                            card2.setVisibility(View.VISIBLE);

                            nomeRot2Tom1.setText(nomeRot2);
                            img_tom1rot2.setImageResource(R.drawable.b_icone_alarm_on);
                            card2.setEnabled(true);
                            img_tom1rot2.setBackgroundResource(R.drawable.b_shape_redondo_verde);

                            if (MinutoDeslig2 != null) {
                                String ak1 = HoraLig2.toString();
                                String ak2 = MinutoLig2.toString();
                                String ak3 = HoraDeslig2.toString();
                                String ak4 = MinutoDeslig2.toString();


                                if (ak1.length() == 1) {
                                    int al = Integer.parseInt(ak1);
                                    hora3 = String.format("%02d", al);
                                }else{
                                    hora3= ak1;

                                }

                                if (ak2.length() == 1) {
                                    int al = Integer.parseInt(ak2);
                                    minuto3 = String.format("%02d", al);

                                }else{
                                    minuto3= ak2;

                                }


                                if (ak3.length() == 1) {
                                    int al = Integer.parseInt(ak3);
                                    hora4 = String.format("%02d", al);

                                }else{
                                    hora4= ak3;

                                }

                                if (ak4.length() == 1) {
                                    int al = Integer.parseInt(ak4);
                                    minuto4 = String.format("%02d", al);

                                } else{
                                    minuto4= ak4;

                                }

                                horaRot2Tom1.setText(hora3+":"+minuto3+" - "+ hora4+ ":" + minuto4);


                            }



                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ////////////////////////////////////////////////////////////////////////

        NomeRot3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nomeRot3 = dataSnapshot.getValue(String.class);



                if (nomeRot3 != null){



                    HoraLigarRot3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraLig3 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoLigarRot3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoLig3 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    HoraDesligarRot3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraDeslig3 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoDesligarRot3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoDeslig3 = dataSnapshot.getValue(Long.class);


                            //colocar valores nos campos
                            card3.setVisibility(View.VISIBLE);

                            nomeRot1Tom2.setText(nomeRot3);
                            img_tom2rot1.setImageResource(R.drawable.b_icone_alarm_on);
                            card3.setEnabled(true);
                            img_tom2rot1.setBackgroundResource(R.drawable.b_shape_redondo_verde);

                            if (MinutoDeslig3 != null) {
                                String ak1 = HoraLig3.toString();
                                String ak2 = MinutoLig3.toString();
                                String ak3 = HoraDeslig3.toString();
                                String ak4 = MinutoDeslig3.toString();


                                if (ak1.length() == 1) {
                                    int al = Integer.parseInt(ak1);
                                    hora5 = String.format("%02d", al);
                                }else{
                                    hora5= ak1;

                                }

                                if (ak2.length() == 1) {
                                    int al = Integer.parseInt(ak2);
                                    minuto5 = String.format("%02d", al);

                                }else{
                                    minuto5= ak2;

                                }


                                if (ak3.length() == 1) {
                                    int al = Integer.parseInt(ak3);
                                    hora6 = String.format("%02d", al);

                                }else{
                                    hora6= ak3;

                                }

                                if (ak4.length() == 1) {
                                    int al = Integer.parseInt(ak4);
                                    minuto6 = String.format("%02d", al);

                                } else{
                                    minuto6= ak4;

                                }

                                horaRot1Tom2.setText(hora5+":"+minuto5+" - "+ hora6+ ":" + minuto6);


                            }



                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ////////////////////////////////////////////////////////////////////////

        NomeRot4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {



                nomeRot4 = dataSnapshot.getValue(String.class);

                if (nomeRot4 != null){



                    HoraLigarRot4.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraLig4 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoLigarRot4.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoLig4 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    HoraDesligarRot4.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraDeslig4 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoDesligarRot4.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoDeslig4 = dataSnapshot.getValue(Long.class);


                            //colocar valores nos campos
                            card4.setVisibility(View.VISIBLE);

                            nomeRot2Tom2.setText(nomeRot4);
                            img_tom2rot2.setImageResource(R.drawable.b_icone_alarm_on);
                            card4.setEnabled(true);
                            img_tom2rot2.setBackgroundResource(R.drawable.b_shape_redondo_verde);

                            if (MinutoDeslig4 != null) {
                                String ak1 = HoraLig4.toString();
                                String ak2 = MinutoLig4.toString();
                                String ak3 = HoraDeslig4.toString();
                                String ak4 = MinutoDeslig4.toString();


                                if (ak1.length() == 1) {
                                    int al = Integer.parseInt(ak1);
                                    hora7 = String.format("%02d", al);
                                }else{
                                    hora7= ak1;

                                }

                                if (ak2.length() == 1) {
                                    int al = Integer.parseInt(ak2);
                                    minuto7 = String.format("%02d", al);

                                }else{
                                    minuto7= ak2;

                                }


                                if (ak3.length() == 1) {
                                    int al = Integer.parseInt(ak3);
                                    hora8 = String.format("%02d", al);

                                }else{
                                    hora8= ak3;

                                }

                                if (ak4.length() == 1) {
                                    int al = Integer.parseInt(ak4);
                                    minuto8 = String.format("%02d", al);

                                } else{
                                    minuto8= ak4;

                                }

                                horaRot2Tom2.setText(hora7+":"+minuto7+" - "+ hora8+ ":" + minuto8);


                            }



                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ////////////////////////////////////////////////////////////////////////

        NomeRot5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nomeRot5 = dataSnapshot.getValue(String.class);



                if (nomeRot5 != null){



                    HoraLigarRot5.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraLig5 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoLigarRot5.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoLig5 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    HoraDesligarRot5.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraDeslig5 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoDesligarRot5.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoDeslig5 = dataSnapshot.getValue(Long.class);


                            //colocar valores nos campos
                            card5.setVisibility(View.VISIBLE);

                            nomeRot1Tom3.setText(nomeRot5);
                            img_tom3rot1.setImageResource(R.drawable.b_icone_alarm_on);
                            card5.setEnabled(true);
                            img_tom3rot1.setBackgroundResource(R.drawable.b_shape_redondo_verde);

                            if (MinutoDeslig5 != null) {
                                String ak1 = HoraLig5.toString();
                                String ak2 = MinutoLig5.toString();
                                String ak3 = HoraDeslig5.toString();
                                String ak4 = MinutoDeslig5.toString();


                                if (ak1.length() == 1) {
                                    int al = Integer.parseInt(ak1);
                                    hora9 = String.format("%02d", al);
                                }else{
                                    hora9= ak1;

                                }

                                if (ak2.length() == 1) {
                                    int al = Integer.parseInt(ak2);
                                    minuto9 = String.format("%02d", al);

                                }else{
                                    minuto9= ak2;

                                }


                                if (ak3.length() == 1) {
                                    int al = Integer.parseInt(ak3);
                                    hora10 = String.format("%02d", al);

                                }else{
                                    hora10= ak3;

                                }

                                if (ak4.length() == 1) {
                                    int al = Integer.parseInt(ak4);
                                    minuto10 = String.format("%02d", al);

                                } else{
                                    minuto10= ak4;

                                }

                                horaRot1Tom3.setText(hora9+":"+minuto9+" - "+ hora10+ ":" + minuto10);


                            }




                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ////////////////////////////////////////////////////////////////////////

        NomeRot6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nomeRot6 = dataSnapshot.getValue(String.class);



                if (nomeRot6 != null){



                    HoraLigarRot6.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraLig6 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoLigarRot6.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoLig6 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    HoraDesligarRot6.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraDeslig6 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoDesligarRot6.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoDeslig6 = dataSnapshot.getValue(Long.class);


                            //colocar valores nos campos
                            card6.setVisibility(View.VISIBLE);

                            nomeRot2Tom3.setText(nomeRot6);
                            img_tom3rot2.setImageResource(R.drawable.b_icone_alarm_on);
                            card6.setEnabled(true);
                            img_tom3rot2.setBackgroundResource(R.drawable.b_shape_redondo_verde);

                            if (MinutoDeslig6 != null) {
                                String ak1 = HoraLig6.toString();
                                String ak2 = MinutoLig6.toString();
                                String ak3 = HoraDeslig6.toString();
                                String ak4 = MinutoDeslig6.toString();


                                if (ak1.length() == 1) {
                                    int al = Integer.parseInt(ak1);
                                    hora11 = String.format("%02d", al);
                                }else{
                                    hora11= ak1;

                                }

                                if (ak2.length() == 1) {
                                    int al = Integer.parseInt(ak2);
                                    minuto11 = String.format("%02d", al);

                                }else{
                                    minuto11= ak2;

                                }


                                if (ak3.length() == 1) {
                                    int al = Integer.parseInt(ak3);
                                    hora12 = String.format("%02d", al);

                                }else{
                                    hora12= ak3;

                                }

                                if (ak4.length() == 1) {
                                    int al = Integer.parseInt(ak4);
                                    minuto12 = String.format("%02d", al);

                                } else{
                                    minuto12= ak4;

                                }

                                horaRot2Tom3.setText(hora11+":"+minuto11+" - "+ hora12+ ":" + minuto12);


                            }




                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ////////////////////////////////////////////////////////////////////////

        NomeRot7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nomeRot7 = dataSnapshot.getValue(String.class);



                if (nomeRot7 != null){



                    HoraLigarRot7.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraLig7 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoLigarRot7.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoLig7 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    HoraDesligarRot7.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraDeslig7 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoDesligarRot7.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoDeslig7 = dataSnapshot.getValue(Long.class);


                            //colocar valores nos campos
                            card7.setVisibility(View.VISIBLE);

                            nomeRot1Tom4.setText(nomeRot7);
                            img_tom4rot1.setImageResource(R.drawable.b_icone_alarm_on);
                            card7.setEnabled(true);
                            img_tom4rot1.setBackgroundResource(R.drawable.b_shape_redondo_verde);

                            if (MinutoDeslig7 != null) {
                                String ak1 = HoraLig7.toString();
                                String ak2 = MinutoLig7.toString();
                                String ak3 = HoraDeslig7.toString();
                                String ak4 = MinutoDeslig7.toString();


                                if (ak1.length() == 1) {
                                    int al = Integer.parseInt(ak1);
                                    hora13 = String.format("%02d", al);
                                }else{
                                    hora13= ak1;

                                }

                                if (ak2.length() == 1) {
                                    int al = Integer.parseInt(ak2);
                                    minuto13 = String.format("%02d", al);

                                }else{
                                    minuto13= ak2;

                                }


                                if (ak3.length() == 1) {
                                    int al = Integer.parseInt(ak3);
                                    hora14 = String.format("%02d", al);

                                }else{
                                    hora14= ak3;

                                }

                                if (ak4.length() == 1) {
                                    int al = Integer.parseInt(ak4);
                                    minuto14 = String.format("%02d", al);

                                } else{
                                    minuto14= ak4;

                                }

                                horaRot1Tom4.setText(hora13+":"+minuto13+" - "+ hora14+ ":" + minuto14);


                            }



                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ////////////////////////////////////////////////////////////////////////

        NomeRot8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nomeRot8 = dataSnapshot.getValue(String.class);



                if (nomeRot8 != null){



                    HoraLigarRot8.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraLig8 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoLigarRot8.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoLig8 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    HoraDesligarRot8.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            HoraDeslig8 = dataSnapshot.getValue(Long.class);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    MinutoDesligarRot8.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MinutoDeslig8 = dataSnapshot.getValue(Long.class);


                            //colocar valores nos campos
                            card8.setVisibility(View.VISIBLE);

                            nomeRot2Tom4.setText(nomeRot8);
                            img_tom4rot2.setImageResource(R.drawable.b_icone_alarm_on);
                            card8.setEnabled(true);
                            img_tom4rot2.setBackgroundResource(R.drawable.b_shape_redondo_verde);

                            if (MinutoDeslig8 != null) {
                                String ak1 = HoraLig8.toString();
                                String ak2 = MinutoLig8.toString();
                                String ak3 = HoraDeslig8.toString();
                                String ak4 = MinutoDeslig8.toString();


                                if (ak1.length() == 1) {
                                    int al = Integer.parseInt(ak1);
                                    hora15 = String.format("%02d", al);
                                }else{
                                    hora15= ak1;

                                }

                                if (ak2.length() == 1) {
                                    int al = Integer.parseInt(ak2);
                                    minuto15 = String.format("%02d", al);

                                }else{
                                    minuto15= ak2;

                                }


                                if (ak3.length() == 1) {
                                    int al = Integer.parseInt(ak3);
                                    hora16 = String.format("%02d", al);

                                }else{
                                    hora16= ak3;

                                }

                                if (ak4.length() == 1) {
                                    int al = Integer.parseInt(ak4);
                                    minuto16 = String.format("%02d", al);

                                } else{
                                    minuto16= ak4;

                                }

                                horaRot2Tom4.setText(hora15+":"+minuto15+" - "+ hora16+ ":" + minuto16);


                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ////////////////////////////////////////////////////////////////////////




    }



    private void longClickCards() {

        card1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                deletarRotina1(view);
                return true;
            }
        });

        card2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                deletarRotina2(view);
                return true;
            }
        });
        card3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                deletarRotina3(view);
                return true;
            }
        });
        card4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                deletarRotina4(view);
                return true;
            }
        });
        card5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                deletarRotina5(view);
                return true;
            }
        });
        card6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                deletarRotina6(view);
                return true;
            }
        });
        card7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                deletarRotina7(view);
                return true;
            }
        });
        card8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                deletarRotina8(view);
                return true;
            }
        });

    }

    public void deletarRotina1(View view){

        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.delete);
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                alarmManager1 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent1 = new Intent(getApplicationContext(), ReceiverClass.class);
                tarefaPendingIntent1 = PendingIntent.getBroadcast(getApplicationContext(), 1, tarefaIntent1, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager1.cancel(tarefaPendingIntent1);

                alarmManager2 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent2 = new Intent(getApplicationContext(), ReceiverClass2.class);
                tarefaPendingIntent2 = PendingIntent.getBroadcast(getApplicationContext(), 2, tarefaIntent2, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager2.cancel(tarefaPendingIntent2);

                Log.d("ALARME", "CANCELOOOOU 1");


                //colocar valores nos campos

                horaRot1Tom1.setText("--:-- / --:--");
                nomeRot1Tom1.setText("Clique no '+' para adicionar");
                img_tom1rot1.setImageResource(R.drawable.b_icone_alarm_add);
                card1.setEnabled(false);
                img_tom1rot1.setBackgroundResource(R.drawable.b_shape_redondo_amarelo);

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina1")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar1")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar1")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar1")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar1")
                        .removeValue();


                finish();
                Intent rot = new Intent(getApplicationContext(), b_RotinasActivity.class);
                startActivity(rot);


                return false;
            }
        });

    }

    public void deletarRotina2(View view){

        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.delete);
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                alarmManager3 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent3 = new Intent(getApplicationContext(), ReceiverClass3.class);
                tarefaPendingIntent3 = PendingIntent.getBroadcast(getApplicationContext(), 3, tarefaIntent3, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager3.cancel(tarefaPendingIntent3);

                alarmManager4 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent4 = new Intent(getApplicationContext(), ReceiverClass4.class);
                tarefaPendingIntent4 = PendingIntent.getBroadcast(getApplicationContext(), 4, tarefaIntent4, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager4.cancel(tarefaPendingIntent4);

                Log.d("ALARME", "CANCELOOOOU 2");


                //colocar valores nos campos

                horaRot2Tom1.setText("--:-- / --:--");
                nomeRot2Tom1.setText("Clique no '+' para adicionar");
                img_tom1rot2.setImageResource(R.drawable.b_icone_alarm_add);
                card2.setEnabled(false);
                img_tom1rot2.setBackgroundResource(R.drawable.b_shape_redondo_amarelo);

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina2")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar2")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar2")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar2")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar2")
                        .removeValue();


                finish();
                Intent rot = new Intent(getApplicationContext(), b_RotinasActivity.class);
                startActivity(rot);


                return false;
            }
        });

    }

    public void deletarRotina3(View view){

        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.delete);
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                alarmManager5 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent5 = new Intent(getApplicationContext(), ReceiverClass5.class);
                tarefaPendingIntent5 = PendingIntent.getBroadcast(getApplicationContext(), 5, tarefaIntent5, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager5.cancel(tarefaPendingIntent5);

                alarmManager6 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent6 = new Intent(getApplicationContext(), ReceiverClass6.class);
                tarefaPendingIntent6 = PendingIntent.getBroadcast(getApplicationContext(), 6, tarefaIntent6, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager6.cancel(tarefaPendingIntent6);

                Log.d("ALARME", "CANCELOOOOU 3");


                //colocar valores nos campos

                horaRot1Tom2.setText("--:-- / --:--");
                nomeRot1Tom2.setText("Clique no '+' para adicionar");
                img_tom2rot1.setImageResource(R.drawable.b_icone_alarm_add);
                card3.setEnabled(false);
                img_tom2rot1.setBackgroundResource(R.drawable.b_shape_redondo_amarelo);

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina3")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar3")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar3")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar3")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar3")
                        .removeValue();


                finish();
                Intent rot = new Intent(getApplicationContext(), b_RotinasActivity.class);
                startActivity(rot);


                return false;
            }
        });

    }

    public void deletarRotina4(View view){

        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.delete);
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                alarmManager7 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent7 = new Intent(getApplicationContext(), ReceiverClass7.class);
                tarefaPendingIntent7 = PendingIntent.getBroadcast(getApplicationContext(), 7, tarefaIntent7, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager7.cancel(tarefaPendingIntent7);

                alarmManager8 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent8 = new Intent(getApplicationContext(), ReceiverClass8.class);
                tarefaPendingIntent8 = PendingIntent.getBroadcast(getApplicationContext(), 8, tarefaIntent8, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager8.cancel(tarefaPendingIntent8);

                Log.d("ALARME", "CANCELOOOOU 4");


                //colocar valores nos campos

                horaRot2Tom2.setText("--:-- / --:--");
                nomeRot2Tom2.setText("Clique no '+' para adicionar");
                img_tom2rot2.setImageResource(R.drawable.b_icone_alarm_add);
                card4.setEnabled(false);
                img_tom2rot2.setBackgroundResource(R.drawable.b_shape_redondo_amarelo);

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina4")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar4")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar4")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar4")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar4")
                        .removeValue();


                finish();
                Intent rot = new Intent(getApplicationContext(), b_RotinasActivity.class);
                startActivity(rot);


                return false;
            }
        });

    }

    public void deletarRotina5(View view){

        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.delete);
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                alarmManager9 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent9 = new Intent(getApplicationContext(), ReceiverClass9.class);
                tarefaPendingIntent9 = PendingIntent.getBroadcast(getApplicationContext(), 9, tarefaIntent9, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager9.cancel(tarefaPendingIntent9);

                alarmManager10 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent10 = new Intent(getApplicationContext(), ReceiverClass10.class);
                tarefaPendingIntent10 = PendingIntent.getBroadcast(getApplicationContext(), 10, tarefaIntent10, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager10.cancel(tarefaPendingIntent10);

                Log.d("ALARME", "CANCELOOOOU 5");


                //colocar valores nos campos

                horaRot1Tom3.setText("--:-- / --:--");
                nomeRot1Tom3.setText("Clique no '+' para adicionar");
                img_tom3rot1.setImageResource(R.drawable.b_icone_alarm_add);
                card5.setEnabled(false);
                img_tom3rot1.setBackgroundResource(R.drawable.b_shape_redondo_amarelo);

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina5")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar5")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar5")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar5")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar5")
                        .removeValue();


                finish();
                Intent rot = new Intent(getApplicationContext(), b_RotinasActivity.class);
                startActivity(rot);


                return false;
            }
        });

    }

    public void deletarRotina6(View view){

        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.delete);
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                alarmManager11 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent11 = new Intent(getApplicationContext(), ReceiverClass11.class);
                tarefaPendingIntent11 = PendingIntent.getBroadcast(getApplicationContext(), 11, tarefaIntent11, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager11.cancel(tarefaPendingIntent11);

                alarmManager12 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent12 = new Intent(getApplicationContext(), ReceiverClass12.class);
                tarefaPendingIntent12 = PendingIntent.getBroadcast(getApplicationContext(), 12, tarefaIntent12,PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager12.cancel(tarefaPendingIntent12);

                Log.d("ALARME", "CANCELOOOOU 6");


                //colocar valores nos campos

                horaRot2Tom3.setText("--:-- / --:--");
                nomeRot2Tom3.setText("Clique no '+' para adicionar");
                img_tom3rot2.setImageResource(R.drawable.b_icone_alarm_add);
                card6.setEnabled(false);
                img_tom3rot2.setBackgroundResource(R.drawable.b_shape_redondo_amarelo);

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina6")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar6")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar6")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar6")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar6")
                        .removeValue();


                finish();
                Intent rot = new Intent(getApplicationContext(), b_RotinasActivity.class);
                startActivity(rot);


                return false;
            }
        });

    }

    public void deletarRotina7(View view){

        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.delete);
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                alarmManager13 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent13 = new Intent(getApplicationContext(), ReceiverClass13.class);
                tarefaPendingIntent13 = PendingIntent.getBroadcast(getApplicationContext(), 13, tarefaIntent13, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager13.cancel(tarefaPendingIntent13);

                alarmManager14 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent14 = new Intent(getApplicationContext(), ReceiverClass14.class);
                tarefaPendingIntent14 = PendingIntent.getBroadcast(getApplicationContext(), 14, tarefaIntent14,  PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager14.cancel(tarefaPendingIntent14);

                Log.d("ALARME", "CANCELOOOOU 7");


                //colocar valores nos campos

                horaRot1Tom4.setText("--:-- / --:--");
                nomeRot1Tom4.setText("Clique no '+' para adicionar");
                img_tom4rot1.setImageResource(R.drawable.b_icone_alarm_add);
                card7.setEnabled(false);
                img_tom4rot1.setBackgroundResource(R.drawable.b_shape_redondo_amarelo);

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina7")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar7")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar7")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar7")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar7")
                        .removeValue();


                finish();
                Intent rot = new Intent(getApplicationContext(), b_RotinasActivity.class);
                startActivity(rot);


                return false;
            }
        });

    }

    public void deletarRotina8(View view){

        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.delete);
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                alarmManager15 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent15 = new Intent(getApplicationContext(), ReceiverClass15.class);
                tarefaPendingIntent15 = PendingIntent.getBroadcast(getApplicationContext(), 15, tarefaIntent15, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager15.cancel(tarefaPendingIntent15);

                alarmManager16 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                tarefaIntent16 = new Intent(getApplicationContext(), ReceiverClass16.class);
                tarefaPendingIntent16 = PendingIntent.getBroadcast(getApplicationContext(), 16, tarefaIntent16, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager16.cancel(tarefaPendingIntent16);

                Log.d("ALARME", "CANCELOOOOU 8");


                //colocar valores nos campos

                horaRot2Tom4.setText("--:-- / --:--");
                nomeRot2Tom4.setText("Clique no '+' para adicionar");
                img_tom4rot2.setImageResource(R.drawable.b_icone_alarm_add);
                card8.setEnabled(false);
                img_tom4rot2.setBackgroundResource(R.drawable.b_shape_redondo_amarelo);

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina8")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar8")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar8")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar8")
                        .removeValue();

                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar8")
                        .removeValue();


                finish();
                Intent rot = new Intent(getApplicationContext(), b_RotinasActivity.class);
                startActivity(rot);


                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent home = new Intent(getApplicationContext(), a_HomeActivity.class);
            startActivity(home);
            finish();
        }

        if (item.getItemId() == R.id.add) {
            ShowPopupAddRotina();
        }
        return super.onOptionsItemSelected(item);
    }

    public void verificarSehaTomadas(){
        DatabaseReference tomada1 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada1");
        DatabaseReference tomada2 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada2");
        DatabaseReference tomada3 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada3");
        DatabaseReference tomada4 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada4");

        tomada1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tomadaa1 = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        tomada2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tomadaa2 = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        tomada3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tomadaa3 = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        tomada4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tomadaa4 = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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


    public void ShowPopupAddRotina() {


        myDialog4.setContentView(R.layout.janela_custom_popup_add_rotina);
        myDialog4.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog4.show();

        verificarSehaTomadas();

        String tomadasArray[] = new String[]{"Tomada 1", "Tomada 2", "Tomada 3", "Tomada 4"};


        //spinner
        spinner1 = myDialog4.findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, tomadasArray);

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner1.setAdapter(adapter);
        //////////////////////////////

        txclose = myDialog4.findViewById(R.id.close);
        txclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog4.dismiss();
            }
        });

        btnAddHoraLigar = myDialog4.findViewById(R.id.btn_addRotina);
        btnAddHoraLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                spinner2 = myDialog4.findViewById(R.id.spinner1);

                String item = spinner2.getSelectedItem().toString();

                txtNomeRot1Tom1 = nomeRot1Tom1.getText().toString().trim();
                txtNomeRot2Tom1 = nomeRot2Tom1.getText().toString().trim();
                txtNomeRot1Tom2 = nomeRot1Tom2.getText().toString().trim();
                txtNomeRot2Tom2 = nomeRot2Tom2.getText().toString().trim();
                txtNomeRot1Tom3 = nomeRot1Tom3.getText().toString().trim();
                txtNomeRot2Tom3 = nomeRot2Tom3.getText().toString().trim();
                txtNomeRot1Tom4 = nomeRot1Tom4.getText().toString().trim();
                txtNomeRot2Tom4 = nomeRot2Tom4.getText().toString().trim();

                edtNome = myDialog4.findViewById(R.id.edt_nomeRotina);

                editHora = myDialog4.findViewById(R.id.editHoraUm);
                editMinuto = myDialog4.findViewById(R.id.editMinutoUm);
                editHoraDois = myDialog4.findViewById(R.id.editHoraDois);
                editMinutoDois = myDialog4.findViewById(R.id.editMinutoDois);

                edtNome1 = edtNome.getText().toString().trim();

                editHora1 = editHora.getText().toString().trim();
                editMinuto1 = editMinuto.getText().toString().trim();

                editHora2 = editHoraDois.getText().toString().trim();
                editMinuto2 = editMinutoDois.getText().toString().trim();


                if (item == "Tomada 1") {

                    if (tomadaa1 != null){

                        if (txtNomeRot1Tom1.equals("Clique no '+' para adicionar")) {


                            if (!validarEntradas(edtNome, editHora, editMinuto, editHoraDois, editMinutoDois)) {

                            } else {

                                Log.d("ALARME", "AGENDOOOOOOOU LIGAR E DESLIGAR 1");

                                int editHora11 = Integer.parseInt(editHora1);
                                int editMinuto11 = Integer.parseInt(editMinuto1);
                                int editHora22 = Integer.parseInt(editHora2);
                                int editMinuto22 = Integer.parseInt(editMinuto2);


                                //Definir a hora de início
                                calendar1 = Calendar.getInstance();
                                Calendar now1 = Calendar.getInstance();

                                calendar1.set(Calendar.HOUR_OF_DAY, editHora11);
                                calendar1.set(Calendar.MINUTE, editMinuto11);
                                calendar1.set(Calendar.SECOND, 0);

                                //Definir a hora de fim
                                calendar2 = Calendar.getInstance();
                                Calendar now2 = Calendar.getInstance();

                                calendar2.set(Calendar.HOUR_OF_DAY, editHora22);
                                calendar2.set(Calendar.MINUTE, editMinuto22);
                                calendar2.set(Calendar.SECOND, 0);

                                //colocar valores nos campos
                                card1.setVisibility(View.VISIBLE);

                                nomeRot1Tom1.setText(edtNome1);
                                img_tom1rot1.setImageResource(R.drawable.b_icone_alarm_on);
                                card1.setEnabled(true);

//


                                // O id a ser usado no pending intent
                                int id1 = (int) System.currentTimeMillis();
                                int id2 = (int) System.currentTimeMillis();

                                //ALARME PARA LIGAR
                                alarmManager1 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                                tarefaIntent1 = new Intent(getApplicationContext(), ReceiverClass.class);

                                String a1 = currentUser.getUid();

                                tarefaIntent1.putExtra("id",a1);
                                tarefaIntent1.putExtra("ip",iphub);


                                long milisegundos_alarme = 0;

                                if (calendar1.getTimeInMillis() <= now1.getTimeInMillis())
                                    milisegundos_alarme = calendar1.getTimeInMillis() + (AlarmManager.INTERVAL_DAY + 1);
                                else
                                    milisegundos_alarme = calendar1.getTimeInMillis();

                                tarefaPendingIntent1 = PendingIntent.getBroadcast(getApplicationContext(), id1, tarefaIntent1, PendingIntent.FLAG_UPDATE_CURRENT);
                                alarmManager1.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme, AlarmManager.INTERVAL_DAY, tarefaPendingIntent1);


                                //ALARME PARA DESLIGAR
                                alarmManager2 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                                tarefaIntent2 = new Intent(getApplicationContext(), ReceiverClass2.class);

                                String a2 = currentUser.getUid();

                                tarefaIntent2.putExtra("id",a2);
                                tarefaIntent2.putExtra("ip",iphub);

                                long milisegundos_alarme2 = 0;

                                if (calendar2.getTimeInMillis() <= now2.getTimeInMillis())
                                    milisegundos_alarme2 = calendar2.getTimeInMillis() + (AlarmManager.INTERVAL_DAY + 1);
                                else
                                    milisegundos_alarme2 = calendar2.getTimeInMillis();

                                tarefaPendingIntent2 = PendingIntent.getBroadcast(getApplicationContext(), id2, tarefaIntent2, PendingIntent.FLAG_UPDATE_CURRENT);
                                alarmManager2.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme2, AlarmManager.INTERVAL_DAY, tarefaPendingIntent2);

                                //seta os valores dos campos no Banco de dados

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina1")
                                        .setValue(edtNome1);

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar1")
                                        .setValue(editHora11);

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar1")
                                        .setValue(editMinuto11);

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar1")
                                        .setValue(editHora22);

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar1")
                                        .setValue(editMinuto22);

                                myDialog4.dismiss();

                                return;
                            }
                        }

                        else if (txtNomeRot2Tom1.equals("Clique no '+' para adicionar")) {


                            if (!validarEntradas(edtNome, editHora, editMinuto, editHoraDois, editMinutoDois)) {

                            } else {

                                Log.d("ALARME", "AGENDOOOOOOOU LIGAR E DESLIGAR 2");

                                int editHora11 = Integer.parseInt(editHora1);
                                int editMinuto11 = Integer.parseInt(editMinuto1);
                                int editHora22 = Integer.parseInt(editHora2);
                                int editMinuto22 = Integer.parseInt(editMinuto2);


                                //Definir a hora de início
                                calendar3 = Calendar.getInstance();
                                Calendar now3 = Calendar.getInstance();

                                calendar3.set(Calendar.HOUR_OF_DAY, editHora11);
                                calendar3.set(Calendar.MINUTE, editMinuto11);
                                calendar3.set(Calendar.SECOND, 0);

                                //Definir a hora de fim
                                calendar4 = Calendar.getInstance();
                                Calendar now4 = Calendar.getInstance();

                                calendar4.set(Calendar.HOUR_OF_DAY, editHora22);
                                calendar4.set(Calendar.MINUTE, editMinuto22);
                                calendar4.set(Calendar.SECOND, 0);

                                //colocar valores nos campos
                                card2.setVisibility(View.VISIBLE);
                                horaRot2Tom1.setText(editHora1 + ":" + editMinuto1 + " - " + editHora2 + ":" + editMinuto2);
                                nomeRot2Tom1.setText(edtNome1);
                                img_tom1rot2.setImageResource(R.drawable.b_icone_alarm_on);
                                card2.setEnabled(true);

                                // O id a ser usado no pending intent
                                int id3 = (int) System.currentTimeMillis();
                                int id4 = (int) System.currentTimeMillis();


                                //ALARME PARA LIGAR
                                alarmManager3 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                                tarefaIntent3 = new Intent(getApplicationContext(), ReceiverClass3.class);

                                String a3 = currentUser.getUid();

                                tarefaIntent3.putExtra("id",a3);
                                tarefaIntent3.putExtra("ip",iphub);

                                long milisegundos_alarme3 = 0;

                                if (calendar3.getTimeInMillis() <= now3.getTimeInMillis())
                                    milisegundos_alarme3 = calendar3.getTimeInMillis() + (AlarmManager.INTERVAL_DAY + 1);
                                else
                                    milisegundos_alarme3 = calendar3.getTimeInMillis();

                                tarefaPendingIntent3 = PendingIntent.getBroadcast(getApplicationContext(), id3, tarefaIntent3, PendingIntent.FLAG_UPDATE_CURRENT);
                                alarmManager3.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme3, AlarmManager.INTERVAL_DAY, tarefaPendingIntent3);


                                //ALARME PARA DESLIGAR
                                alarmManager4 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                                tarefaIntent4 = new Intent(getApplicationContext(), ReceiverClass4.class);

                                String a4 = currentUser.getUid();

                                tarefaIntent4.putExtra("id",a4);
                                tarefaIntent4.putExtra("ip",iphub);

                                long milisegundos_alarme4 = 0;

                                if (calendar4.getTimeInMillis() <= now4.getTimeInMillis())
                                    milisegundos_alarme4 = calendar4.getTimeInMillis() + (AlarmManager.INTERVAL_DAY + 1);
                                else
                                    milisegundos_alarme4 = calendar4.getTimeInMillis();

                                tarefaPendingIntent4 = PendingIntent.getBroadcast(getApplicationContext(), id4, tarefaIntent4, PendingIntent.FLAG_UPDATE_CURRENT);
                                alarmManager4.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme4, AlarmManager.INTERVAL_DAY, tarefaPendingIntent4);

                                //seta os valores dos campos no Banco de dados

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina2")
                                        .setValue(edtNome1);

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar2")
                                        .setValue(editHora11);

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar2")
                                        .setValue(editMinuto11);

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar2")
                                        .setValue(editHora22);

                                FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar2")
                                        .setValue(editMinuto22);


                                myDialog4.dismiss();
                                return;
                            }
                        }

                    if ((!txtNomeRot2Tom1.equals("Clique no '+' para adicionar")) || (!txtNomeRot1Tom1.equals("Clique no '+' para adicionar"))) {
                        Toast.makeText(getApplicationContext(), "Limite de rotinas da tomada atingida! Exclua uma para adicionar.", Toast.LENGTH_SHORT).show();
                    }

                } else{
                        Toast.makeText(getApplicationContext(), "Adicione esta tomada no HUB para criar uma rotina!", Toast.LENGTH_SHORT).show();
                    }
                }

                ///////////////////////////////////////////////////

                if (item == "Tomada 2") {

                    if (tomadaa2 != null){

                    if (txtNomeRot1Tom2.equals("Clique no '+' para adicionar")) {


                        if (!validarEntradas(edtNome,editHora, editMinuto, editHoraDois, editMinutoDois)) {

                        } else {

                            Log.d("ALARME", "AGENDOOOOOOOU LIGAR E DESLIGAR 3");

                            int editHora11 = Integer.parseInt(editHora1);
                            int editMinuto11 = Integer.parseInt(editMinuto1);
                            int editHora22 = Integer.parseInt(editHora2);
                            int editMinuto22 = Integer.parseInt(editMinuto2);


                            //Definir a hora de início
                            calendar5 = Calendar.getInstance();
                            Calendar now5 =Calendar.getInstance();

                            calendar5.set(Calendar.HOUR_OF_DAY, editHora11);
                            calendar5.set(Calendar.MINUTE, editMinuto11);
                            calendar5.set(Calendar.SECOND, 0);

                            //Definir a hora de fim
                            calendar6 = Calendar.getInstance();
                            Calendar now6 =Calendar.getInstance();

                            calendar6.set(Calendar.HOUR_OF_DAY, editHora22);
                            calendar6.set(Calendar.MINUTE, editMinuto22);
                            calendar6.set(Calendar.SECOND, 0);

                            //colocar valores nos campos
                            card3.setVisibility(View.VISIBLE);
                            horaRot1Tom2.setText(editHora1 + ":" + editMinuto1 + " - " + editHora2 + ":" + editMinuto2);
                            nomeRot1Tom2.setText(edtNome1);
                            img_tom2rot1.setImageResource(R.drawable.b_icone_alarm_on);
                            card3.setEnabled(true);

                            // O id a ser usado no pending intent
                            int id5 = (int) System.currentTimeMillis();
                            int id6 = (int) System.currentTimeMillis();

                            //ALARME PARA LIGAR
                            alarmManager5 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                            tarefaIntent5 = new Intent(getApplicationContext(), ReceiverClass5.class);

                            String a5 = currentUser.getUid();

                            tarefaIntent5.putExtra("id",a5);
                            tarefaIntent5.putExtra("ip",iphub);

                            long milisegundos_alarme5 = 0;

                            if(calendar5.getTimeInMillis() <= now5.getTimeInMillis())
                                milisegundos_alarme5 = calendar5.getTimeInMillis() + (AlarmManager.INTERVAL_DAY+1);
                            else
                                milisegundos_alarme5 = calendar5.getTimeInMillis();

                            tarefaPendingIntent5 = PendingIntent.getBroadcast(getApplicationContext(), id5, tarefaIntent5, PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmManager5.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme5, AlarmManager.INTERVAL_DAY, tarefaPendingIntent5);


                            //ALARME PARA DESLIGAR
                            alarmManager6 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                            tarefaIntent6 = new Intent(getApplicationContext(), ReceiverClass6.class);

                            String a6 = currentUser.getUid();

                            tarefaIntent6.putExtra("id",a6);
                            tarefaIntent6.putExtra("ip",iphub);

                            long milisegundos_alarme6 = 0;

                            if(calendar6.getTimeInMillis() <= now6.getTimeInMillis())
                                milisegundos_alarme6 = calendar6.getTimeInMillis() + (AlarmManager.INTERVAL_DAY+1);
                            else
                                milisegundos_alarme6 = calendar6.getTimeInMillis();

                            tarefaPendingIntent6 = PendingIntent.getBroadcast(getApplicationContext(), id6, tarefaIntent6, PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmManager6.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme6, AlarmManager.INTERVAL_DAY, tarefaPendingIntent6);

                            //seta os valores dos campos no Banco de dados

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina3")
                                    .setValue(edtNome1);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar3")
                                    .setValue(editHora11);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar3")
                                    .setValue(editMinuto11);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar3")
                                    .setValue(editHora22);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar3")
                                    .setValue(editMinuto22);

                            myDialog4.dismiss();

                            return;
                        }
                    }

                    else if (txtNomeRot2Tom2.equals("Clique no '+' para adicionar")) {


                        if (!validarEntradas(edtNome,editHora, editMinuto, editHoraDois, editMinutoDois)) {

                        } else {

                            Log.d("ALARME", "AGENDOOOOOOOU LIGAR E DESLIGAR 4");

                            int editHora11 = Integer.parseInt(editHora1);
                            int editMinuto11 = Integer.parseInt(editMinuto1);
                            int editHora22 = Integer.parseInt(editHora2);
                            int editMinuto22 = Integer.parseInt(editMinuto2);


                            //Definir a hora de início
                            calendar7 = Calendar.getInstance();
                            Calendar now7 =Calendar.getInstance();

                            calendar7.set(Calendar.HOUR_OF_DAY, editHora11);
                            calendar7.set(Calendar.MINUTE, editMinuto11);
                            calendar7.set(Calendar.SECOND, 0);

                            //Definir a hora de fim
                            calendar8 = Calendar.getInstance();
                            Calendar now8 =Calendar.getInstance();

                            calendar8.set(Calendar.HOUR_OF_DAY, editHora22);
                            calendar8.set(Calendar.MINUTE, editMinuto22);
                            calendar8.set(Calendar.SECOND, 0);

                            //colocar valores nos campos
                            card4.setVisibility(View.VISIBLE);
                            horaRot2Tom2.setText(editHora1 + ":" + editMinuto1 + " - " + editHora2 + ":" + editMinuto2);
                            nomeRot2Tom2.setText(edtNome1);
                            img_tom2rot2.setImageResource(R.drawable.b_icone_alarm_on);
                            card4.setEnabled(true);

                            // O id a ser usado no pending intent
                            int id7 = (int) System.currentTimeMillis();
                            int id8 = (int) System.currentTimeMillis();


                            //ALARME PARA LIGAR
                            alarmManager7 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                            tarefaIntent7 = new Intent(getApplicationContext(), ReceiverClass7.class);

                            String a7 = currentUser.getUid();

                            tarefaIntent7.putExtra("id",a7);
                            tarefaIntent7.putExtra("ip",iphub);

                            long milisegundos_alarme7 = 0;

                            if(calendar7.getTimeInMillis() <= now7.getTimeInMillis())
                                milisegundos_alarme7 = calendar7.getTimeInMillis() + (AlarmManager.INTERVAL_DAY+1);
                            else
                                milisegundos_alarme7 = calendar7.getTimeInMillis();

                            tarefaPendingIntent7 = PendingIntent.getBroadcast(getApplicationContext(), id7, tarefaIntent7,PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmManager7.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme7, AlarmManager.INTERVAL_DAY, tarefaPendingIntent7);


                            //ALARME PARA DESLIGAR
                            alarmManager8 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                            tarefaIntent8 = new Intent(getApplicationContext(), ReceiverClass8.class);

                            String a8 = currentUser.getUid();

                            tarefaIntent8.putExtra("id",a8);
                            tarefaIntent8.putExtra("ip",iphub);

                            long milisegundos_alarme8 = 0;

                            if(calendar8.getTimeInMillis() <= now8.getTimeInMillis())
                                milisegundos_alarme8 = calendar8.getTimeInMillis() + (AlarmManager.INTERVAL_DAY+1);
                            else
                                milisegundos_alarme8 = calendar8.getTimeInMillis();

                            tarefaPendingIntent8 = PendingIntent.getBroadcast(getApplicationContext(), id8, tarefaIntent8, PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmManager8.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme8, AlarmManager.INTERVAL_DAY, tarefaPendingIntent8);

                            //seta os valores dos campos no Banco de dados

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina4")
                                    .setValue(edtNome1);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar4")
                                    .setValue(editHora11);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar4")
                                    .setValue(editMinuto11);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar4")
                                    .setValue(editHora22);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar4")
                                    .setValue(editMinuto22);


                            myDialog4.dismiss();
                            return;
                        }
                    }


                    if ((!txtNomeRot2Tom2.equals("Clique no '+' para adicionar")) || (!txtNomeRot1Tom2.equals("Clique no '+' para adicionar"))) {
                        Toast.makeText(getApplicationContext(),"Limite de rotinas da tomada atingida! Exclua uma para adicionar.",Toast.LENGTH_SHORT).show();
                    }

                } else{
                    Toast.makeText(getApplicationContext(), "Adicione esta tomada no HUB para criar uma rotina!", Toast.LENGTH_SHORT).show();
                }

                }

                ///////////////////////////////////////////////////

                if (item == "Tomada 3") {

                    if (tomadaa3 != null){

                    if (txtNomeRot1Tom3.equals("Clique no '+' para adicionar")) {


                        if (!validarEntradas(edtNome,editHora, editMinuto, editHoraDois, editMinutoDois)) {

                        } else {

                            Log.d("ALARME", "AGENDOOOOOOOU LIGAR E DESLIGAR 5");

                            int editHora11 = Integer.parseInt(editHora1);
                            int editMinuto11 = Integer.parseInt(editMinuto1);
                            int editHora22 = Integer.parseInt(editHora2);
                            int editMinuto22 = Integer.parseInt(editMinuto2);


                            //Definir a hora de início
                            calendar9 = Calendar.getInstance();
                            Calendar now9 =Calendar.getInstance();

                            calendar9.set(Calendar.HOUR_OF_DAY, editHora11);
                            calendar9.set(Calendar.MINUTE, editMinuto11);
                            calendar9.set(Calendar.SECOND, 0);

                            //Definir a hora de fim
                            calendar10 = Calendar.getInstance();
                            Calendar now10 =Calendar.getInstance();

                            calendar10.set(Calendar.HOUR_OF_DAY, editHora22);
                            calendar10.set(Calendar.MINUTE, editMinuto22);
                            calendar10.set(Calendar.SECOND, 0);

                            //colocar valores nos campos
                            card5.setVisibility(View.VISIBLE);
                            horaRot1Tom3.setText(editHora1 + ":" + editMinuto1 + " - " + editHora2 + ":" + editMinuto2);
                            nomeRot1Tom3.setText(edtNome1);
                            img_tom3rot1.setImageResource(R.drawable.b_icone_alarm_on);
                            card5.setEnabled(true);

                            // O id a ser usado no pending intent
                            int id9 = (int) System.currentTimeMillis();
                            int id10 = (int) System.currentTimeMillis();

                            //ALARME PARA LIGAR
                            alarmManager9 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                            tarefaIntent9 = new Intent(getApplicationContext(), ReceiverClass9.class);

                            String a9 = currentUser.getUid();

                            tarefaIntent9.putExtra("id",a9);
                            tarefaIntent9.putExtra("ip",iphub);

                            long milisegundos_alarme9 = 0;

                            if(calendar9.getTimeInMillis() <= now9.getTimeInMillis())
                                milisegundos_alarme9 = calendar9.getTimeInMillis() + (AlarmManager.INTERVAL_DAY+1);
                            else
                                milisegundos_alarme9 = calendar9.getTimeInMillis();

                            tarefaPendingIntent9 = PendingIntent.getBroadcast(getApplicationContext(), id9, tarefaIntent9, PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmManager9.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme9, AlarmManager.INTERVAL_DAY, tarefaPendingIntent9);


                            //ALARME PARA DESLIGAR
                            alarmManager10 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                            tarefaIntent10 = new Intent(getApplicationContext(), ReceiverClass10.class);

                            String a10 = currentUser.getUid();

                            tarefaIntent10.putExtra("id",a10);
                            tarefaIntent10.putExtra("ip",iphub);

                            long milisegundos_alarme10 = 0;

                            if(calendar10.getTimeInMillis() <= now10.getTimeInMillis())
                                milisegundos_alarme10 = calendar10.getTimeInMillis() + (AlarmManager.INTERVAL_DAY+1);
                            else
                                milisegundos_alarme10 = calendar10.getTimeInMillis();

                            tarefaPendingIntent10 = PendingIntent.getBroadcast(getApplicationContext(), id10, tarefaIntent10, PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmManager10.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme10, AlarmManager.INTERVAL_DAY, tarefaPendingIntent10);

                            //seta os valores dos campos no Banco de dados

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina5")
                                    .setValue(edtNome1);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar5")
                                    .setValue(editHora11);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar5")
                                    .setValue(editMinuto11);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar5")
                                    .setValue(editHora22);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar5")
                                    .setValue(editMinuto22);

                            myDialog4.dismiss();

                            return;
                        }
                    }

                    else if (txtNomeRot2Tom3.equals("Clique no '+' para adicionar")) {


                        if (!validarEntradas(edtNome,editHora, editMinuto, editHoraDois, editMinutoDois)) {

                        } else {

                            Log.d("ALARME", "AGENDOOOOOOOU LIGAR E DESLIGAR 6");

                            int editHora11 = Integer.parseInt(editHora1);
                            int editMinuto11 = Integer.parseInt(editMinuto1);
                            int editHora22 = Integer.parseInt(editHora2);
                            int editMinuto22 = Integer.parseInt(editMinuto2);


                            //Definir a hora de início
                            calendar11 = Calendar.getInstance();
                            Calendar now11 =Calendar.getInstance();

                            calendar11.set(Calendar.HOUR_OF_DAY, editHora11);
                            calendar11.set(Calendar.MINUTE, editMinuto11);
                            calendar11.set(Calendar.SECOND, 0);

                            //Definir a hora de fim
                            calendar12 = Calendar.getInstance();
                            Calendar now12 =Calendar.getInstance();

                            calendar12.set(Calendar.HOUR_OF_DAY, editHora22);
                            calendar12.set(Calendar.MINUTE, editMinuto22);
                            calendar12.set(Calendar.SECOND, 0);

                            //colocar valores nos campos
                            card6.setVisibility(View.VISIBLE);
                            horaRot2Tom3.setText(editHora1 + ":" + editMinuto1 + " - " + editHora2 + ":" + editMinuto2);
                            nomeRot2Tom3.setText(edtNome1);
                            img_tom3rot2.setImageResource(R.drawable.b_icone_alarm_on);
                            card6.setEnabled(true);

                            // O id a ser usado no pending intent
                            int id11 = (int) System.currentTimeMillis();
                            int id12 = (int) System.currentTimeMillis();


                            //ALARME PARA LIGAR
                            alarmManager11 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                            tarefaIntent11 = new Intent(getApplicationContext(), ReceiverClass11.class);

                            String a11 = currentUser.getUid();

                            tarefaIntent11.putExtra("id",a11);
                            tarefaIntent11.putExtra("ip",iphub);

                            long milisegundos_alarme11 = 0;

                            if(calendar11.getTimeInMillis() <= now11.getTimeInMillis())
                                milisegundos_alarme11 = calendar11.getTimeInMillis() + (AlarmManager.INTERVAL_DAY+1);
                            else
                                milisegundos_alarme11 = calendar11.getTimeInMillis();

                            tarefaPendingIntent11 = PendingIntent.getBroadcast(getApplicationContext(), id11, tarefaIntent11, PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmManager11.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme11, AlarmManager.INTERVAL_DAY, tarefaPendingIntent11);


                            //ALARME PARA DESLIGAR
                            alarmManager12 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                            tarefaIntent12 = new Intent(getApplicationContext(), ReceiverClass12.class);

                            String a12 = currentUser.getUid();

                            tarefaIntent12.putExtra("id",a12);
                            tarefaIntent12.putExtra("ip",iphub);

                            long milisegundos_alarme12 = 0;

                            if(calendar12.getTimeInMillis() <= now12.getTimeInMillis())
                                milisegundos_alarme12 = calendar12.getTimeInMillis() + (AlarmManager.INTERVAL_DAY+1);
                            else
                                milisegundos_alarme12 = calendar12.getTimeInMillis();

                            tarefaPendingIntent12 = PendingIntent.getBroadcast(getApplicationContext(), id12, tarefaIntent12, PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmManager12.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme12, AlarmManager.INTERVAL_DAY, tarefaPendingIntent12);

                            //seta os valores dos campos no Banco de dados

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina6")
                                    .setValue(edtNome1);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar6")
                                    .setValue(editHora11);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar6")
                                    .setValue(editMinuto11);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar6")
                                    .setValue(editHora22);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar6")
                                    .setValue(editMinuto22);


                            myDialog4.dismiss();
                            return;
                        }
                    }

                    if ((!txtNomeRot2Tom3.equals("Clique no '+' para adicionar")) || (!txtNomeRot1Tom3.equals("Clique no '+' para adicionar"))) {
                        Toast.makeText(getApplicationContext(),"Limite de rotinas da tomada atingida! Exclua uma para adicionar.",Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(getApplicationContext(), "Adicione esta tomada no HUB para criar uma rotina!", Toast.LENGTH_SHORT).show();
                }

                }

                ///////////////////////////////////////////////////

                if (item == "Tomada 4") {

                    if (tomadaa4 != null){

                    if (txtNomeRot1Tom4.equals("Clique no '+' para adicionar")) {


                        if (!validarEntradas(edtNome,editHora, editMinuto, editHoraDois, editMinutoDois)) {

                        } else {

                            Log.d("ALARME", "AGENDOOOOOOOU LIGAR E DESLIGAR 7");

                            int editHora11 = Integer.parseInt(editHora1);
                            int editMinuto11 = Integer.parseInt(editMinuto1);
                            int editHora22 = Integer.parseInt(editHora2);
                            int editMinuto22 = Integer.parseInt(editMinuto2);


                            //Definir a hora de início
                            calendar13 = Calendar.getInstance();
                            Calendar now13 =Calendar.getInstance();

                            calendar13.set(Calendar.HOUR_OF_DAY, editHora11);
                            calendar13.set(Calendar.MINUTE, editMinuto11);
                            calendar13.set(Calendar.SECOND, 0);

                            //Definir a hora de fim
                            calendar14 = Calendar.getInstance();
                            Calendar now14 =Calendar.getInstance();

                            calendar14.set(Calendar.HOUR_OF_DAY, editHora22);
                            calendar14.set(Calendar.MINUTE, editMinuto22);
                            calendar14.set(Calendar.SECOND, 0);

                            //colocar valores nos campos
                            card7.setVisibility(View.VISIBLE);
                            horaRot1Tom4.setText(editHora1 + ":" + editMinuto1 + " - " + editHora2 + ":" + editMinuto2);
                            nomeRot1Tom4.setText(edtNome1);
                            img_tom4rot1.setImageResource(R.drawable.b_icone_alarm_on);
                            card7.setEnabled(true);

                            // O id a ser usado no pending intent
                            int id13 = (int) System.currentTimeMillis();
                            int id14 = (int) System.currentTimeMillis();

                            //ALARME PARA LIGAR
                            alarmManager13 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                            tarefaIntent13 = new Intent(getApplicationContext(), ReceiverClass13.class);

                            String a13 = currentUser.getUid();

                            tarefaIntent13.putExtra("id",a13);
                            tarefaIntent13.putExtra("ip",iphub);

                            long milisegundos_alarme13 = 0;

                            if(calendar13.getTimeInMillis() <= now13.getTimeInMillis())
                                milisegundos_alarme13 = calendar13.getTimeInMillis() + (AlarmManager.INTERVAL_DAY+1);
                            else
                                milisegundos_alarme13 = calendar13.getTimeInMillis();

                            tarefaPendingIntent13 = PendingIntent.getBroadcast(getApplicationContext(), id13, tarefaIntent13, PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmManager13.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme13, AlarmManager.INTERVAL_DAY, tarefaPendingIntent13);


                            //ALARME PARA DESLIGAR
                            alarmManager14 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                            tarefaIntent14 = new Intent(getApplicationContext(), ReceiverClass14.class);

                            String a14 = currentUser.getUid();

                            tarefaIntent14.putExtra("id",a14);
                            tarefaIntent14.putExtra("ip",iphub);

                            long milisegundos_alarme14 = 0;

                            if(calendar14.getTimeInMillis() <= now14.getTimeInMillis())
                                milisegundos_alarme14 = calendar14.getTimeInMillis() + (AlarmManager.INTERVAL_DAY+1);
                            else
                                milisegundos_alarme14 = calendar14.getTimeInMillis();

                            tarefaPendingIntent14 = PendingIntent.getBroadcast(getApplicationContext(), id14, tarefaIntent14, PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmManager14.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme14, AlarmManager.INTERVAL_DAY, tarefaPendingIntent14);

                            //seta os valores dos campos no Banco de dados

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina7")
                                    .setValue(edtNome1);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar7")
                                    .setValue(editHora11);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar7")
                                    .setValue(editMinuto11);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar7")
                                    .setValue(editHora22);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar7")
                                    .setValue(editMinuto22);

                            myDialog4.dismiss();

                            return;
                        }
                    }

                    else if (txtNomeRot2Tom4.equals("Clique no '+' para adicionar")) {


                        if (!validarEntradas(edtNome,editHora, editMinuto, editHoraDois, editMinutoDois)) {

                        } else {

                            Log.d("ALARME", "AGENDOOOOOOOU LIGAR E DESLIGAR 8");

                            int editHora11 = Integer.parseInt(editHora1);
                            int editMinuto11 = Integer.parseInt(editMinuto1);
                            int editHora22 = Integer.parseInt(editHora2);
                            int editMinuto22 = Integer.parseInt(editMinuto2);


                            //Definir a hora de início
                            calendar15 = Calendar.getInstance();
                            Calendar now15 =Calendar.getInstance();

                            calendar15.set(Calendar.HOUR_OF_DAY, editHora11);
                            calendar15.set(Calendar.MINUTE, editMinuto11);
                            calendar15.set(Calendar.SECOND, 0);

                            //Definir a hora de fim
                            calendar16 = Calendar.getInstance();
                            Calendar now16 =Calendar.getInstance();

                            calendar16.set(Calendar.HOUR_OF_DAY, editHora22);
                            calendar16.set(Calendar.MINUTE, editMinuto22);
                            calendar16.set(Calendar.SECOND, 0);

                            //colocar valores nos campos
                            card8.setVisibility(View.VISIBLE);
                            horaRot2Tom4.setText(editHora1 + ":" + editMinuto1 + " - " + editHora2 + ":" + editMinuto2);
                            nomeRot2Tom4.setText(edtNome1);
                            img_tom4rot2.setImageResource(R.drawable.b_icone_alarm_on);
                            card8.setEnabled(true);

                            // O id a ser usado no pending intent
                            int id15 = (int) System.currentTimeMillis();
                            int id16 = (int) System.currentTimeMillis();


                            //ALARME PARA LIGAR
                            alarmManager15 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                            tarefaIntent15 = new Intent(getApplicationContext(), ReceiverClass15.class);

                            String a15 = currentUser.getUid();

                            tarefaIntent15.putExtra("id",a15);
                            tarefaIntent15.putExtra("ip",iphub);

                            long milisegundos_alarme15 = 0;

                            if(calendar15.getTimeInMillis() <= now15.getTimeInMillis())
                                milisegundos_alarme15 = calendar15.getTimeInMillis() + (AlarmManager.INTERVAL_DAY+1);
                            else
                                milisegundos_alarme15 = calendar15.getTimeInMillis();

                            tarefaPendingIntent15 = PendingIntent.getBroadcast(getApplicationContext(), id15, tarefaIntent15, PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmManager15.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme15, AlarmManager.INTERVAL_DAY, tarefaPendingIntent15);


                            //ALARME PARA DESLIGAR
                            alarmManager16 = (AlarmManager) getApplicationContext().getSystemService(getApplicationContext().ALARM_SERVICE);
                            tarefaIntent16 = new Intent(getApplicationContext(), ReceiverClass16.class);

                            String a16 = currentUser.getUid();

                            tarefaIntent16.putExtra("id",a16);
                            tarefaIntent16.putExtra("ip",iphub);

                            long milisegundos_alarme16 = 0;

                            if(calendar16.getTimeInMillis() <= now16.getTimeInMillis())
                                milisegundos_alarme16 = calendar16.getTimeInMillis() + (AlarmManager.INTERVAL_DAY+1);
                            else
                                milisegundos_alarme16 = calendar16.getTimeInMillis();

                            tarefaPendingIntent16 = PendingIntent.getBroadcast(getApplicationContext(), id16, tarefaIntent16, PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmManager16.setRepeating(AlarmManager.RTC_WAKEUP, milisegundos_alarme16, AlarmManager.INTERVAL_DAY, tarefaPendingIntent16);

                            //seta os valores dos campos no Banco de dados

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeRotina8")
                                    .setValue(edtNome1);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaLigar8")
                                    .setValue(editHora11);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoLigar8")
                                    .setValue(editMinuto11);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("horaDesligar8")
                                    .setValue(editHora22);

                            FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("minutoDesligar8")
                                    .setValue(editMinuto22);


                            myDialog4.dismiss();
                            return;
                        }
                    }

                    if ((!txtNomeRot2Tom4.equals("Clique no '+' para adicionar")) || (!txtNomeRot1Tom4.equals("Clique no '+' para adicionar"))) {
                        Toast.makeText(getApplicationContext(),"Limite de rotinas da tomada atingida! Exclua uma para adicionar.",Toast.LENGTH_SHORT).show();
                    }

                    } else{
                        Toast.makeText(getApplicationContext(), "Adicione esta tomada no HUB para criar uma rotina!", Toast.LENGTH_SHORT).show();
                    }


                }
            }

        });




    }



    public boolean validarEntradas(EditText Nome1,EditText Hora1,EditText Minuto1, EditText Hora2, EditText Minuto2){



        if (edtNome1.isEmpty()){
            Nome1.setError("Informe um valor!");
            return false;
        }

        if (editHora1.isEmpty()){
            Hora1.setError("Informe um valor!");
            return false;
        }

        if (Integer.parseInt(editHora1) > 23){
            Hora1.setError("Informe um valor menor que 24!");
            return false;
        }

        if (Integer.parseInt(editHora1) < 0){
            Hora1.setError("Informe um valor que seja zero ou maior!");
            return false;
        }
        ////////////////////////////////

        if (editMinuto1.isEmpty()){
            Minuto1.setError("Informe um valor!");
            return false;
        }

        if (Integer.parseInt(editMinuto1) > 59){
            Minuto1.setError("Informe um valor menor que 60!");
            return false;
        }

        if (Integer.parseInt(editMinuto1) < 0){
            Minuto1.setError("Informe um valor que seja zero ou maior!");
            return false;
        }

        //////////////////////////////////////

        if (editHora2.isEmpty()){
            Hora2.setError("Informe um valor!");
            return false;
        }

        if (Integer.parseInt(editHora2) > 23){
            Hora2.setError("Informe um valor menor que 24!");
            return false;
        }

        if (Integer.parseInt(editHora2) < 0){
            Hora2.setError("Informe um valor que seja zero ou maior!");
            return false;
        }

        /////////////////////////////////

        if (editMinuto2.isEmpty()){
            Minuto2.setError("Informe um valor!");
            return false;
        }

        if (Integer.parseInt(editMinuto2) > 59){
            Minuto2.setError("Informe um valor menor que 60!");
            return false;
        }

        if (Integer.parseInt(editMinuto2) < 0){
            Minuto2.setError("Informe um valor que seja zero ou maior!");
            return false;
        }

        ////////////////////////////////
        return true;

    }



}

