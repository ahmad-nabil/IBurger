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
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.ahmad.iburger.adabter.module_options;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class checkout extends AppCompatActivity implements View.OnClickListener {
    Animator animator;
    ImageView backbtn_checkout;
    private Button burger_menu;
    ArrayList<module_options> itemsorder;
    private Button location_menu;
    private Button logout;
    ImageView menubtn_checkout;
    FrameLayout nav_container_checkout;
    private View navigation_menucustom;
    boolean opened_menu = false;
    ImageView orderbtn;
    TextView orderbtn_cheackout;
    private Button orders;
    Intent orderslist;
    TextView price_total_tv;
    private Button profile;
    private Button snaks_menu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        this.itemsorder = getIntent().getParcelableArrayListExtra("orders_cart");
        this.navigation_menucustom = getLayoutInflater().inflate(R.layout.navigationmenu_custom, (ViewGroup) null);
        this.nav_container_checkout = (FrameLayout) findViewById(R.id.nav_container_checkout);
        this.navigation_menucustom.setVisibility(4);
        this.nav_container_checkout.addView(this.navigation_menucustom);
        TextView textView = (TextView) findViewById(R.id.price_total_tv);
        this.price_total_tv = textView;
        textView.setText(String.valueOf(getIntent().getIntExtra("total_price", 0) + "\t JD"));
        this.menubtn_checkout = (ImageView) findViewById(R.id.menubtn_checkout);
        this.backbtn_checkout = (ImageView) findViewById(R.id.backbtn_checkout);
        this.profile = (Button) this.navigation_menucustom.findViewById(R.id.profile);
        this.burger_menu = (Button) this.navigation_menucustom.findViewById(R.id.burger_menu);
        this.snaks_menu = (Button) this.navigation_menucustom.findViewById(R.id.snaks_menu);
        this.orders = (Button) this.navigation_menucustom.findViewById(R.id.orders);
        this.location_menu = (Button) this.navigation_menucustom.findViewById(R.id.locatin_menu);
        this.logout = (Button) this.navigation_menucustom.findViewById(R.id.logout);
        this.menubtn_checkout.setOnClickListener(this);
        this.backbtn_checkout.setOnClickListener(this);
        this.profile.setOnClickListener(this);
        this.orders.setOnClickListener(this);
        this.burger_menu.setOnClickListener(this);
        this.snaks_menu.setOnClickListener(this);
        this.location_menu.setOnClickListener(this);
        this.logout.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.orderbtn);
        this.orderbtn = imageView;
        imageView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.orderbtn_cheackout);
        this.orderbtn_cheackout = textView2;
        textView2.setOnClickListener(this);
    }

    public void ShowNavigationLayout() {
        int cx = this.navigation_menucustom.getRight();
        int cy = this.navigation_menucustom.getTop();
        int radius = Math.max(this.navigation_menucustom.getWidth(), this.navigation_menucustom.getHeight());
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.navigation_menucustom, cx, cy, 0.0f, radius);
        this.animator = createCircularReveal;
        createCircularReveal.setDuration(500L);
        this.animator.start();
        this.navigation_menucustom.setVisibility(0);
        this.opened_menu = true;
    }

    public void hideNavigationLayout() {
        int cx = this.navigation_menucustom.getRight();
        int cy = this.navigation_menucustom.getTop();
        int radius = this.navigation_menucustom.getWidth();
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.navigation_menucustom, cx, cy, radius, 0.0f);
        this.animator = createCircularReveal;
        createCircularReveal.setDuration(500L);
        this.animator.start();
        this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.ahmad.iburgerapp.checkout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                checkout.this.navigation_menucustom.setVisibility(4);
                checkout.this.opened_menu = false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == R.id.profile) {
            Intent intent = new Intent(this, profile.class);
            this.orderslist = intent;
            intent.putParcelableArrayListExtra("orders_cart", this.itemsorder);
            startActivity(this.orderslist);
            hideNavigationLayout();
        } else if (v.getId() == R.id.burger_menu) {
            Intent intent2 = new Intent(this, burger.class);
            this.orderslist = intent2;
            intent2.putParcelableArrayListExtra("snaklist", this.itemsorder);
            startActivity(this.orderslist);
            hideNavigationLayout();
        } else if (v.getId() == R.id.snaks_menu) {
            Intent intent3 = new Intent(this, snaks.class);
            this.orderslist = intent3;
            intent3.putParcelableArrayListExtra("burgerlist", this.itemsorder);
            startActivity(this.orderslist);
            hideNavigationLayout();
        } else if (v.getId() == R.id.orders) {
            Intent intent4 = new Intent(this, orders.class);
            this.orderslist = intent4;
            intent4.putParcelableArrayListExtra("orders_cart", this.itemsorder);
            startActivity(this.orderslist);
            hideNavigationLayout();
        } else if (v.getId() == R.id.locatin_menu) {
            Intent intent5 = new Intent(this, location.class);
            this.orderslist = intent5;
            intent5.putParcelableArrayListExtra("orders_cart", this.itemsorder);
            startActivity(this.orderslist);
            hideNavigationLayout();
        } else if (v.getId() == R.id.logout) {
            Toast.makeText(this, "loggedout", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, login.class));
            hideNavigationLayout();
        } else if (v.getId() == R.id.backbtn_checkout) {
            if (this.opened_menu) {
                hideNavigationLayout();
            } else {
                finish();
            }
        } else if (v.getId() == R.id.menubtn_checkout) {
            if (this.opened_menu) {
                hideNavigationLayout();
            } else {
                ShowNavigationLayout();
            }
        } else if (v.getId() == R.id.orderbtn || v.getId() == R.id.orderbtn_cheackout) {
            Intent intent6 = new Intent(this, confirmorder.class);
            intent6.removeExtra("orders_cart");
            intent6.removeExtra("burgerlist");
            intent6.removeExtra("snaklist");
            startActivity(intent6);
        }
    }
}