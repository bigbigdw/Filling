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
import androidx.fragment.app.Fragment;

import com.example.filling.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class Bottom_FillingFragment extends Fragment {

    private Bottom_FillingViewModel Bottom_FillingViewModel;

    //    static final String[] LIST_MENU = {"LIST11", "LIST21", "LIST31"} ;
    ListView listView;
    SingerAdapter adapter;

    CarouselView filling_carousel;
    int[] sampleImages = {R.drawable.filling_ad01, R.drawable.filling_ad02, R.drawable.filling_ad03};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.bottom_filling, container, false);

        filling_carousel = (CarouselView) root.findViewById(R.id.filling_carousel);
        filling_carousel.setPageCount(sampleImages.length);
        filling_carousel.setImageListener(imageListener);

//        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, LIST_MENU) ;
//        ListView listview = (ListView) root.findViewById(R.id.filling_list) ;
//        listview.setAdapter(adapter) ;

        listView = (ListView) root.findViewById(R.id.filling_list);

        adapter = new SingerAdapter();

        adapter.addItem(new Bottom_Filling_ListItem("소녀시대", "010-1000-1000", 20, R.drawable.filling_ad01));
        adapter.addItem(new Bottom_Filling_ListItem("걸스데이", "010-2000-2000", 22, R.drawable.filling_ad03));
        adapter.addItem(new Bottom_Filling_ListItem("여자친구", "010-3000-3000", 21, R.drawable.filling_ad02));
        adapter.addItem(new Bottom_Filling_ListItem("티아라", "010-4000-4000", 24, R.drawable.filling_ad03));
        adapter.addItem(new Bottom_Filling_ListItem("AOA", "010-5000-5000", 25, R.drawable.filling_ad03));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Bottom_Filling_ListItem item = (Bottom_Filling_ListItem) adapter.getItem(position);
                Toast.makeText(getContext().getApplicationContext(), "선택 : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        return root;

    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<Bottom_Filling_ListItem> items = new ArrayList<Bottom_Filling_ListItem>();

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
            Bottom_Filling_List view = new Bottom_Filling_List(getContext().getApplicationContext());

            Bottom_Filling_ListItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setAge(item.getAge());
            view.setImage(item.getResId());

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