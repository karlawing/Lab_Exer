package com.karl.lab_exer2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.karl.lab_exer2.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword,isUname, isPword;
    Button btnSaveSP,btnSaveIS;
    FileOutputStream fos;
    FileInputStream fis;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.uName);
        etPassword = (EditText) findViewById(R.id.pWord);
        btnSaveSP = (Button) findViewById(R.id.btn_SP);
        btnSaveIS = (Button) findViewById(R.id.btn_IS);
        preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }

    public void saveSP(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", etUsername.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this,"Data Saved!", Toast.LENGTH_SHORT) .show();
    }

    public void saveIS(View view) {
        String message = etUsername.getText().toString();
        String message2 = etPassword.getText().toString();
        try {
            fos = openFileOutput("output.txt", Context.MODE_PRIVATE);
            fos.write(message.getBytes());
            fos.write(message2.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            Toast.makeText(this, "Message saved!", Toast.LENGTH_SHORT).show();
        }
    }


    public void gotonext(View view) {
        Intent intent = new Intent(this, secondactivity.class);
        startActivity(intent);

    }

}
