package com.example.theme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Main3Activity extends AppCompatActivity implements Frag1.SendEdit {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    @Override
    public void sendData(String s) {
        Frag2 frag2=(Frag2)getSupportFragmentManager().findFragmentById(R.id.frag2);
        frag2.setTxt(s);
    }
}
