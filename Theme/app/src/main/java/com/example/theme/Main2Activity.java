package com.example.theme;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2Activity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText=findViewById(R.id.edittxt);
    }

    public void clearButton(View view){
        editText.setText("");
    }

    public void saveButton(View view){
        try {
            FileOutputStream fileOutputStream=openFileOutput("EditText.txt",MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(editText.getText().toString());
            outputStreamWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void toastButton(View view){
        try {
            FileInputStream fileInputStream=openFileInput("EditText.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            char[] input=new char[100];
            String s="";
            int chread;
            while((chread=inputStreamReader.read(input))>0){
                String readstr=String.copyValueOf(input,0,chread);
                s+=readstr;
            }
            inputStreamReader.close();
            Toast.makeText(this,s, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void fragBtn(View view){
        Intent i=new Intent(this,Main3Activity.class);
        startActivity(i);
    }
}
