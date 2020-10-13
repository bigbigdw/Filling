package com.example.filling;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.filling.Login.Login;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Main extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Main_Popup Main_Popup;
    TextView Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_vie);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.Bottom_Myinfo, R.id.Bottom_Coupon, R.id.Bottom_Dongmu, R.id.Drawer_SystemInfo, R.id.Drawer_Policy, R.id.Drawer_FAQ, R.id.Drawer_Alert, R.id.Drawer_CashExchange, R.id.Drawer_CashCharge, R.id.Drawer_CashGift, R.id.Bottom_filling, R.id.Drawer_Complain)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        BottomNavigationView navView = findViewById(R.id.nav_bottom);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.Bottom_Myinfo,R.id.Bottom_Coupon, R.id.Bottom_Dongmu, R.id.Drawer_SystemInfo, R.id.Drawer_Policy, R.id.Drawer_FAQ, R.id.Drawer_Alert, R.id.Drawer_CashExchange, R.id.Drawer_CashCharge, R.id.Drawer_CashGift, R.id.Bottom_filling, R.id.Drawer_Complain)
                .build();
        NavigationUI.setupWithNavController(navView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.Bottom_filling || destination.getId() == R.id.Bottom_Dongmu || destination.getId() == R.id.Bottom_Coupon|| destination.getId() == R.id.Bottom_Myinfo) {
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

        public void onClickLogout(View v) {
        Toast.makeText(getApplicationContext(), "로그아웃되었습니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
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
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}