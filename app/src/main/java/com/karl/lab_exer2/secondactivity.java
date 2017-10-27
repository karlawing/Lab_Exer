package com.karl.lab_exer2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class secondactivity extends AppCompatActivity {

    EditText etUsername, etPassword,isUname, isPword;
    TextView tv_pw,tv_user;
    Button btnloadSP,btnloadIS,btnClear,btnBack;
    FileOutputStream fos;
    FileInputStream fis;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        btnBack = (Button) findViewById(R.id.btn_back);
        btnClear = (Button) findViewById(R.id.btn_clear);
        btnloadSP = (Button) findViewById(R.id.btn_LoadSP);
        btnloadIS = (Button) findViewById(R.id.btn_LIS );
        tv_pw = (TextView) findViewById(R.id.tv_pw);
    }


    public void loadSP(View view){
        SharedPreferences preferences = this.getSharedPreferences("preferences", MODE_PRIVATE);
        String user = preferences.getString("username","");
        String pwd = preferences.getString("password","");
        tv_pw.setText("User is " + user + " and Password is " + pwd);
    }

    public void loadIS(View view) {
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try{
            fis = openFileInput("output.txt");
            while((read = fis.read()) != 1) {
                buffer.append((char)read);
            }
            fis.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        tv_pw.setText(buffer.toString());
    }


    public void buck(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
