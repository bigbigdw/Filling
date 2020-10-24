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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.R;

import java.util.Objects;

public class Coupon_Search extends AppCompatActivity {

    EditText CouponSearchText;
    LinearLayout SearchResult;
    NestedScrollView View;
    Coupon_ListAdapter adapter;

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
                SearchResult.setVisibility(android.view.View.VISIBLE);
                View.setVisibility(android.view.View.GONE);
                return true;
            }
            return false;
        });
        init();
        getData();
    }

    private void init(){
        RecyclerView recyclerView = findViewById(R.id.Coupon_Item_List);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Coupon_ListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData(){
        Coupon_ListData data = new Coupon_ListData(R.drawable.coupon_detail_ex01, "매머드커피",R.drawable.coupon_detail_ex02, "스타벅스",R.drawable.coupon_detail_ex03, "이디야커피", R.drawable.coupon_detail_ex04, "탐앤탐스");
        adapter.addItem(data);
        data = new Coupon_ListData(R.drawable.coupon_detail_ex05, "카페베네",R.drawable.coupon_detail_ex06, "투썸플레이스",R.drawable.coupon_detail_ex07, "할리스커피", R.drawable.coupon_detail_ex08, "커피빈");
        adapter.addItem(data);
        data = new Coupon_ListData(R.drawable.coupon_detail_ex09, "엔제리너스",R.drawable.coupon_detail_ex10, "더착한커피",R.drawable.coupon_detail_ex11, "빽다방", R.drawable.coupon_detail_ex12, "파스쿠찌");
        adapter.addItem(data);
        data = new Coupon_ListData(R.drawable.coupon_detail_ex13, "커피베이",R.drawable.coupon_detail_ex14, "커피나무",R.drawable.coupon_detail_ex15, "드롭탑", R.drawable.coupon_detail_ex16, "빈스빈스");
        adapter.addItem(data);
        data = new Coupon_ListData(R.drawable.coupon_detail_ex17, "토프레소",R.drawable.coupon_detail_ex18, "더카페",R.drawable.coupon_detail_ex19, "커피에반하다", R.drawable.coupon_detail_ex20, "커피명가");
        adapter.addItem(data);
        data = new Coupon_ListData(R.drawable.coupon_detail_ex21, "주커피",R.drawable.coupon_detail_ex22, "커피마마",R.drawable.coupon_detail_ex23, "달콤커피", R.drawable.coupon_detail_ex24, "커피스미스");
        adapter.addItem(data);
        data = new Coupon_ListData(R.drawable.coupon_detail_ex25, "그라찌에",R.drawable.coupon_detail_ex26, "카페띠아모",R.drawable.coupon_detail_ex27, "카페보니또", R.drawable.coupon_detail_ex28, "카페아모제");
        adapter.addItem(data);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
