package com.example.filling.Dongmu;

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

public class Dongmu_Detail_Tab3 extends Fragment {

    ListView listView;
    Dongmu_Detail_Tab3.DongmuDetailAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dongmu_detail_tab3, container, false);

        listView = root.findViewById(R.id.Donngmu_List);
        adapter = new Dongmu_Detail_Tab3.DongmuDetailAdapter();
        adapter.addItem(new Dongmu_Detail_ListItem(R.drawable.dongmu_detail_member01, "김","100***@na","2018.07.28 01:48","12번 허리 30인치인데 무슨 사이즈 입어야 하나요?"));
        adapter.addItem(new Dongmu_Detail_ListItem(R.drawable.dongmu_detail_member01, "정","whr***@ha","2018.07.28 01:43","주문했습니다 하자없는 상품 부탁드립니다."));
        adapter.addItem(new Dongmu_Detail_ListItem(R.drawable.dongmu_detail_member01, "유","100***@na","2018.07.28 01:48","12번 허리 30인치인데 무슨 사이즈 입어야 하나요?"));
        adapter.addItem(new Dongmu_Detail_ListItem(R.drawable.dongmu_detail_member01, "김","whr***@ha","2018.07.28 01:43","주문했습니다 하자없는 상품 부탁드립니다."));
        adapter.addItem(new Dongmu_Detail_ListItem(R.drawable.dongmu_detail_member01, "진","100***@na","2018.07.28 01:48","12번 허리 30인치인데 무슨 사이즈 입어야 하나요?"));
        adapter.addItem(new Dongmu_Detail_ListItem(R.drawable.dongmu_detail_member01, "최","whr***@ha","2018.07.28 01:43","주문했습니다 하자없는 상품 부탁드립니다."));
        adapter.addItem(new Dongmu_Detail_ListItem(R.drawable.dongmu_detail_member01, "현","100***@na","2018.07.28 01:48","12번 허리 30인치인데 무슨 사이즈 입어야 하나요?"));
        adapter.addItem(new Dongmu_Detail_ListItem(R.drawable.dongmu_detail_member01, "박","whr***@ha","2018.07.28 01:43","주문했습니다 하자없는 상품 부탁드립니다."));
        adapter.addItem(new Dongmu_Detail_ListItem(R.drawable.dongmu_detail_member01, "김","100***@na","2018.07.28 01:48","12번 허리 30인치인데 무슨 사이즈 입어야 하나요?"));
        adapter.addItem(new Dongmu_Detail_ListItem(R.drawable.dongmu_detail_member01, "유","whr***@ha","2018.07.28 01:43","주문했습니다 하자없는 상품 부탁드립니다."));
        listView.setAdapter(adapter);

        return root;
    }

    class DongmuDetailAdapter extends BaseAdapter {
        ArrayList<Dongmu_Detail_ListItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Dongmu_Detail_ListItem item) {
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
            Dongmu_Detail_List view = new Dongmu_Detail_List(requireContext().getApplicationContext());

            Dongmu_Detail_ListItem item = items.get(position);
            view.setImgNameId(item.getImgNameId());
            view.setName(item.getName());
            view.setDate(item.getDate());
            view.setText(item.getText());
            view.setID(item.getID());
            return view;
        }
    }

}
