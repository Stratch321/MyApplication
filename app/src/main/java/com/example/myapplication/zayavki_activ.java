package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.io.FileInputStream;
import java.io.IOException;

public class zayavki_activ extends AppCompatActivity {
    private final static String FILE_NAME = "context.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Создание формы по шаблону xml
        setContentView(R.layout.zayava_main);
        // Поиск объекта Linear layout по id который указан в коде xml
        LinearLayout line = findViewById(R.id.lineout);
        //Создание стрима для вытаскивания текста из текстового документа
        FileInputStream fin = null;
        try {
            //Указание на файл который надо открыть
            fin = openFileInput(FILE_NAME);
            //Создание массива для хранения текста в байтах
            byte[] bytes = new byte[fin.available()];
            //чтение байтов из текстового документа
            fin.read(bytes);
            //Создание переменной типа Строка для конвертирования байтов в обычный текст
            String text = new String (bytes);
            //Создание объекта класса кнопки
            Button bt = new Button(this);
            //Вставляем текст который ранее вытащили из тектового документа в кнопку
            bt.setText(text);
            //добавление кнопки на форму
            line.addView(bt);
        }
        catch(IOException ex) {
            //Вывод ошибки если такова появляется
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {

            try {
                //Если всё прошло успешно, закрываем файловый поток
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                // Вывод ошибки если не удалось закрыть поток по каким-либо причинам
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }


        //Созданрие аргументов для вывода текста из другой формы
        Bundle arguments = getIntent().getExtras();
      if (arguments!=null)
      {
          //Указание что делать с данными пришедшими из другой формы
          String name = arguments.get("task_nm").toString();
          //Создание объекта класса кнопки
          Button new_task = new Button(this);
          //Установка текста в кнопку из ранее пришедших данных из формы zayavka_descr
          new_task.setText(name);
          //Добавление кнопки на форму
          line.addView(new_task);
      }
    }
    public void add_task(View view)
    {
        //Старт новой активности по нажатию кнопки на форме
        Intent intent = new Intent(this, Addtask.class);
        startActivity(intent);
    }
}