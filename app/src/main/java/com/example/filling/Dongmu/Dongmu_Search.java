package com.example.filling.Dongmu;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import com.example.filling.Bottom.Dongmu.Dongmu_Main_List;
import com.example.filling.Bottom.Dongmu.Dongmu_Main_ListItem;
import com.example.filling.R;

import java.util.ArrayList;
import java.util.Objects;

public class Dongmu_Search extends AppCompatActivity {

    ListView listView;
    Dongmu_Search.DongmuSearchAdapter adapter;
    EditText DongmuSearchText;
    LinearLayout SearchResult;
    NestedScrollView DongmuSearchScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dongmu_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.Dongmu_List);
        adapter = new Dongmu_Search.DongmuSearchAdapter();
        adapter.addItem(new Dongmu_Main_ListItem(R.drawable.dongmu_food_ex01, R.drawable.dongmu_icon_tag01, R.drawable.dongmu_icon_tag02, R.drawable.dongmu_icon_tag03, R.drawable.dongmu_icon_tag04, "맛집", "35M", "더차이나", "#맛있음", "#그럭저럭", "짱깨", "#짱꼴라"));
        adapter.addItem(new Dongmu_Main_ListItem(R.drawable.dongmu_food_ex01, R.drawable.dongmu_icon_tag01, R.drawable.dongmu_icon_tag02, R.drawable.dongmu_icon_tag03, R.drawable.dongmu_icon_tag04, "갈비집", "140M", "가산 북촌삼대갈비", "#생갈비의", "#맛을", "#느껴", "#보아라"));
        adapter.addItem(new Dongmu_Main_ListItem(R.drawable.dongmu_food_ex01, R.drawable.dongmu_icon_tag01, R.drawable.dongmu_icon_tag02, R.drawable.dongmu_icon_tag03, R.drawable.dongmu_icon_tag04, "술집", "1.2KM", "포차천국", "#4차", "#까지", "#준비되어", "#있어"));
        adapter.addItem(new Dongmu_Main_ListItem(R.drawable.dongmu_food_ex01, R.drawable.dongmu_icon_tag01, R.drawable.dongmu_icon_tag02, R.drawable.dongmu_icon_tag03, R.drawable.dongmu_icon_tag04, "술집", "400M", "비어킹", "#맨날", "#가는데도", "#안질리냐", "#팍씨"));
        adapter.addItem(new Dongmu_Main_ListItem(R.drawable.dongmu_food_ex01, R.drawable.dongmu_icon_tag01, R.drawable.dongmu_icon_tag02, R.drawable.dongmu_icon_tag03, R.drawable.dongmu_icon_tag04, "식당", "70M", "대두순두부", "#나는", "#맛있던데", "#왜", "#아무도 안가지"));
        adapter.addItem(new Dongmu_Main_ListItem(R.drawable.dongmu_food_ex01, R.drawable.dongmu_icon_tag01, R.drawable.dongmu_icon_tag02, R.drawable.dongmu_icon_tag03, R.drawable.dongmu_icon_tag04, "맛집", "35M", "더차이나", "#맛있음", "#그럭저럭", "짱깨", "#짱꼴라"));
        adapter.addItem(new Dongmu_Main_ListItem(R.drawable.dongmu_food_ex01, R.drawable.dongmu_icon_tag01, R.drawable.dongmu_icon_tag02, R.drawable.dongmu_icon_tag03, R.drawable.dongmu_icon_tag04, "갈비집", "140M", "가산 북촌삼대갈비", "#생갈비의", "#맛을", "#느껴", "#보아라"));

        listView.setAdapter(adapter);

        DongmuSearchText = findViewById(R.id.DongmuSearchText);
        SearchResult = findViewById(R.id.SearchResult);
        DongmuSearchScroll = findViewById(R.id.DongmuSearchScroll);

        DongmuSearchText.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(DongmuSearchText.getWindowToken(), 0);
                SearchResult.setVisibility(View.VISIBLE);
                DongmuSearchScroll.setVisibility(View.GONE);
                return true;
            }
            return false;
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {//toolbar의 back키 눌렀을 때 동작
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class DongmuSearchAdapter extends BaseAdapter {
        ArrayList<Dongmu_Main_ListItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Dongmu_Main_ListItem item) {
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
            Dongmu_Main_List view = new Dongmu_Main_List(getApplicationContext());

            Dongmu_Main_ListItem item = items.get(position);
            view.setFoodImgresId(item.getFoodImgresId());
            view.setImgTag1resId(item.getImgTag1resId());
            view.setImgTag2resId(item.getImgTag2resId());
            view.setImgTag3resId(item.getImgTag3resId());
            view.setImgTag4resId(item.getImgTag4resId());

            view.setCategory(item.getCategory());
            view.setDistance(item.getDistance());
            view.setTitle(item.getTitle());
            view.setTag1(item.getTag1());
            view.setTag2(item.getTag2());
            view.setTag3(item.getTag3());
            view.setTag4(item.getTag4());
            return view;
        }
    }

}
