package com.example.smartsocketteste87634257.Activities.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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


public class b_HubActivity extends AppCompatActivity {

    private Toolbar toolbar;
    Dialog myDialog3;

    private TextView txclose;
    private Button btn_addHub;



    public FirebaseUser currentUser;
    public FirebaseAuth mAuth;

    public String value3;
    private FloatingActionButton fab;

    public String valorEdtStr;
    public EditText valorEdt;
    public EditText edtip1;
    public String edtip2;

    public CardView card1;

    public TextView edtNome;
    public String value1,value2;
    public TextView txt1;
    public TextView ip_hub;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);

        fab = findViewById(R.id.fab);

        edtNome = findViewById(R.id.titulo_hub);
        ip_hub = findViewById(R.id.ip_hub);


        //ini
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        card1 = findViewById(R.id.cardview_id);

        txt1 = findViewById(R.id.txt1);




        myDialog3 = new Dialog(this);

        //tool bar
        toolbar =findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Gerenciar HUB's");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }



        atualizarfab();
        atualizarCard();

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ag = new Intent(getApplicationContext(), b_Tomadas_do_Hub.class);
                startActivity(ag);

            }
        });




        card1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                deletarHub(view);



                return false;
            }
        });

    }

    public void deletarHub(View view){

        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.delete);
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                DatabaseReference nomeHub = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeHub");
                DatabaseReference ipHub = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("ipHub");
                DatabaseReference tom1 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada1");
                DatabaseReference tom2 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada2");
                DatabaseReference tom3 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada3");
                DatabaseReference tom4 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeTomada4");
                DatabaseReference tom11 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada1");
                DatabaseReference tom22 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada2");
                DatabaseReference tom33 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada3");
                DatabaseReference tom44 = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("statusTomada4");


                ipHub.removeValue();
                nomeHub.removeValue();
                tom1.removeValue();
                tom2.removeValue();
                tom3.removeValue();
                tom4.removeValue();
                tom11.removeValue();
                tom22.removeValue();
                tom33.removeValue();
                tom44.removeValue();
                finish();


                Intent ah = new Intent(getApplicationContext(), b_HubActivity.class);
                startActivity(ah);

                return false;
            }
        });


    }




    public void ShowPopupAddHub(View view) {



        DatabaseReference aa =FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeHub");


        aa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value3 = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });


        if (value3 !=null){
            Toast.makeText(getApplicationContext(), "Limite de HUBs por usuário atingido! Limite: 1", Toast.LENGTH_SHORT).show();


        }else{



            myDialog3.setContentView(R.layout.janela_custom_popup_add_hub);

            myDialog3.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog3.show();

            txclose = myDialog3.findViewById(R.id.close);
            txclose.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    myDialog3.dismiss();


                }
            });


            btn_addHub = myDialog3.findViewById(R.id.btn_addHub);
            btn_addHub.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {


                    edtip1 = myDialog3.findViewById(R.id.edt_ipHub);
                    edtip2 = edtip1.getText().toString().trim();


                    valorEdt = myDialog3.findViewById(R.id.edt_nomeHub);
                    valorEdtStr = valorEdt.getText().toString().trim();





                    if (!validarEntradas(valorEdt, edtip1)) {


                    } else{

                        FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("ipHub")
                                .setValue(edtip2);


                        FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeHub")
                                .setValue(valorEdtStr).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                valorEdt.setText("");

                            }
                        });

                        TextView edtNome = findViewById(R.id.titulo_hub);


                        myDialog3.dismiss();
                        edtNome.setText(valorEdtStr);
                        txt1.setVisibility(View.INVISIBLE);
                        card1.setVisibility(View.VISIBLE);

                    }

                }

            });

        }


    }








    public boolean atualizarfab() {


        DatabaseReference aa = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeHub");


        aa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value3 = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });


        if (value3 != null) {

            Toast.makeText(getApplicationContext(), "Limite de HUBs por usuário atingido! Limite: 1", Toast.LENGTH_SHORT).show();


        }else{

        }
        return false;
    }



    private void atualizarCard() {

        DatabaseReference aa = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("nomeHub");
        DatabaseReference aaa = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("ipHub");

        aaa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value2 = dataSnapshot.getValue(String.class);
                ip_hub.setText(value2);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        aa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value1 = dataSnapshot.getValue(String.class);

                if (value1 != null ){
                    txt1.setVisibility(View.INVISIBLE);
                    card1.setVisibility(View.VISIBLE);

                    edtNome.setText(value1);

                    Toast.makeText(getApplicationContext(), "HUB carregado com sucesso!", Toast.LENGTH_SHORT).show();

                } else{

                    Toast.makeText(getApplicationContext(), "Nenhum HUB cadastrado!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Erro ao carregar HUB!", Toast.LENGTH_SHORT).show();
            }
        });


    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home){
            Intent home = new Intent(getApplicationContext(), a_HomeActivity.class);
            startActivity(home);
            finish();
        }
        return  super.onOptionsItemSelected(item);
    }



    public boolean validarEntradas(EditText valorEdt, EditText valorEdtip){

        if (valorEdtStr.isEmpty()){
            valorEdt.setError("Informe um valor!");
            return false;
        }

        if (edtip2.isEmpty()){
            valorEdtip.setError("Informe um valor!");
            return false;
        }

        return true;
    }








}




