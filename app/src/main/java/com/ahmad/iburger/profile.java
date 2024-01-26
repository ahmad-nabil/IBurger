package com.ahmad.iburger;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmad.iburger.adabter.module_options;

import java.util.ArrayList;

public class profile extends AppCompatActivity implements View.OnClickListener {
ImageView backbtn_profile,menubtn_profile;
ArrayList<module_options>order_cart;
    private View navigation_menucustom;
    private Button profile,burger_menu,snaks_menu,orders,location_menu,logout,save_btn;
FrameLayout navmenu_container_profile;
private boolean opeenedMenu=false;
Animator animator;
    Intent orderslist;
    SharedPreferences getdata;
    EditText fullname_profile,phonetextfiled_profile,emailtextfiled_profile,location_edittext_profile,re_passwordfiled_edittext_profile,passwordfiled_edittext_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
      //shared prefernce
       getdata=getSharedPreferences("user",MODE_PRIVATE);
        //intilize edittext;
        fullname_profile=findViewById(R.id.fullname_profile);
        fullname_profile.setText(getdata.getString("full_name",null));
        phonetextfiled_profile=findViewById(R.id.phonetextfiled_profile);
        phonetextfiled_profile.setText(getdata.getString("phone",null));
        emailtextfiled_profile=findViewById(R.id.emailtextfiled_profile);
        emailtextfiled_profile.setText(getdata.getString("email",null));
        location_edittext_profile=findViewById(R.id.location_edittext_profile);
        location_edittext_profile.setText(getdata.getString("location",null));
        re_passwordfiled_edittext_profile=findViewById(R.id.re_passwordfiled_edittext_profile);
        passwordfiled_edittext_profile=findViewById(R.id.passwordfiled_edittext_profile);
        passwordfiled_edittext_profile.setText(getdata.getString(emailtextfiled_profile.getText().toString()+"-password",null));
        re_passwordfiled_edittext_profile.setText(getdata.getString(emailtextfiled_profile.getText().toString()+"-password",null));
        //intilize button an menu
        navigation_menucustom =getLayoutInflater().inflate(R.layout.navigationmenu_custom,null);
        navigation_menucustom.setVisibility(View.INVISIBLE);
        navmenu_container_profile=findViewById(R.id.navmenucontainer_profile);
        backbtn_profile=findViewById(R.id.backbtn_profile);
        menubtn_profile=findViewById(R.id.menu_profile);
        navmenu_container_profile.addView(navigation_menucustom);
        profile= navigation_menucustom.findViewById(R.id.profile);
        profile.setOnClickListener(this);
        snaks_menu= navigation_menucustom.findViewById(R.id.snaks_menu);
        snaks_menu.setOnClickListener(this);
        burger_menu= navigation_menucustom.findViewById(R.id.burger_menu);
        burger_menu.setOnClickListener(this);
        orders= navigation_menucustom.findViewById(R.id.orders);
        orders.setOnClickListener(this);
        location_menu= navigation_menucustom.findViewById(R.id.locatin_menu);
        location_menu.setOnClickListener(this);
        logout= navigation_menucustom.findViewById(R.id.logout);
        logout.setOnClickListener(this);
       save_btn=findViewById(R.id.save_btn);
       save_btn.setOnClickListener(this);
        menubtn_profile.setOnClickListener(this);
        backbtn_profile.setOnClickListener(this);
//get data if you ordered in cart
        order_cart = getIntent().getParcelableArrayListExtra("orders_cart");

    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.profile){
            hideNavigation_menu();
        } else if (v.getId()==R.id.burger_menu){
            orderslist=new Intent(this, burger.class);
            orderslist.putParcelableArrayListExtra("snaklist", order_cart);
            startActivity(orderslist);
            hideNavigation_menu();
        } else if (v.getId()==R.id.snaks_menu){
          orderslist=new Intent(this, snaks.class);
            orderslist.putParcelableArrayListExtra("burgerlist", order_cart);
            startActivity(orderslist);
            hideNavigation_menu();
        } else if (v.getId()==R.id.orders){
           orderslist=new Intent(this,orders.class);
            orderslist.putParcelableArrayListExtra("orders_cart", order_cart);
            startActivity(orderslist);
            hideNavigation_menu();
        } else if (v.getId()==R.id.locatin_menu){
            startActivity(new Intent(this, location.class));
            hideNavigation_menu();
        } else if (v.getId()==R.id.logout){
            Toast.makeText(this, "loggedout", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, login.class));
            hideNavigation_menu();
        } else if (v.getId()==R.id.backbtn_profile){
            if (opeenedMenu){
                hideNavigation_menu();
            }else{
                finish();
            }

        }else if (v.getId()==R.id.menu_profile){
            if (opeenedMenu){
                hideNavigation_menu();
            }else{
                ShowNavigation_menu();
            }
        } else if (v.getId()==R.id.save_btn) {
            SharedPreferences.Editor save=getdata.edit();
            if (TextUtils.isEmpty(fullname_profile.getText().toString())||TextUtils.isEmpty(phonetextfiled_profile.getText().toString())){
                save.putString("email",emailtextfiled_profile.getText().toString()).commit();
                save.putString(emailtextfiled_profile.getText().toString()+"-password",passwordfiled_edittext_profile.getText().toString()).commit();
              if (order_cart!=null){
                  orderslist=new Intent(this,MainActivity.class);
                  orderslist.putParcelableArrayListExtra("orders_cart", order_cart);
                  startActivity(orderslist);
              }else{
                  startActivity(new Intent(this,MainActivity.class));
              }


            }else{
                save.putString("full_name",fullname_profile.getText().toString()).commit();
                save.putString("phone",phonetextfiled_profile.getText().toString()).commit();
                save.putString("location",location_edittext_profile.getText().toString()).commit();
                save.putString("email",emailtextfiled_profile.getText().toString()).commit();
                save.putString(emailtextfiled_profile.getText().toString()+"-password",phonetextfiled_profile.getText().toString()).commit();
                startActivity(new Intent(this, MainActivity.class));
                if (order_cart!=null){
                    orderslist=new Intent(this,MainActivity.class);
                    orderslist.putParcelableArrayListExtra("orders_cart", order_cart);
                    startActivity(orderslist);
                }else{
                    startActivity(new Intent(this,MainActivity.class));
                }

            }

            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
        }

    }
    private void ShowNavigation_menu() {
        int cx= navigation_menucustom.getRight();
        int cy= navigation_menucustom.getTop();
        int redius=Math.max(navigation_menucustom.getWidth(), navigation_menucustom.getHeight());
        animator= ViewAnimationUtils.createCircularReveal(navigation_menucustom,cx,cy,0,redius);
        animator.setDuration(500);
        animator.start();
        navigation_menucustom.setVisibility(View.VISIBLE);
        opeenedMenu=true;
    }

    private void hideNavigation_menu() {

        int cx= navigation_menucustom.getRight();
        int cy= navigation_menucustom.getTop();
        int radius= navigation_menucustom.getWidth();
        animator= ViewAnimationUtils.createCircularReveal(navigation_menucustom,cx,cy,radius,0);
        animator.setDuration(500);
        animator.start();
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                navigation_menucustom.setVisibility(View.INVISIBLE);
                opeenedMenu=false;
            }
        });

    }
}