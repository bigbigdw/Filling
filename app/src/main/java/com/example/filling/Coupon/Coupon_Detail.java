package com.example.filling.Coupon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.filling.Dongmu.Dongmu_Detail;
import com.example.filling.Dongmu.Dongmu_Detail_Tab1;
import com.example.filling.Dongmu.Dongmu_Detail_Tab2;
import com.example.filling.Dongmu.Dongmu_Detail_Tab3;
import com.example.filling.Login.Login;
import com.example.filling.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coupon_Detail extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Coupon_MarketAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupon_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        init();
        getData();
    }

    private void init(){
        RecyclerView recyclerView = findViewById(R.id.Coupon_Item_List);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Coupon_MarketAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData(){
        Coupon_MarketData data = new Coupon_MarketData(R.drawable.mycoupon_ex11, R.drawable.mycoupon_ex12,"플레인 요거트", "매머드커피","4,500원", "블루베리 요거트", "매머드커피", "4,800원");
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        Coupon_Detail.ViewPagerAdapter adapter = new Coupon_Detail.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Coupon_Detail_Tab1(), "유효기간");
        adapter.addFragment(new Coupon_Detail_Tab2(), "구매취소");
        adapter.addFragment(new Coupon_Detail_Tab3(), "환불 규정");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public void onClickPurchase(View v) {
        Toast.makeText(getApplicationContext(), "결제화면으로 이동합니다", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Coupon_Purchase.class);
        startActivity(intent);
    }

}

