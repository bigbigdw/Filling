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

public class CashReport_Tab extends Fragment {

    ListView listView;
    CashReport_Tab.SingerAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.cashreport_tab, container, false);

        listView = root.findViewById(R.id.Report_List);
        adapter = new CashReport_Tab.SingerAdapter();
        adapter.addItem(new MileageReport_ListItem("Cash충전", "20.03.10", "+ 1080", "20215151",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("Cash결제", "20.03.10", "- 1080", "20215151",R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("Cash충전", "20.03.10", "+ 1080", "20215151",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("Cash결제", "20.03.10", "- 1080", "20215151",R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("Cash충전", "20.03.10", "+ 1080", "20215151",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("Cash결제", "20.03.10", "- 1080", "20215151",R.drawable.icon_report_minus));
        listView.setAdapter(adapter);

        return root;
    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<MileageReport_ListItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(MileageReport_ListItem item) {
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
            MileageReport_List view = new MileageReport_List(requireContext().getApplicationContext());

            MileageReport_ListItem item = items.get(position);
            view.setName(item.getName());
            view.setDate(item.getDate());
            view.setCount(item.getCount());
            view.setRest(item.getRest());
            view.setImgID(item.getImgID());

            return view;
        }
    }

}

