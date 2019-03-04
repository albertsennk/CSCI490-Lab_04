package com.example.android.lab4albertsen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webConnect("https://jsonplaceholder.typicode.com/users");

//        text = findViewById(R.id.text);
//        String ok
    }

    public String webConnect(String... string) {
        URL url = null;
        try {
            url = new URL(string[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        URLConnection connection = null;
        try {
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line =null;

        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;
        while(i < 20) {
            try {
                line += bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }

        return line;
    }
}
