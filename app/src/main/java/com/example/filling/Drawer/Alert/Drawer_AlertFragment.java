package com.example.filling.Drawer.Alert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        adapter.addItem(new Drawer_Alert_ListItem("[공지] 개인정보 열람 및 수정에 대한 안내", "20.03.10"));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Drawer_Alert_ListItem item = (Drawer_Alert_ListItem) adapter.getItem(position);
                Toast.makeText(requireContext().getApplicationContext(), "선택 : " + item.getContents(), Toast.LENGTH_SHORT).show();
            }
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

