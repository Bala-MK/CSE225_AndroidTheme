package com.example.theme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment1.SendToFrag2 , Fragment2.SendfromFrag2 {

    public static final String MYPREFERENCE="MyPreference";
    ViewPager viewPager;
    PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager) findViewById(R.id.pager);
        pagerAdapter=new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if(viewPager.getCurrentItem()==0){
            super.onBackPressed();
        }
        else {
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
        }
    }

    @Override
    public void radioValue(int i) {
        String tag="android:switcher:" + R.id.pager + ":" +1;
        Fragment2 f=(Fragment2) getSupportFragmentManager().findFragmentByTag(tag);
        f.ChangeTheme(i);
    }

    @Override
    public void savePreferences(String s, int i) {
        SharedPreferences sharedPreferences=getSharedPreferences(MYPREFERENCE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(s,i);
        editor.commit();
    }

    @Override
    public void loadPreferences(RadioGroup r){
        SharedPreferences sharedPreferences=getSharedPreferences(MYPREFERENCE,Context.MODE_PRIVATE);
        int index=sharedPreferences.getInt("Radio_index",0);
        RadioButton rb=(RadioButton) r.getChildAt(index);
        rb.setChecked(true);
    }

    @Override
    public void saveBgColor(String s, int i) {
       SharedPreferences sharedPreferences=getSharedPreferences(MYPREFERENCE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(s,i);
        editor.commit();
    }

    @Override
    public int loadBgColor() {
        SharedPreferences sharedPreferences=getSharedPreferences(MYPREFERENCE,Context.MODE_PRIVATE);
        //int index=3;
        int index=sharedPreferences.getInt("BgColor",0);
        return index;
    }

    public void buttononClick(View view){
        Intent i=new Intent(this,Main2Activity.class);
        startActivity(i);
    }
}
