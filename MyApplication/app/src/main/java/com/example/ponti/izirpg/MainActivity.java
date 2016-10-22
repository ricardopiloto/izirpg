package com.example.ponti.izirpg;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.ponti.izirpg.R.id.btnGetChars;
import static com.example.ponti.izirpg.R.id.btnLogin;

public class MainActivity extends AppCompatActivity {
    Button btnCharList;
    String url = "http://localhost/android/webservices/json_code.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCharList = (Button)findViewById(btnGetChars);

        btnCharList.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //new GetCharList().requestChars(url);
                Intent CharList = new Intent(MainActivity.this, CharList.class);
                startActivity(CharList);
            }
        });
    }
}
