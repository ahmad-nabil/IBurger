package com.ahmad.iburger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity  implements View.OnClickListener {
        Button forgotpassword_Btn,signuplayout_btn,loginbtn;
        EditText emaillogin,passswordlogin;
        SharedPreferences logindata;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activitylogin);
            logindata=getSharedPreferences("user",MODE_PRIVATE);
            //declare UI with listener
            forgotpassword_Btn=findViewById(R.id.forgotpassword_Btn);
            signuplayout_btn=findViewById(R.id.signuplayout_btn);
            loginbtn=findViewById(R.id.loginbtn);
            forgotpassword_Btn.setOnClickListener(this);
            signuplayout_btn.setOnClickListener(this);
            loginbtn.setOnClickListener(this);
            emaillogin=findViewById(R.id.emaillogin_edittext);
            passswordlogin=findViewById(R.id.passlogin_edittext);

        }

        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.signuplayout_btn){
                startActivity(new Intent(this,signup.class));
            } else if (v.getId()==R.id.forgotpassword_Btn) {
                restpassword dialog = new restpassword();
                dialog.show(getSupportFragmentManager(), "rest password");
            } else if (v.getId()==R.id.loginbtn) {
                if (passswordlogin.getText().toString().equals(logindata.getString((emaillogin.getText().toString()+"-password"),null))){;
                    startActivity(new Intent(this,MainActivity.class));
                }
            }}



}