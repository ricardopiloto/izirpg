package com.example.ponti.izirpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    // Variables definition
    String SQL, pname;
    Integer i = 0;
    Statement stm = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonTap(){
        pname = "William Pendragon";

    }
}
