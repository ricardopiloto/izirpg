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

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    String url = "http://localhost/android/webservices/json_code.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Checks network status
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    new GetCharList().requestChars(url);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Nenhuma conexão ativa", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
