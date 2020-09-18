package com.example.filling;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.filling.Login.Activity_Splash;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Main extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Main_Popup Main_Popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Intent intent = new Intent(this, Activity_Splash.class);
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
                R.id.Drawer_CashExchange, R.id.Drawer_CashCharge, R.id.Drawer_CashGift, R.id.bottom_filling, R.id.nav_gallery, R.id.nav_slideshow, R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        BottomNavigationView navView = findViewById(R.id.nav_vi);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.Drawer_CashExchange, R.id.Drawer_CashCharge, R.id.Drawer_CashGift, R.id.bottom_filling, R.id.nav_gallery, R.id.nav_slideshow, R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavigationUI.setupWithNavController(navView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.bottom_filling || destination.getId() == R.id.navigation_dashboard || destination.getId() == R.id.navigation_notifications || destination.getId() == R.id.navigation_home) {
                    navView.setVisibility(View.VISIBLE);
                    toolbar.setVisibility(View.VISIBLE);
                } else {
                    navView.setVisibility(View.GONE);
                    toolbar.setVisibility(View.GONE);
                }
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