package com.example.smartsocketteste87634257.Activities.Activities.Sensor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.smartsocketteste87634257.Activities.Activities.a_HomeActivity;
import com.example.smartsocketteste87634257.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class b_SensorActivity extends AppCompatActivity {

    private WebView mWebView;
    public FirebaseUser currentUser;
    public FirebaseAuth mAuth;

    public String iphub;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);


        //tool bar
        toolbar =findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sensores");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //ini
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        mWebView = findViewById(R.id.webView);


        PegarIpHub();


    }



    public void PegarIpHub(){
        final DatabaseReference ipHub = FirebaseDatabase.getInstance().getReference(currentUser.getUid()).child("ipHub");

        ipHub.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                iphub = dataSnapshot.getValue(String.class);

                if(iphub!=null){
                    AbrirConsumo(iphub);
                } else{
                    Toast.makeText(getApplicationContext(),"Adicione um HUB para visualizar os valores dos sensores.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void AbrirConsumo(String iphub){

        mWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        mWebView.loadUrl("http://"+iphub+"/STU");


        Log.i("alarme", "aa "+iphub);
        //mWebView.loadUrl("https://www.google.com/");
        mWebView.setWebViewClient(new MyWebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
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







}
