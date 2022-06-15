package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Addtask extends AppCompatActivity {
    //Название файла который будет перезаписан или создан
    private final static String FILE_NAME = "context.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Создание формы по шаблону из xml
        setContentView(R.layout.activity_addtask);

    }
    public void pushtask(View view)
    {
        //Поиск текстового поля по id указанный ранее в xml файле
        EditText name = findViewById(R.id.name_text);
        //Создание переменной типа Строка для конвертации текста из текстового поля в строку
        String _name = name.getText().toString();
        //Содание файлового потока для записи в текстовый файл
        FileOutputStream fos = null;
        try {
            //Указание на название файла и режим доступа к файлу, MODE_APPEND позволяет дополнить файл нежели его перезаписывать
            fos = openFileOutput(FILE_NAME, MODE_APPEND);
            //Запись текста в текстовый файл
            fos.write(_name.getBytes());
            //Уведомление об успешной записи
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {
            //Вывод ошибки в случае если запись прошла неудачно
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                //Закрытие файлового потока в случае удачи
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){
                //Вывод ошибки в случае неудачного закрытия потока
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void view_list(View view)
    {
        //Запуск новой активности по нажатию кнопки
        Intent intent = new Intent(this,zayavki_activ.class);
        startActivity(intent);
    }
}