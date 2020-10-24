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
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "카라멜 마끼야또", "2020.11.06", R.drawable.mycoupon_ex87));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "리얼레몬티", "2020.11.02", R.drawable.mycoupon_ex05));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "쿠앤크 프라페", "2020.10.24", R.drawable.mycoupon_ex16));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "레몬앤오렌지", "2020.10.10", R.drawable.mycoupon_ex02));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "솜사탕 쉐이크", "2020.09.03", R.drawable.mycoupon_ex15));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "카푸치노", "2020.08.13", R.drawable.mycoupon_ex82));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "매머드커피", "2020.07.10", R.drawable.mycoupon_ex91));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "플레인 요거트", "2020.06.17", R.drawable.mycoupon_ex11));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "자바칩 프라페", "2020.05.26", R.drawable.mycoupon_ex17));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "아몬드 아메리카노", "2020.05.13", R.drawable.mycoupon_ex85));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "페퍼민트 라임티", "2020.04.06", R.drawable.mycoupon_ex07));

        adapter.addItem(new MyCoupon_ListItem("매머드커피", "카페라떼", "2020.04.05", R.drawable.mycoupon_ex81));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "스트로베리 프라페", "2020.03.10", R.drawable.mycoupon_ex19));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "페퍼민트", "2020.02.10", R.drawable.mycoupon_ex04));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "카페모카", "2020.01.18", R.drawable.mycoupon_ex82));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "자바칩 프라페", "2020.01.05", R.drawable.mycoupon_ex17));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "캐모마일", "2019.12.24", R.drawable.mycoupon_ex03));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "딸기스무디", "2019.12.18", R.drawable.mycoupon_ex09));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "복숭아 요거트", "2019.12.10", R.drawable.mycoupon_ex14));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "밀크티", "2019.12.02", R.drawable.mycoupon_ex05));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "쿠앤크 프라페", "2018.11.30", R.drawable.mycoupon_ex15));
        adapter.addItem(new MyCoupon_ListItem("매머드커피", "블루베리 요거트", "2018.11.16", R.drawable.mycoupon_ex12));
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
