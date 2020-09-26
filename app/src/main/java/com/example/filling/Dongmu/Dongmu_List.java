package com.example.filling.Dongmu;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.filling.Bottom.Dongmu.Dongmu_Bottom_List;
import com.example.filling.Bottom.Dongmu.Dongmu_Bottom_ListItem;
import com.example.filling.R;

import java.util.ArrayList;
import java.util.Objects;


public class Dongmu_List extends AppCompatActivity {

    HorizontalScrollView ScrollBefore;
    TableLayout ScrollAfter;
    ListView listView;
    Dongmu_List.DongmuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dongmu_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.Dongmu_Bottom_List);
        adapter = new Dongmu_List.DongmuAdapter();
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_red, R.drawable.dongmu_bottomlist_donation_on, R.drawable.dongmu_bottomlist_present_on, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_red, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_on, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_off, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_off, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_red, R.drawable.dongmu_bottomlist_donation_on, R.drawable.dongmu_bottomlist_present_on, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_red, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_on, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_off, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_off, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        listView.setAdapter(adapter);

        ScrollBefore = findViewById(R.id.ScrollBefore);
        ScrollAfter = findViewById(R.id.ScrollAfter);
    }

    class DongmuAdapter extends BaseAdapter {
        ArrayList<Dongmu_Bottom_ListItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Dongmu_Bottom_ListItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            Dongmu_Bottom_List view = new Dongmu_Bottom_List(getApplicationContext());

            Dongmu_Bottom_ListItem item = items.get(position);
            view.setFoodImgresId(item.getFoodImgresId());
            view.setImgTag1resId(item.getImgTag1resId());
            view.setImgTag2resId(item.getImgTag2resId());
            view.setImgTag3resId(item.getImgTag3resId());
            view.setImgTag4resId(item.getImgTag4resId());

            view.setCategory(item.getCategory());
            view.setDistance(item.getDistance());
            view.setTitle(item.getTitle());
            view.setLocation(item.getLocation());
            return view;
        }
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
