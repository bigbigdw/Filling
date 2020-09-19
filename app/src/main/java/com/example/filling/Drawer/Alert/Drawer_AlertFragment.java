package com.example.filling.Drawer.Alert;

import android.content.Intent;
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

public class Drawer_AlertFragment extends Fragment {

    ListView listView;
    AlertAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.drawer_alert, container, false);

        listView = root.findViewById(R.id.Alert_List);
        adapter = new AlertAdapter();
        adapter.addItem(new Drawer_Alert_ListItem("[공지] 더필홀딩스 서비스공지", "20.02.25"));
        adapter.addItem(new Drawer_Alert_ListItem("[안내] 3/27(화), (구)단체ID 서비스가 종료됨을 알려드립니...", "20.03.06"));
        adapter.addItem(new Drawer_Alert_ListItem("[공지] 개인정보 열람 및 수정에 대한 안내", "20.03.10"));
        adapter.addItem(new Drawer_Alert_ListItem("[당첨자발표] Summer Festival 8월 쿠폰증정 당첨자 ....", "20.04.06"));
        adapter.addItem(new Drawer_Alert_ListItem("[안내] 사용되지 않는 (구)단체 아이디 정리에 대한 안내", "20.09.03"));
        adapter.addItem(new Drawer_Alert_ListItem("[공지] 채용관련 보이스피싱 등 금융사고 등에 주의 부탁드...", "20.11.02"));
        adapter.addItem(new Drawer_Alert_ListItem("[공지] 전시스템 정비 작업", "20.12.02"));
        adapter.addItem(new Drawer_Alert_ListItem("[공지] 전시스템 정비 작업", "20.09.03"));
        adapter.addItem(new Drawer_Alert_ListItem("[공지] 더필홀딩스 서비스공지", "1902.25"));
        adapter.addItem(new Drawer_Alert_ListItem("[안내] 3/27(화), (구)단체ID 서비스가 종료됨을 알려드립니...", "19.03.06"));
        adapter.addItem(new Drawer_Alert_ListItem("[공지] 개인정보 열람 및 수정에 대한 안내", "19.03.10"));
        adapter.addItem(new Drawer_Alert_ListItem("[당첨자발표] Summer Festival 8월 쿠폰증정 당첨자 ....", "19.04.06"));
        adapter.addItem(new Drawer_Alert_ListItem("[안내] 사용되지 않는 (구)단체 아이디 정리에 대한 안내", "19.09.03"));
        adapter.addItem(new Drawer_Alert_ListItem("[공지] 채용관련 보이스피싱 등 금융사고 등에 주의 부탁드...", "19.11.02"));
        adapter.addItem(new Drawer_Alert_ListItem("[공지] 전시스템 정비 작업", "19.12.02"));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
//                Drawer_Alert_ListItem item = (Drawer_Alert_ListItem) adapter.getItem(position);
//                Toast.makeText(requireContext().getApplicationContext(), "선택 : " + item.getContents(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireContext().getApplicationContext(), Alert_Detail.class);
            startActivity(intent);
        });

        return root;

    }

    class AlertAdapter extends BaseAdapter {
        ArrayList<Drawer_Alert_ListItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Drawer_Alert_ListItem item) {
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
            Drawer_Alert_List view = new Drawer_Alert_List(requireContext().getApplicationContext());

            Drawer_Alert_ListItem item = items.get(position);
            view.setContents(item.getContents());
            view.setDate(item.getDate());

            return view;
        }
    }

}

