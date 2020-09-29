package com.example.filling.Myinfo;

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

public class Mileage_Tab extends Fragment {

    ListView listView;
    Mileage_Tab.SingerAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mileagereport_tab, container, false);

        listView = root.findViewById(R.id.Report_List);
        adapter = new Mileage_Tab.SingerAdapter();
        adapter.addItem(new CashReport_ListItem("마일리지 충전", "20.03.10", "+ 1080", "20215151",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("마일리지 결제", "20.03.10", "- 1080", "20215151", R.drawable.icon_report_minus));
        adapter.addItem(new CashReport_ListItem("마일리지 충전", "20.03.10", "+ 1080", "20215151",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("마일리지 결제", "20.03.10", "- 1080", "20215151", R.drawable.icon_report_minus));
        adapter.addItem(new CashReport_ListItem("마일리지 충전", "20.03.10", "+ 1080", "20215151",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("마일리지 결제", "20.03.10", "- 1080", "20215151", R.drawable.icon_report_minus));
        listView.setAdapter(adapter);

        return root;
    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<CashReport_ListItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(CashReport_ListItem item) {
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
            CashReport_List view = new CashReport_List(requireContext().getApplicationContext());

            CashReport_ListItem item = items.get(position);
            view.setName(item.getName());
            view.setDate(item.getDate());
            view.setCount(item.getCount());
            view.setRest(item.getRest());
            view.setImgID(item.getImgID());

            return view;
        }
    }

}