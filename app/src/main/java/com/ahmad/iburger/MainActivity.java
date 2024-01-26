package com.ahmad.iburger;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View navigation_menucustom;
    private boolean MenuVisible = false;
    TextView snaklayoubtn,burgerlayout_btn;
    ImageView btn_nav_menu,snakbtn,burgerbtn;
    Animator anim;
    private FrameLayout navmenu_container ;
    private Button profile,burger_menu,snaks_menu,orders,loction_menu,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declare btn navigation menu custom and listener
        navigation_menucustom = getLayoutInflater().inflate(R.layout.navigationmenu_custom, null);
        profile = navigation_menucustom.findViewById(R.id.profile);
        burger_menu = navigation_menucustom.findViewById(R.id.burger_menu);
        snaks_menu = navigation_menucustom.findViewById(R.id.snaks_menu);
        orders = navigation_menucustom.findViewById(R.id.orders);
        loction_menu = navigation_menucustom.findViewById(R.id.locatin_menu);
        logout = navigation_menucustom.findViewById(R.id.logout);
        navigation_menucustom.setVisibility(View.INVISIBLE);
        btn_nav_menu = findViewById(R.id.button_nav);
        profile.setOnClickListener(this);
        burger_menu.setOnClickListener(this);
        snaks_menu.setOnClickListener(this);
        orders.setOnClickListener(this);
        loction_menu.setOnClickListener(this);
        logout.setOnClickListener(this);
        btn_nav_menu.setOnClickListener(this);
        snakbtn=findViewById(R.id.snakbtn);
        burgerbtn=findViewById(R.id.burgerbtn);
        snakbtn.setOnClickListener(this);
        burgerbtn.setOnClickListener(this);
        snakbtn=findViewById(R.id.snakbtn);
        burgerbtn=findViewById(R.id.burgerbtn);
        navmenu_container = findViewById(R.id.navmenu_container);
        navmenu_container.addView(navigation_menucustom);
        snaklayoubtn=findViewById(R.id.snaklayoubtn);
        burgerlayout_btn=findViewById(R.id.burgerlayout_btn);
        snaklayoubtn.setOnClickListener(this);
        burgerlayout_btn.setOnClickListener(this);

    }

    /*
in  this two function will animate   navigation menu custom
show navigation layout and  hide navigation layout
 */
    private void ShowNavigationLayout () {

        navigation_menucustom.setVisibility(View.VISIBLE);

        int cx = navigation_menucustom.getRight();
        int cy = navigation_menucustom.getTop();
        int finalRadius = Math.max(navigation_menucustom.getWidth(), navigation_menucustom.getHeight());
        MenuVisible = true;
        anim = ViewAnimationUtils.createCircularReveal(navigation_menucustom, cx, cy, 0, finalRadius);
        anim.setDuration(1000);

        anim.start();
    }
    private void HideNavigationLayout () {
        MenuVisible=false;
        int cx = navigation_menucustom.getRight();
        int cy = navigation_menucustom.getTop();
        int Radius = navigation_menucustom.getWidth();
        anim = ViewAnimationUtils.createCircularReveal(navigation_menucustom, cx, cy, Radius, 0);
        anim.setDuration(1000);
        anim.start();
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                navigation_menucustom.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public void onBackPressed () {
        if (MenuVisible) {
            HideNavigationLayout();
        } else {
            super.onBackPressed();

        }

    }




    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_nav) {
            if (MenuVisible){
                HideNavigationLayout();
            }else {
                ShowNavigationLayout();
            }
        }else if (v.getId()==R.id.profile){
            HideNavigationLayout();
            startActivity(new Intent(this, profile.class));

        }else if (v.getId()==R.id.snaks_menu){
            HideNavigationLayout();
            startActivity(new Intent(this, snaks.class));

        }else if (v.getId()==R.id.burger_menu){
            HideNavigationLayout();
            startActivity(new Intent(this, burger.class));

        }else if (v.getId()==R.id.orders){
            HideNavigationLayout();
            startActivity(new Intent(this, orders.class));
        }else if (v.getId()==R.id.locatin_menu){
            HideNavigationLayout();
            startActivity(new Intent(this, location.class));
        }else if (v.getId()==R.id.logout){
            HideNavigationLayout();
            Toast.makeText(this, "loggedout", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, login.class));
        }else if (v.getId()==R.id.snakbtn){
            startActivity(new Intent(this, snaks.class));
        }else if (v.getId()==R.id.burgerbtn){
            startActivity(new Intent(this, burger.class));
        }else if (v.getId()==R.id.snaklayoubtn){
            startActivity(new Intent(this, snaks.class));
        }else if (v.getId()==R.id.burgerlayout_btn){
            startActivity(new Intent(this, burger.class));
        }
    }
}