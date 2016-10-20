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

    EditText email,pass;
    Button btnLogin;
    TextView txtCadastro;
    String url="", param="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText)findViewById(R.id.email);
        pass = (EditText)findViewById(R.id.pass);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        txtCadastro = (TextView)findViewById(R.id.txtCadastro);

        txtCadastro.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent abreCadastro = new Intent(MainActivity.this, RegisterScreen.class);
                startActivity(abreCadastro);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Checks network status
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {

                    String mail = email.getText().toString();
                    String password = pass.getText().toString();

                    if (mail.isEmpty() || password.isEmpty()){
                        Toast.makeText(getApplicationContext(),
                                "Nenhum campo pode estar vazio",
                                Toast.LENGTH_LONG).show();
                    }else {
                        url = "http://localhost/izirpg/index.php";
                        //param = "email=" + mail + "&pass=" + password;
                        //new RequestData().execute(url,param);
                        new RequestData().execute(url);
                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Nenhuma conexão ativa", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private class RequestData extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            //return Connection.postDados(url,param);
            return GetCharList.requestChars(url);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            email.setText(result);
            //textView.setText(result);
            if(result.contains("login_ok")){
                Intent openChar = new Intent(MainActivity.this, MainActivity.class);
                startActivity(openChar);
            }else{
                Toast.makeText(getApplicationContext(),
                        "Usuário ou senha incorretos",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onPause() {
        finish();
    }
}
