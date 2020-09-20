package com.example.filling.Bottom.Dongmu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.filling.R;

import java.util.ArrayList;

public class Dongmu_Main_Tab2 extends Fragment {

    ListView listView;
    Dongmu_Main_Tab2.AlertAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dongmu_main_tab, container, false);

        listView = root.findViewById(R.id.Dongmu_List);
        adapter = new Dongmu_Main_Tab2.AlertAdapter();
        adapter.addItem(new Dongmu_Main_ListItem(R.drawable.dongmu_food_ex01, R.drawable.dongmu_icon_tag01, R.drawable.dongmu_icon_tag02, R.drawable.dongmu_icon_tag03, R.drawable.dongmu_icon_tag04, "맛집", "35M", "더차이나", "#맛있음", "#그럭저럭", "짱깨", "#짱꼴라"));
        adapter.addItem(new Dongmu_Main_ListItem(R.drawable.dongmu_food_ex01, R.drawable.dongmu_icon_tag01, R.drawable.dongmu_icon_tag02, R.drawable.dongmu_icon_tag03, R.drawable.dongmu_icon_tag04, "갈비집", "140M", "가산 북촌삼대갈비", "#생갈비의", "#맛을", "#느껴", "#보아라"));
        adapter.addItem(new Dongmu_Main_ListItem(R.drawable.dongmu_food_ex01, R.drawable.dongmu_icon_tag01, R.drawable.dongmu_icon_tag02, R.drawable.dongmu_icon_tag03, R.drawable.dongmu_icon_tag04, "술집", "1.2KM", "포차천국", "#4차", "#까지", "#준비되어", "#있어"));
        adapter.addItem(new Dongmu_Main_ListItem(R.drawable.dongmu_food_ex01, R.drawable.dongmu_icon_tag01, R.drawable.dongmu_icon_tag02, R.drawable.dongmu_icon_tag03, R.drawable.dongmu_icon_tag04, "술집", "400M", "비어킹", "#맨날", "#가는데도", "#안질리냐", "#팍씨"));
        adapter.addItem(new Dongmu_Main_ListItem(R.drawable.dongmu_food_ex01, R.drawable.dongmu_icon_tag01, R.drawable.dongmu_icon_tag02, R.drawable.dongmu_icon_tag03, R.drawable.dongmu_icon_tag04, "식당", "70M", "대두순두부", "#나는", "#맛있던데", "#왜", "#아무도 안가지"));

        listView.setAdapter(adapter);

        return root;
    }

    class AlertAdapter extends BaseAdapter {
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
            Dongmu_Main_List view = new Dongmu_Main_List(requireContext().getApplicationContext());

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