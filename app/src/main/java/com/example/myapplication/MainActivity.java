package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Создаём окно по шаблону xml
        setContentView(R.layout.constraintlayout_test);
    }



    public void Onclick(View view){
        //Создаём объект класса Intent для вызова следующей активность
        Intent zayav_int = new Intent(this, Addtask.class);
        //Вызов активности
        startActivity(zayav_int);
    }
}