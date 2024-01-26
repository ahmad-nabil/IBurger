package com.ahmad.iburger;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class signup extends AppCompatActivity implements View.OnClickListener {
    private EditText full_name, phonetextfiled, emailtextfiled, passwordfiled_edittext, re_passwordfiled_edittext;
    private Button signup_btn;
    TextView location_edittext;
    SharedPreferences signup_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //declare variable shared preferences to save data
        signup_data=getSharedPreferences("user",MODE_PRIVATE);
        //declare ui here with listener
        full_name = findViewById(R.id.full_name);
        phonetextfiled = findViewById(R.id.phonetextfiled);
        emailtextfiled = findViewById(R.id.emailtextfiled);
        passwordfiled_edittext=findViewById(R.id.passwordfiled_edittext);
        re_passwordfiled_edittext=findViewById(R.id.re_passwordfiled_edittext);
        signup_btn=findViewById(R.id.save_btn);
        location_edittext = findViewById(R.id.location_edittext);
        //get location
    fetchLocation();
    }

    private void fetchLocation() {
        location_edittext.setOnClickListener(v -> {
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            Geocoder geocoder = new Geocoder(getApplicationContext());
            for (String provider : locationManager.getAllProviders()) {
                if (ActivityCompat.checkSelfPermission(signup.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(signup.this, ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(signup.this,new String[]{ACCESS_FINE_LOCATION},1);
                    ActivityCompat.requestPermissions(signup.this,new String[]{ACCESS_COARSE_LOCATION},2);
                }else if (ActivityCompat.checkSelfPermission(signup.this, ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(signup.this, ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    Location location = locationManager.getLastKnownLocation(provider);
                    if (location!=null){
                        try{
                            List<Address> addresses=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                            if (addresses!=null&&addresses.size()>0){
                                location_edittext.setText(  addresses.get(0).getLocality()+" "+ addresses.get(0).getCountryName());
                            }

                        }catch (IOException e){
                            e.printStackTrace();
                        }                 }


                }
            }

        });

    }


    @Override
    public void onClick(View v) {
        //check and record data
        SharedPreferences.Editor save=signup_data.edit();

        if (v.getId()==R.id.signuplayout_btn){
            if (TextUtils.isEmpty(emailtextfiled.getText())||TextUtils.isEmpty(passwordfiled_edittext.getText())){
                Toast.makeText(signup.this, "fill email and password together", Toast.LENGTH_SHORT).show();
            }else if (passwordfiled_edittext.getText().toString().equals(re_passwordfiled_edittext.getText().toString())&& passwordfiled_edittext.getText().length()>6){
                if (TextUtils.isEmpty(full_name.getText().toString())||TextUtils.isEmpty(phonetextfiled.getText().toString())){
                    save.putString("email",emailtextfiled.getText().toString()).commit();
                    save.putString(emailtextfiled.getText().toString()+"-password",passwordfiled_edittext.getText().toString()).commit();
                    startActivity(new Intent(signup.this, MainActivity.class));

                }else{
                    save.putString("full_name",full_name.getText().toString()).commit();
                    save.putString("phone",phonetextfiled.getText().toString()).commit();
                    save.putString("location",location_edittext.getText().toString()).commit();
                    save.putString("email",emailtextfiled.getText().toString()).commit();
                    save.putString(emailtextfiled.getText().toString()+"-password",passwordfiled_edittext.getText().toString()).commit();
                    startActivity(new Intent(signup.this, MainActivity.class));
                }

            }else {
                Toast.makeText(signup.this, "rematch passwword", Toast.LENGTH_SHORT).show();
            }
        }
    }
}