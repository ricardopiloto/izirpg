package com.example.ponti.izirpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    String url = "http://localhost/android/webservices/json_code.php";
    Button btnGetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetList = (Button)findViewById(R.id.btnGetChars);

        btnGetList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GetList = new Intent(MainActivity.this, CharList.class);
                startActivity(GetList);
            }
        });
    }
}
