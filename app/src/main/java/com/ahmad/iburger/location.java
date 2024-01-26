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
import android.widget.Toast;

public class location extends AppCompatActivity implements View.OnClickListener {
    private ImageView menulocaion,backlocation;
    boolean openedmenu=false;
    private View navigation_menucustom;
    FrameLayout navigationcontainer_locationmenu;
    Animator anim;
    private Button profile,burger_menu,snaks_menu,orders,location_menu,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        backlocation=findViewById(R.id.backlocation);
        menulocaion=findViewById(R.id.menu_location);
        navigation_menucustom=getLayoutInflater().inflate(R.layout.navigationmenu_custom,null);
        navigationcontainer_locationmenu=findViewById(R.id.navigationcontainer_locationmenu);
        navigation_menucustom.setVisibility(View.INVISIBLE);

        menulocaion.setOnClickListener(this);
        navigationcontainer_locationmenu.addView(navigation_menucustom);
        backlocation.setOnClickListener(this);
        // button menu
        profile=navigation_menucustom.findViewById(R.id.profile);
        burger_menu=navigation_menucustom.findViewById(R.id.burger_menu);
        orders=navigation_menucustom.findViewById(R.id.orders);
        snaks_menu=navigation_menucustom.findViewById(R.id.snaks_menu);
        location_menu=navigation_menucustom.findViewById(R.id.locatin_menu);
        logout=navigation_menucustom.findViewById(R.id.logout);

        profile.setOnClickListener(this);
        burger_menu.setOnClickListener(this);
        snaks_menu.setOnClickListener(this);
        location_menu.setOnClickListener(this);
        logout.setOnClickListener(this);
        orders.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
    if (v.getId() == R.id.menu_location) {
        if (openedmenu){
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
  }else if (v.getId()==R.id.logout){
        HideNavigationLayout();
        Toast.makeText(this, "loggedout", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, login.class));
    } else if (v.getId()==R.id.backlocation) {
        if (openedmenu){
            HideNavigationLayout();
        }else {
finish();
        }

    }}

    private void ShowNavigationLayout () {

        navigation_menucustom.setVisibility(View.VISIBLE);

        int cx = navigation_menucustom.getRight();
        int cy = navigation_menucustom.getTop();
        int finalRadius = Math.max(navigation_menucustom.getWidth(), navigation_menucustom.getHeight());
        openedmenu = true;
        anim = ViewAnimationUtils.createCircularReveal(navigation_menucustom, cx, cy, 0, finalRadius);
        anim.setDuration(1000);

        anim.start();
    }
    private void HideNavigationLayout () {
        openedmenu=false;
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
        if (openedmenu) {
            HideNavigationLayout();
        } else {

            startActivity(new Intent(this, login.class));
        }

    }
}