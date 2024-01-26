package com.ahmad.iburger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {
    private ProgressBar progressBar;
    private int splash_time=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_splash);
                progressBar=findViewById(R.id.progressBar);
                progressBar.setMax(100);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int progress = 0;progress<100;progress++){
                            progressBar.setProgress(progress);
                            try {
                                Thread.sleep(splash_time/100);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                        startActivity(new Intent(Splash.this, login.class));
                    }
                }).start();

            }}

