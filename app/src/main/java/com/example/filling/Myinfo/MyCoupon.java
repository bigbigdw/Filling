package com.example.filling.Myinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.filling.Drawer.Alert.Alert_Detail;
import com.example.filling.Main_Popup;
import com.example.filling.R;

import java.util.ArrayList;
import java.util.Objects;

public class MyCoupon extends AppCompatActivity {

    ListView listView;
    MyCouponAdapter adapter;
    private MyCoupon_Popup MyCoupon_Popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycoupon);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.Coupon_List);
        adapter = new MyCoupon.MyCouponAdapter();
        adapter.addItem(new MyCoupon_ListItem("스타벅스", "아이스 아메리카노 TALL", "2019.03.10", R.drawable.mycoupon_ex01));
        adapter.addItem(new MyCoupon_ListItem("스타벅스", "아이스 아메리카노 TALL", "2019.03.10", R.drawable.mycoupon_ex01));
        adapter.addItem(new MyCoupon_ListItem("스타벅스", "아이스 아메리카노 TALL", "2019.03.10", R.drawable.mycoupon_ex01));
        adapter.addItem(new MyCoupon_ListItem("스타벅스", "아이스 아메리카노 TALL", "2019.03.10", R.drawable.mycoupon_ex01));
        adapter.addItem(new MyCoupon_ListItem("스타벅스", "아이스 아메리카노 TALL", "2019.03.10", R.drawable.mycoupon_ex01));
        adapter.addItem(new MyCoupon_ListItem("스타벅스", "아이스 아메리카노 TALL", "2019.03.10", R.drawable.mycoupon_ex01));
        adapter.addItem(new MyCoupon_ListItem("스타벅스", "아이스 아메리카노 TALL", "2019.03.10", R.drawable.mycoupon_ex01));
        adapter.addItem(new MyCoupon_ListItem("스타벅스", "아이스 아메리카노 TALL", "2019.03.10", R.drawable.mycoupon_ex01));
        adapter.addItem(new MyCoupon_ListItem("스타벅스", "아이스 아메리카노 TALL", "2019.03.10", R.drawable.mycoupon_ex01));
        adapter.addItem(new MyCoupon_ListItem("스타벅스", "아이스 아메리카노 TALL", "2019.03.10", R.drawable.mycoupon_ex01));
        adapter.addItem(new MyCoupon_ListItem("스타벅스", "아이스 아메리카노 TALL", "2019.03.10", R.drawable.mycoupon_ex01));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            MyCoupon_Popup = new MyCoupon_Popup(this, negativeListener);
            MyCoupon_Popup.show();
        });
    }

    private View.OnClickListener negativeListener = new View.OnClickListener() {
        public void onClick(View v) {
            MyCoupon_Popup.dismiss();
        }
    };

    class MyCouponAdapter extends BaseAdapter {
        ArrayList<MyCoupon_ListItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(MyCoupon_ListItem item) {
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
            MyCoupon_List view = new MyCoupon_List(getApplicationContext());
            MyCoupon_ListItem item = items.get(position);

            view.setTitle(item.getTitle());
            view.setGoodsName(item.getGoodsName());
            view.setDate(item.getDate());
            view.setImageId(item.getImageId());
            return view;
        }
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
