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

public class confirmorder extends AppCompatActivity implements View.OnClickListener {
    Animator anim;
    private ImageView backbtn_confirm;
    private Button burger_menu;
    private Button location_menu;
    private Button logout;
    private ImageView menubtn_confirm;
    private View navigation_menucustom;
    FrameLayout navmenucontainer_confirmpage;
    boolean openedmenu = false;
    private Button orders;
    private Button profile;
    private Button snaks_menu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmorder);
        this.backbtn_confirm = (ImageView) findViewById(R.id.baackbtn_confim);
        this.menubtn_confirm = (ImageView) findViewById(R.id.menu_confirm);
        this.navigation_menucustom = getLayoutInflater().inflate(R.layout.navigationmenu_custom, (ViewGroup) null);
        this.navmenucontainer_confirmpage = (FrameLayout) findViewById(R.id.navmenucontainer_confirmpage);
        this.navigation_menucustom.setVisibility(4);
        this.backbtn_confirm.setOnClickListener(this);
        this.navmenucontainer_confirmpage.addView(this.navigation_menucustom);
        this.menubtn_confirm.setOnClickListener(this);
        this.profile = (Button) this.navigation_menucustom.findViewById(R.id.profile);
        this.burger_menu = (Button) this.navigation_menucustom.findViewById(R.id.burger_menu);
        this.orders = (Button) this.navigation_menucustom.findViewById(R.id.orders);
        this.snaks_menu = (Button) this.navigation_menucustom.findViewById(R.id.snaks_menu);
        this.location_menu = (Button) this.navigation_menucustom.findViewById(R.id.locatin_menu);
        this.logout = (Button) this.navigation_menucustom.findViewById(R.id.logout);
        this.profile.setOnClickListener(this);
        this.burger_menu.setOnClickListener(this);
        this.snaks_menu.setOnClickListener(this);
        this.location_menu.setOnClickListener(this);
        this.logout.setOnClickListener(this);
        this.orders.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == R.id.menu_confirm) {
            if (this.openedmenu) {
                HideNavigationLayout();
            } else {
                ShowNavigationLayout();
            }
        } else if (v.getId() == R.id.profile) {
            HideNavigationLayout();
            startActivity(new Intent(this, profile.class));
        } else if (v.getId() == R.id.snaks_menu) {
            HideNavigationLayout();
            startActivity(new Intent(this, snaks.class));
        } else if (v.getId() == R.id.burger_menu) {
            HideNavigationLayout();
            startActivity(new Intent(this, burger.class));
        } else if (v.getId() == R.id.orders) {
            HideNavigationLayout();
            startActivity(new Intent(this, orders.class));
        } else if (v.getId() == R.id.locatin_menu) {
            HideNavigationLayout();
            startActivity(new Intent(this, location.class));
        } else if (v.getId() == R.id.logout) {
            HideNavigationLayout();
            Toast.makeText(this, "loggedout", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, login.class));
        } else if (v.getId() == R.id.baackbtn_confim) {
            if (this.openedmenu) {
                HideNavigationLayout();
            } else {
                startActivity(new Intent(this, MainActivity.class));
            }
        }
    }

    private void ShowNavigationLayout() {
        this.navigation_menucustom.setVisibility(0);
        int cx = this.navigation_menucustom.getRight();
        int cy = this.navigation_menucustom.getTop();
        int finalRadius = Math.max(this.navigation_menucustom.getWidth(), this.navigation_menucustom.getHeight());
        this.openedmenu = true;
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.navigation_menucustom, cx, cy, 0.0f, finalRadius);
        this.anim = createCircularReveal;
        createCircularReveal.setDuration(1000L);
        this.anim.start();
    }

    private void HideNavigationLayout() {
        this.openedmenu = false;
        int cx = this.navigation_menucustom.getRight();
        int cy = this.navigation_menucustom.getTop();
        int Radius = this.navigation_menucustom.getWidth();
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.navigation_menucustom, cx, cy, Radius, 0.0f);
        this.anim = createCircularReveal;
        createCircularReveal.setDuration(1000L);
        this.anim.start();
        this.anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                confirmorder.this.navigation_menucustom.setVisibility(4);
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.openedmenu) {
            HideNavigationLayout();
        } else {
            startActivity(new Intent(this, login.class));
        }
    }
}