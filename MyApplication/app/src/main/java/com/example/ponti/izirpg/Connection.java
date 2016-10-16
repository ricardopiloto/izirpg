package com.example.ponti.izirpg;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ponti on 16/10/2016.
 */

public class Connection {

    public static String postDados(String urlUsr, String paramUsr){
        URL url;
        HttpURLConnection connection = null;

        try{
            // 'Cleans' the URL sent by the user and open a connection
            url = new URL(urlUsr);
            connection = (HttpURLConnection) url.openConnection();
            // Creates the method to read the information
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length","" + Integer.toString(paramUsr.getBytes().length));
            connection.setRequestProperty("Content-Language","pt-BR");
            // Disables cache and enabled output and input of data
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            // Makes request for the connection and send user parameters
            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
            dataOutputStream.writeBytes(paramUsr);
            dataOutputStream.flush();
            dataOutputStream.close();
            // Getting information back from the request
            InputStream inputStream = connection.getInputStream();
            // Buffering data on a reader and coding defined as UFT-8(might change)
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line;
            StringBuffer answer = new StringBuffer();
            // Appends information into a single String
            while((line = bufferedReader.readLine()) != null){
                answer.append(line);
                answer.append('\r');
            }
            // Closing the buffer and returns the string
            bufferedReader.close();
            return  answer.toString();

        }catch (Exception e){
            return null;
        }finally {
            // Closes connection after its use
            if (connection != null){
                connection.disconnect();
            }
        }
    }
}
