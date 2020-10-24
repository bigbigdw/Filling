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

public class CashReport_Tab_3Month extends Fragment {

    ListView listView;
    CashReport_Tab_3Month.SingerAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.cashreport_tab, container, false);

        listView = root.findViewById(R.id.Report_List);
        adapter = new CashReport_Tab_3Month.SingerAdapter();
        adapter.addItem(new CashReport_ListItem("Cash충전", "20.10.24", "+ 10", "12,325",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("Cash선물 수령", "20.10.22", "+ 9", "12,315",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("Cash충전", "20.10.19", "+ 12", "12,303",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("Cash결제", "20.10.18", "- 8", "12,311",R.drawable.icon_report_minus));
        adapter.addItem(new CashReport_ListItem("Cash선물 전송", "20.10.16", "+ 17", "12,294",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("Cash결제", "20.10.14", "- 15", "12,309",R.drawable.icon_report_minus));
        adapter.addItem(new CashReport_ListItem("Cash결제", "20.10.14", "- 25", "12,334",R.drawable.icon_report_minus));
        adapter.addItem(new CashReport_ListItem("Cash충전", "20.10.16", "+ 22", "12,356",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("Cash결제", "20.10.14", "- 4", "12,360",R.drawable.icon_report_minus));
        adapter.addItem(new CashReport_ListItem("Cash선물 수령", "20.10.08", "+ 25", "12,335",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("Cash결제", "20.10.06", "- 14", "12,349",R.drawable.icon_report_minus));
        adapter.addItem(new CashReport_ListItem("Cash선물 전송", "20.10.02", "- 16", "12,365",R.drawable.icon_report_minus));

        adapter.addItem(new CashReport_ListItem("Cash충전", "20.09.28", "+ 16", "12,349",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("Cash선물 수령", "20.09.21", "+ 13", "12,336",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("Cash충전", "20.09.17", "+ 26", "12,310",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("Cash결제", "20.09.06", "- 13", "12,323",R.drawable.icon_report_minus));
        adapter.addItem(new CashReport_ListItem("Cash선물 전송", "20.09.04", "+ 21", "12,302",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("Cash결제", "20.09.01", "- 13", "12,315",R.drawable.icon_report_minus));
        adapter.addItem(new CashReport_ListItem("Cash결제", "20.08.30", "- 16", "12,331",R.drawable.icon_report_minus));
        adapter.addItem(new CashReport_ListItem("Cash충전", "20.08.21", "+ 24", "12,307",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("Cash결제", "20.08.16", "- 17", "12,324",R.drawable.icon_report_minus));
        adapter.addItem(new CashReport_ListItem("Cash결제", "20.08.14", "- 8", "12,332",R.drawable.icon_report_minus));
        adapter.addItem(new CashReport_ListItem("Cash선물 수령", "20.08.08", "+ 5", "12,327",R.drawable.icon_report_plus));
        adapter.addItem(new CashReport_ListItem("Cash선물 전송", "20.07.25", "- 17", "12,344",R.drawable.icon_report_minus));
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

