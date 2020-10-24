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

public class Mileage_Tab_All extends Fragment {

    ListView listView;
    Mileage_Tab_All.SingerAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mileagereport_tab, container, false);

        listView = root.findViewById(R.id.Report_List);
        adapter = new Mileage_Tab_All.SingerAdapter();
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.10.24", "+ 1045", "14,952,000",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("Cash 충전-마일리지", "20.10.22", "- 2032", "14,950,955", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.10.20", "+ 3025", "14,952,987",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.10.19", "+ 452", "14,952,535",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.10.18", "+ 1515", "14,951,020",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("마일리지 결제", "20.10.16", "- 1524", "14,952,544", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("마일리지 결제", "20.10.14", "- 8326", "14,960,870", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.10.10", "+ 4058", "14,956,812",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.10.04", "+ 4603", "14,952,209",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("Cash 충전-마일리지", "20.10.02", "- 823", "14,953,032", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("Cash 충전-마일리지", "20.09.28", "- 993", "14,952,039", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("마일리지 결제", "20.09.25", "- 814", "14,952,853", R.drawable.icon_report_minus));

        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.09.23", "+ 6245", "14,946,608",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("Cash 충전-마일리지", "20.09.22", "- 542", "14,947,150", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.09.16", "+ 612", "14,946,538",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.09.11", "+ 541", "14,945,997",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.09.07", "+ 563", "14,945,434",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("Cash 충전-마일리지", "20.09.01", "- 812", "114,946,246", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.08.28", "+ 1465", "14,944,781",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("마일리지 결제", "20.08.17", "- 1561", "14,946,342", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("마일리지 결제", "20.08.09", "- 1326", "14,947,668", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.08.02", "+ 4603", "14,943,065",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("Cash 충전-마일리지", "20.08.01", "- 823", "14,943,888", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("마일리지 결제", "20.07.25", "- 814", "14,944,702", R.drawable.icon_report_minus));

        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.07.23", "+ 1263", "14,943,439",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("마일리지 결제", "20.07.16", "- 652", "14,944,091", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.07.02", "+ 323", "14,944,414",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.05.26", "+ 6233", "14,950,647",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("Cash 충전-마일리지", "20.05.15", "- 5823", "14,956,470", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.05.07", "+ 4555", "14,951,915",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.04.16", "+ 562", "14,951,353",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("Cash 충전-마일리지", "20.04.14", "- 922", "14,952,275", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("모바일 상품권 구매", "20.04.06", "+ 9266", "14,943,009",R.drawable.icon_report_plus));
        adapter.addItem(new MileageReport_ListItem("마일리지 결제", "20.03.16", "- 1632", "14,944,641", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("Cash 충전-마일리지", "20.03.10", "- 653", "14,945,294", R.drawable.icon_report_minus));
        adapter.addItem(new MileageReport_ListItem("마일리지 결제", "20.02.25", "- 6123", "14,951,417", R.drawable.icon_report_minus));
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