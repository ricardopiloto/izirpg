package com.example.ponti.izirpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void Consulta() throws SQLException, IOException{
        // Variables definition
        String SQL;
        Integer i=0;
        Statement stm = null;

        // Informs which drive will be used
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("Aonde esta o Driver?"); //in case it doesn't find the drivers
            e.printStackTrace();
            return;
        }

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/rpg","root", "");
        }catch(SQLException e){
            System.out.println("Ocorreu um erro de conexao! Verifique o log");
            e.printStackTrace();
            return;
        }
    }
}
