package com.example.filling.Bottom.Filling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.filling.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.Objects;

public class Bottom_FillingFragment extends Fragment {

    private Bottom_FillingViewModel Bottom_FillingViewModel;

    ListView listView;
    SingerAdapter adapter;

    CarouselView filling_carousel;
    int[] sampleImages = {R.drawable.filling_ad01, R.drawable.filling_ad02, R.drawable.filling_ad03};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.bottom_filling, container, false);

        filling_carousel = root.findViewById(R.id.filling_carousel);
        filling_carousel.setPageCount(sampleImages.length);
        filling_carousel.setImageListener(imageListener);

        listView = root.findViewById(R.id.filling_list);
        adapter = new SingerAdapter();
        adapter.addItem(new Bottom_Filling_ListItem("[공지] 개인정보 열람 및 수정에 대한 안내", "20.03.10"));
        adapter.addItem(new Bottom_Filling_ListItem("[당첨자 발표] Summer Festival 8월 쿠폰 당첨자 발표 (1차)", "20.04.06"));
        adapter.addItem(new Bottom_Filling_ListItem("[안내] 3/27 화, (구) 단체 ID 서비스가 종료됨을 알려드립니다.", "20.09.03"));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Bottom_Filling_ListItem item = (Bottom_Filling_ListItem) adapter.getItem(position);
                Toast.makeText(requireContext().getApplicationContext(), "선택 : " + item.getContents(), Toast.LENGTH_SHORT).show();
            }
        });

        return root;

    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<Bottom_Filling_ListItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Bottom_Filling_ListItem item) {
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
            Bottom_Filling_List view = new Bottom_Filling_List(requireContext().getApplicationContext());

            Bottom_Filling_ListItem item = items.get(position);
            view.setContents(item.getContents());
            view.setDate(item.getDate());

            return view;
        }
    }


    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}