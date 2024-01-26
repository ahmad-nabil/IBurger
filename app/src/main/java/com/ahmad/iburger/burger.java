package com.ahmad.iburger;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.ahmad.iburger.adabter.adabter_recycleview;
import com.ahmad.iburger.adabter.itemsList_and_price;
import com.ahmad.iburger.adabter.module_options;
import java.util.ArrayList;

public class burger extends AppCompatActivity implements View.OnClickListener {
    Animator animator;
    private ImageView backbtn;
    private Button burger_menu;
    RecyclerView itemlist_burger;
    ArrayList<itemsList_and_price> itemsListAndPrices;
    ArrayList<module_options> items_order_cart;
    private Button location_menu;
    private Button logout;
    private ImageView menubtn;
    private View navigation_menucustom;
    private FrameLayout navmenu_container_burger;
    private boolean opeenedMenu = false;
    private Button orders;
    private Button profile;
    private Button snaks_menu;
    ArrayList<module_options> temp_items_order_cart;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.burger);
        this.itemlist_burger = (RecyclerView) findViewById(R.id.itemlist_burger);
        ArrayList<itemsList_and_price> arrayList = new ArrayList<>();
        this.itemsListAndPrices = arrayList;
        arrayList.add(new itemsList_and_price(R.drawable.items3, "CHESS BURGER", "MEAL", 5, 6));
        this.itemsListAndPrices.add(new itemsList_and_price(R.drawable.items2, "BFR BURGER", "MEAL", 4, 6));
        this.itemsListAndPrices.add(new itemsList_and_price(R.drawable.items_1, "MASH BURGER", "MEAL", 3, 4));
        this.itemsListAndPrices.add(new itemsList_and_price(R.drawable.items3, "BEEF burger", "MEAL", 6, 7));
        this.itemsListAndPrices.add(new itemsList_and_price(R.drawable.items2, "CHESS BURGER", "MEAL", 5, 6));
        this.itemsListAndPrices.add(new itemsList_and_price(R.drawable.items_1, "BFR BURGER", "MEAL", 4, 6));
        this.itemsListAndPrices.add(new itemsList_and_price(R.drawable.items3, "MASH BURGER", "MEAL", 3, 4));
        this.itemsListAndPrices.add(new itemsList_and_price(R.drawable.items2, "BEEF burger", "MEAL", 6, 7));
        ArrayList<module_options> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("snaklist");
        this.temp_items_order_cart = parcelableArrayListExtra;
        getdata(parcelableArrayListExtra);
        View inflate = getLayoutInflater().inflate(R.layout.navigationmenu_custom, (ViewGroup) null);
        this.navigation_menucustom = inflate;
        inflate.setVisibility(View.INVISIBLE);
        this.navmenu_container_burger = (FrameLayout) findViewById(R.id.navmenu_container_burgerlayout);
        this.backbtn = (ImageView) findViewById(R.id.backbtn_burger);
        this.menubtn = (ImageView) findViewById(R.id.menu_burger);
        this.navmenu_container_burger.addView(this.navigation_menucustom);
        this.menubtn.setOnClickListener(this);
        this.backbtn.setOnClickListener(this);
        Button button = (Button) this.navigation_menucustom.findViewById(R.id.profile);
        this.profile = button;
        button.setOnClickListener(this);
        Button button2 = (Button) this.navigation_menucustom.findViewById(R.id.snaks_menu);
        this.snaks_menu = button2;
        button2.setOnClickListener(this);
        Button button3 = (Button) this.navigation_menucustom.findViewById(R.id.burger_menu);
        this.burger_menu = button3;
        button3.setOnClickListener(this);
        Button button4 = (Button) this.navigation_menucustom.findViewById(R.id.orders);
        this.orders = button4;
        button4.setOnClickListener(this);
        Button button5 = (Button) this.navigation_menucustom.findViewById(R.id.locatin_menu);
        this.location_menu = button5;
        button5.setOnClickListener(this);
        Button button6 = (Button) this.navigation_menucustom.findViewById(R.id.logout);
        this.logout = button6;
        button6.setOnClickListener(this);
    }

    private void ShowNavigation_menu() {
        int cx = this.navigation_menucustom.getRight();
        int cy = this.navigation_menucustom.getTop();
        int redius = Math.max(this.navigation_menucustom.getWidth(), this.navigation_menucustom.getHeight());
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.navigation_menucustom, cx, cy, 0.0f, redius);
        this.animator = createCircularReveal;
        createCircularReveal.setDuration(500L);
        this.animator.start();
        this.navigation_menucustom.setVisibility(0);
        this.opeenedMenu = true;
    }

    private void hideNavigation_menu() {
        int cx = this.navigation_menucustom.getRight();
        int cy = this.navigation_menucustom.getTop();
        int radius = this.navigation_menucustom.getWidth();
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.navigation_menucustom, cx, cy, radius, 0.0f);
        this.animator = createCircularReveal;
        createCircularReveal.setDuration(500L);
        this.animator.start();
        this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.ahmad.iburgerapp.Burger.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                burger.this.navigation_menucustom.setVisibility(View.INVISIBLE);
                burger.this.opeenedMenu = false;
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.opeenedMenu) {
            hideNavigation_menu();
        } else {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == R.id.profile) {
            startActivity(new Intent(this, profile.class));
            hideNavigation_menu();
        } else if (v.getId() == R.id.burger_menu) {
            hideNavigation_menu();
        } else if (v.getId() == R.id.snaks_menu) {
            Intent orderslist = new Intent(this, snaks.class);
            orderslist.putParcelableArrayListExtra("burgerlist", this.items_order_cart);
            startActivity(orderslist);
            hideNavigation_menu();
        } else if (v.getId() == R.id.orders) {
            Intent orderslist2 = new Intent(this, orders.class);
            orderslist2.putParcelableArrayListExtra("orders_cart", this.items_order_cart);
            startActivity(orderslist2);
            hideNavigation_menu();
        } else if (v.getId() == R.id.locatin_menu) {
            startActivity(new Intent(this, location.class));
            hideNavigation_menu();
        } else if (v.getId() == R.id.logout) {
            Toast.makeText(this, "loggedout", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, login.class));
            hideNavigation_menu();
        } else if (v.getId() == R.id.backbtn_burger) {
            if (this.opeenedMenu) {
                hideNavigation_menu();
            } else {
                finish();
            }
        } else if (v.getId() == R.id.menu_burger) {
            if (this.opeenedMenu) {
                hideNavigation_menu();
            } else {
                ShowNavigation_menu();
            }
        }
    }

    private void getdata(ArrayList<module_options> temp_items_order_cart) {
        if (temp_items_order_cart != null) {
            this.items_order_cart = new ArrayList<>(temp_items_order_cart);
            adabter_recycleview adabterRecycleview = new adabter_recycleview(this, this.itemsListAndPrices, this.items_order_cart, 1);
            this.itemlist_burger.setAdapter(adabterRecycleview);
            this.itemlist_burger.setLayoutManager(new GridLayoutManager(this, 2));
            return;
        }
        this.items_order_cart = new ArrayList<>();
        adabter_recycleview adabterRecycleview2 = new adabter_recycleview(this, this.itemsListAndPrices, this.items_order_cart, 1);
        this.itemlist_burger.setAdapter(adabterRecycleview2);
        this.itemlist_burger.setLayoutManager(new GridLayoutManager(this, 2));
    }
}