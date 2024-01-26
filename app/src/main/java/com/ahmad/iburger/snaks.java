package com.ahmad.iburger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.ahmad.iburger.adabter.adabter_recycleview;
import com.ahmad.iburger.adabter.itemsList_and_price;
import com.ahmad.iburger.adabter.module_options;

import java.util.ArrayList;
import java.util.Collections;

public class snaks extends AppCompatActivity implements View.OnClickListener {
private RecyclerView snack_itemlist;

    private View navigation_menucustom;
  private   Button profile,burger_menu,snaks_menu,orders,location_menu,logout;
    private FrameLayout navmenu_container_snaks ;
    private ImageView menubtn_snacklayout,backbtn_snacklayout;
    private boolean opeenedMenu=false;
    Animator anim;
    public ArrayList <module_options> items_in_order_cart;
    ArrayList <itemsList_and_price> itemsListAndPrices;
    public static final int ACTIVITY_IDENTIFIER = 1;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snacks);
    snack_itemlist=findViewById(R.id.snack_itemlist);
        itemsListAndPrices  =new ArrayList<>();
        itemsListAndPrices.add(new itemsList_and_price(R.drawable.items3,"SHAWARMA","MEAL",5,6));
        itemsListAndPrices.add(new itemsList_and_price(R.drawable.items2,"HOTDOG","MEAL",4,6));
        itemsListAndPrices.add(new itemsList_and_price(R.drawable.items_1,"CHRISPY","MEAL",6,7));
        itemsListAndPrices.add(new itemsList_and_price(R.drawable.items3,"FAHETA","MEAL",3,4));
        itemsListAndPrices.add(new itemsList_and_price(R.drawable.items2,"SHAWARMA","MEAL",5,6));
        itemsListAndPrices.add(new itemsList_and_price(R.drawable.items_1,"HOTDOG","MEAL",4,6));
        itemsListAndPrices.add(new itemsList_and_price(R.drawable.items3,"CHRISPY","MEAL",6,7));
        itemsListAndPrices.add(new itemsList_and_price(R.drawable.items2,"FAHETA","MEAL",3,4));
    //GET DATA items snack and burger
    ArrayList <module_options>temp_items_in_order_cart=getIntent().getParcelableArrayListExtra("burgerlist");

 getdata(temp_items_in_order_cart);

    //menu
navigation_menucustom=getLayoutInflater().inflate(R.layout.navigationmenu_custom,null);
navmenu_container_snaks=findViewById(R.id.navmenu_container_snaks);
navigation_menucustom.setVisibility(View.INVISIBLE);
backbtn_snacklayout=findViewById(R.id.backbtn_snacklayout);
backbtn_snacklayout.setOnClickListener(this);
menubtn_snacklayout=findViewById(R.id.menubtn_snacklayout);
navmenu_container_snaks.addView(navigation_menucustom);
menubtn_snacklayout.setOnClickListener(this);
    // button menu
profile=navigation_menucustom.findViewById(R.id.profile);
burger_menu=navigation_menucustom.findViewById(R.id.burger_menu);
    orders=navigation_menucustom.findViewById(R.id.orders);
    snaks_menu=navigation_menucustom.findViewById(R.id.snaks_menu);
    location_menu=navigation_menucustom.findViewById(R.id.locatin_menu);
    logout=navigation_menucustom.findViewById(R.id.logout);
//listener

    profile.setOnClickListener(this);
    burger_menu.setOnClickListener(this);
    snaks_menu.setOnClickListener(this);
    location_menu.setOnClickListener(this);
    logout.setOnClickListener(this);
    orders.setOnClickListener(this);


}
//show custom nav
    public void ShowNavigationLayout() {
    navigation_menucustom.setVisibility(View.VISIBLE);
    int cx=navigation_menucustom.getRight();
    int cy=navigation_menucustom.getTop();
    int radius=Math.max(navigation_menucustom.getWidth(),navigation_menucustom.getHeight());
    anim= ViewAnimationUtils.createCircularReveal(navigation_menucustom,cx,cy,0,radius);
    anim.setDuration(1000)    ;
    opeenedMenu=true;
    anim.start();

    }
    public void hideNavigationLayout() {
        int cx = navigation_menucustom.getRight();
        int cy = navigation_menucustom.getTop();

        int radius=navigation_menucustom.getWidth();
        anim= ViewAnimationUtils.createCircularReveal(navigation_menucustom,cx,cy,radius,0);
        anim.setDuration(1000)    ;
        opeenedMenu=false;
        anim.start();
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                navigation_menucustom.setVisibility(View.INVISIBLE);
            }
        });
    }
//get data if stored from intent
private  void getdata(ArrayList <module_options>temp_items_in_order_cart){
    if (temp_items_in_order_cart!=null){
        items_in_order_cart=new ArrayList<>(temp_items_in_order_cart);
        adabter_recycleview adabterRecycleview=new adabter_recycleview(snaks.this,itemsListAndPrices,items_in_order_cart,2);
        snack_itemlist.setAdapter(adabterRecycleview);
        snack_itemlist.setLayoutManager(new GridLayoutManager(snaks.this,2));
    }else {
        items_in_order_cart=new ArrayList<>();
        adabter_recycleview adabterRecycleview=new adabter_recycleview(snaks.this,itemsListAndPrices,items_in_order_cart,2);
        snack_itemlist.setAdapter(adabterRecycleview);
        snack_itemlist.setLayoutManager(new GridLayoutManager(snaks.this,2));
    }
}
    @Override
    public void onBackPressed() {
    if (opeenedMenu){
        hideNavigationLayout();
    }else{
        super.onBackPressed();

    }
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.profile){
            startActivity(new Intent(this, profile.class));
hideNavigationLayout();
        } else if (v.getId()==R.id.burger_menu){
            Intent orderslist=new Intent(this,burger.class);
            orderslist.putParcelableArrayListExtra("snaklist", items_in_order_cart);
            startActivity(orderslist);
hideNavigationLayout();

        } else if (v.getId()==R.id.snaks_menu){
            hideNavigationLayout();
        } else if (v.getId()==R.id.orders){
            Intent orderslist=new Intent(this,orders.class);
            orderslist.putParcelableArrayListExtra("orders_cart", items_in_order_cart);
startActivity(orderslist);
hideNavigationLayout();
        } else if (v.getId()==R.id.locatin_menu){
            startActivity(new Intent(this, location.class));
hideNavigationLayout();
        } else if (v.getId()==R.id.logout){
            Toast.makeText(this, "loggedout", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, login.class));
            hideNavigationLayout();

        } else if (v.getId()==R.id.backbtn_snacklayout){
            if (opeenedMenu){
                hideNavigationLayout();
            }else{
                finish();
            }
        }else if (v.getId()==R.id.menubtn_snacklayout){
            if (opeenedMenu){
                hideNavigationLayout();
            }else{
ShowNavigationLayout();
            }        }
    }
}