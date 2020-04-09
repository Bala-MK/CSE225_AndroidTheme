package com.example.theme;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    interface SendToFrag2{
        void radioValue(int i);
        void savePreferences(String s,int i);
        void loadPreferences(RadioGroup r);
    }

    SendToFrag2 sf;
    String s[]={"Blue","Red","Green","Yellow","Black","Teal","Cyan","Pink","Gray","Purple"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=(View) inflater.inflate(R.layout.fragment1,container,false);
        RadioGroup rg=rootview.findViewById(R.id.RG);
        for(int i=0;i<10;i++){
            RadioButton rb=new RadioButton(getContext());
            rb.setText(s[i]);
            rg.addView(rb);
        }
        sf.loadPreferences(rg);
        return rootview;
    }

   @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        final RadioGroup rg=view.findViewById(R.id.RG);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = radioGroup.findViewById(i);
                int index=radioGroup.indexOfChild(radioButton);
                String s=radioButton.getText().toString();
                sf.savePreferences("Radio_index",index);
                sf.radioValue(index);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            sf=(SendToFrag2)getActivity();
        }
        catch (ClassCastException e){
            throw new ClassCastException("Error");
        }
    }
}
