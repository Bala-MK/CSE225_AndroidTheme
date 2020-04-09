package com.example.theme;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {
    EditText editText;
    Button button;

    interface SendEdit{
        void sendData(String s);
    }

    SendEdit sendEdit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=(View) inflater.inflate(R.layout.frag1,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        button=view.findViewById(R.id.send);
        editText=view.findViewById(R.id.editF1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEdit.sendData(editText.getText().toString());
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            sendEdit=(SendEdit)getActivity();
        }
        catch (ClassCastException e){
            throw new ClassCastException("Error");
        }
    }
}
