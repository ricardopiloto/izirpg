package com.example.ponti.izirpg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CharList extends AppCompatActivity {

    String url = "http://localhost/android/webservices/get_chars.php";

    private static final String TAG_RESULTS = "result";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_ADD ="player_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_list);
    }
}
