package com.ahmad.iburger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.ahmad.iburger.adabter.adabter_order;
import com.ahmad.iburger.adabter.module_options;



import java.util.ArrayList;

public class orders extends AppCompatActivity implements View.OnClickListener {
RecyclerView items_order;
    ArrayList <module_options> orders_list;
    ImageView back_btn_order,menubtn_order,checkout_btn;
   private FrameLayout navmenu_container_order;
   private  View navigation_menucustom;
    adabter_order adabter_order;
    private Button profile,burger_menu,snaks_menu,orders,location_menu,logout,save_btn;
boolean openedmenu=false;
    int total_price;
    Intent orderslist;
    Animator anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        items_order = findViewById(R.id.items_order);
    //get value stored in intent
        Intent intent = getIntent();
        orders_list = intent.getParcelableArrayListExtra("orders_cart");
        getdata(orders_list);
    //intilize UI component
     back_btn_order=findViewById(R.id.back_btn_order);
     menubtn_order=findViewById(R.id.menubtn_order);
     checkout_btn=findViewById(R.id.checkout_btn);
     checkout_btn.setOnClickListener(this);

        navigation_menucustom=getLayoutInflater().inflate(R.layout.navigationmenu_custom,null);
        navmenu_container_order=findViewById(R.id.navmenu_container_order);
        navigation_menucustom.setVisibility(View.INVISIBLE);

        back_btn_order.setOnClickListener(this);
        navmenu_container_order.addView(navigation_menucustom);
        menubtn_order.setOnClickListener(this);
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
private void getdata(ArrayList <module_options> orders_list){

    if (orders_list!=null){
       adabter_order=new adabter_order(orders_list,orders.this);
        items_order.setAdapter(adabter_order);
        items_order.setLayoutManager(new GridLayoutManager(orders.this,2));
        total_price=adabter_order.getTotalPrice();
    }}

    @Override
    public void onClick(View v) {
if (v.getId()==R.id.checkout_btn){
    total_price=adabter_order.getTotalPrice();
    if (total_price>0){
        Intent send_price_and_List=new Intent(orders.this,checkout.class);
        send_price_and_List.putParcelableArrayListExtra("orders_cart", orders_list);
        send_price_and_List.putExtra("total_price",total_price);
        startActivity(send_price_and_List);
    }else {
        Toast.makeText(this, "you dont have any thing in cart", Toast.LENGTH_SHORT).show();
    }

    }else    if (v.getId() == R.id.menubtn_order) {
    if (openedmenu){
        HideNavigationLayout();
    }else {
        ShowNavigationLayout();
    }
}else if (v.getId()==R.id.profile){
    HideNavigationLayout();

    startActivity(new Intent(this, profile.class));

}else if (v.getId()==R.id.snaks_menu){
    orderslist =new Intent(this,snaks.class);
    orderslist.putParcelableArrayListExtra("burgerlist", orders_list);
    startActivity(orderslist);
    HideNavigationLayout();

}else if (v.getId()==R.id.burger_menu){
    orderslist =new Intent(this,burger.class);
    orderslist.putParcelableArrayListExtra("snaklist", orders_list);
    startActivity(orderslist);
    HideNavigationLayout();

}else if (v.getId()==R.id.orders){
    HideNavigationLayout();
}else if (v.getId()==R.id.locatin_menu){
    startActivity(new Intent(this, location.class));

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

}



    }
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
}}




