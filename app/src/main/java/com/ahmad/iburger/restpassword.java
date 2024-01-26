package com.ahmad.iburger;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class restpassword extends DialogFragment {

    Button rest_btn,cancel_btn;
    EditText emailforgetpassword;
    SharedPreferences checkdata;
    String pass_rest,email_value;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_restpassword, container, false);
        checkdata= getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        rest_btn=v.findViewById(R.id.resetbtn);
        emailforgetpassword=v.findViewById(R.id.emailforgetpassword);
        rest_btn.setOnClickListener(v1 -> {email_value=emailforgetpassword.getText().toString();
            if (TextUtils.isEmpty(email_value)){
                Toast.makeText(getContext().getApplicationContext(), "enter email or cancel", Toast.LENGTH_SHORT).show();
            }else{

                pass_rest=checkdata.getString(email_value+"-password",null);
                Toast.makeText(getContext().getApplicationContext(), "your password is :  " + pass_rest, Toast.LENGTH_SHORT).show();
            }

        });


        return v;
    }
}