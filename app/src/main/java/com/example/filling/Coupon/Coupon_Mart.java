package com.example.filling.Coupon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.R;

import java.util.Objects;

public class Coupon_Mart extends AppCompatActivity {
    Coupon_MarketAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupon_mart);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        init();
        getData();
    }

    private void init(){
        RecyclerView recyclerView = findViewById(R.id.Coupon_Item_List);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Coupon_MarketAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData(){
        Coupon_MarketData data = new Coupon_MarketData(R.drawable.mycoupon_ex91, R.drawable.mycoupon_ex92,"매머드커피", "매머드커피","4,000원", "스노우 매머드커피", "매머드커피", "4,800원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex80, R.drawable.mycoupon_ex81,"아메리카노", "매머드커피","2,500원", "카페라떼", "매머드커피", "3,100원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex82, R.drawable.mycoupon_ex83,"카푸치노", "매머드커피","3,100원", "카페모카", "매머드커피", "3,400원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex84, R.drawable.mycoupon_ex85,"바닐라라떼", "매머드커피","3,400원", "아몬드 아메리카노", "매머드커피", "2,800원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex86, R.drawable.mycoupon_ex87,"아몬드라떼", "매머드커피","3,400원", "카라멜 마끼야또", "매머드커피", "3,700원");
        adapter.addItem(data);

        data = new Coupon_MarketData(R.drawable.mycoupon_ex01, R.drawable.mycoupon_ex02,"얼그레이", "매머드커피","3,400원", "레몬앤오렌지", "매머드커피", "3,700원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex03, R.drawable.mycoupon_ex04,"캐모마일", "매머드커피","3,400원", "페퍼민트", "매머드커피", "3,700원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex05, R.drawable.mycoupon_ex06,"밀크티", "매머드커피","4,000원", "리얼레몬티", "매머드커피", "3,700원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex07, R.drawable.mycoupon_ex08,"페퍼민트 라임티", "매머드커피","4,300원", "오렌지 아일랜드 티", "매머드커피", "3,700원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex09, R.drawable.mycoupon_ex10,"딸기스무디", "매머드커피","4,500원", "복숭아스무디", "매머드커피", "4,500원");
        adapter.addItem(data);

        data = new Coupon_MarketData(R.drawable.mycoupon_ex11, R.drawable.mycoupon_ex12,"플레인 요거트", "매머드커피","4,500원", "블루베리 요거트", "매머드커피", "4,800원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex13, R.drawable.mycoupon_ex14,"딸기 요거트", "매머드커피","4,800원", "복숭아 요거트", "매머드커피", "4,800원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex15, R.drawable.mycoupon_ex16,"솜사탕 쉐이크", "매머드커피","3,900원", "쿠앤크 프라페", "매머드커피", "4,800원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex17, R.drawable.mycoupon_ex18,"자바칩 프라페", "매머드커피","4,800원", "그린티 프라페", "매머드커피", "4,800원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex19, R.drawable.mycoupon_ex20,"스트로베리 프라페", "매머드커피","4,800원", "피스타치오 프라페", "매머드커피", "3,700원");
        adapter.addItem(data);
    }

    public void onClickCouponDetail(View v) {
        Intent intent = new Intent(getApplicationContext(), Coupon_Detail.class);
        startActivity(intent);
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
