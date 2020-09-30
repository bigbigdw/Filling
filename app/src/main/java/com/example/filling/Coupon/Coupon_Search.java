package com.example.filling.Coupon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import com.example.filling.R;

import java.util.Objects;

public class Coupon_Search extends AppCompatActivity {

    EditText CouponSearchText;
    LinearLayout SearchResult;
    NestedScrollView View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupon_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        CouponSearchText = findViewById(R.id.CouponSearchText);
        SearchResult = findViewById(R.id.SearchResult);
        View = findViewById(R.id.View);

        CouponSearchText.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(CouponSearchText.getWindowToken(), 0);
                SearchResult.setVisibility(View.VISIBLE);
                View.setVisibility(View.GONE);
                return true;
            }
            return false;
        });

    }

    public void onClickDetail(View v) {
        Intent intent = new Intent(getApplicationContext(), Coupon_Mart.class);
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {//toolbar의 back키 눌렀을 때 동작
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
