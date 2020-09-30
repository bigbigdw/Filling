package com.example.filling.Coupon;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.filling.R;
import java.util.Objects;

public class Coupon_List extends AppCompatActivity {

    HorizontalScrollView ScrollBefore;
    TableLayout ScrollAfter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupon_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ScrollBefore = findViewById(R.id.ScrollBefore);
        ScrollAfter = findViewById(R.id.ScrollAfter);

    }

    public void onClickUnfold(View v) {
        ScrollAfter.setVisibility(View.VISIBLE);
        ScrollBefore.setVisibility(View.GONE);
    }

    public void onClickFold(View v) {
        ScrollAfter.setVisibility(View.GONE);
        ScrollBefore.setVisibility(View.VISIBLE);
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

