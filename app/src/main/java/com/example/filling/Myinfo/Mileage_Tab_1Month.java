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

public class Mileage_Tab_1Month extends Fragment {

    ListView listView;
    Mileage_Tab_1Month.SingerAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mileagereport_tab, container, false);

        listView = root.findViewById(R.id.Report_List);
        adapter = new Mileage_Tab_1Month.SingerAdapter();
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
