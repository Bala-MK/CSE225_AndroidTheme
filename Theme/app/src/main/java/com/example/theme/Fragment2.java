package com.example.theme;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment{
    int color[]={0xFF3498DB,0xFFE74C3C,0xFF2ECC71,0xFFF7DC6F,0xFF17202A,0xFF008080,0xFF00FFFF,0xFFffc6e5,0xFFbdc9b9,0xFF5d5b87};

    interface SendfromFrag2{
        int loadBgColor();
        void saveBgColor(String s,int i);
    }
    SendfromFrag2 sf;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=(View) inflater.inflate(R.layout.fragment2,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        int index=sf.loadBgColor();
        ChangeTheme(index);
    }

    public void ChangeTheme(int i){
        this.getView().setBackgroundColor(color[i]);
        sf.saveBgColor("BgColor",i);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            sf=(SendfromFrag2) getActivity();
        }
        catch (ClassCastException e){
            throw new ClassCastException("Error");
        }
    }
}
