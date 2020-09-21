package com.example.filling;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Main extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Main_Popup Main_Popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Intent intent = new Intent(this, Splash.class);
        startActivity(intent);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_vie);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.Bottom_Coupon, R.id.Bottom_Dongmu, R.id.Drawer_SystemInfo, R.id.Drawer_Policy, R.id.Drawer_FAQ, R.id.Drawer_Alert, R.id.Drawer_CashExchange, R.id.Drawer_CashCharge, R.id.Drawer_CashGift, R.id.Bottom_filling, R.id.Drawer_Complain)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        BottomNavigationView navView = findViewById(R.id.nav_vi);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.Bottom_Coupon, R.id.Bottom_Dongmu, R.id.Drawer_SystemInfo, R.id.Drawer_Policy, R.id.Drawer_FAQ, R.id.Drawer_Alert, R.id.Drawer_CashExchange, R.id.Drawer_CashCharge, R.id.Drawer_CashGift, R.id.Bottom_filling, R.id.Drawer_Complain)
                .build();
        NavigationUI.setupWithNavController(navView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.Bottom_filling || destination.getId() == R.id.Bottom_Dongmu || destination.getId() == R.id.Bottom_Coupon) {
                navView.setVisibility(View.VISIBLE);
                toolbar.setVisibility(View.VISIBLE);
            } else {
                navView.setVisibility(View.GONE);
                toolbar.setVisibility(View.GONE);
            }
        });

        Main_Popup = new Main_Popup(this, positiveListener, negativeListener);
        Main_Popup.show();
    }

    private View.OnClickListener positiveListener = new View.OnClickListener() {
        public void onClick(View v) {
            Main_Popup.dismiss();
        }
    };

    private View.OnClickListener negativeListener = new View.OnClickListener() {
        public void onClick(View v) {
            Main_Popup.dismiss();
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}