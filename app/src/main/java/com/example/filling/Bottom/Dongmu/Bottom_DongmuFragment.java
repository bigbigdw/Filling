package com.example.filling.Bottom.Dongmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.filling.Dongmu.Dongmu_Detail;
import com.example.filling.Dongmu.Dongmu_List;
import com.example.filling.Dongmu.Dongmu_Search;
import com.example.filling.Drawer.Alert.Alert_Detail;
import com.example.filling.R;
import com.example.filling.Test;
import com.google.android.material.tabs.TabLayout;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;

public class Bottom_DongmuFragment extends Fragment {

    ListView listView;
    Bottom_DongmuFragment.DongmuAdapter adapter;

    HorizontalScrollView ScrollBefore;
    TableLayout ScrollAfter;
    LinearLayout onClickUnfold, onClickFold, DongmuList01, DongmuSearch;

    CarouselView  Dongmu_Lower_carousel;

    EditText DongmuSearchText;

    int[] LowerImages = {R.drawable.dongmu_lower_ex01, R.drawable.dongmu_lower_ex01, R.drawable.dongmu_lower_ex01, R.drawable.dongmu_lower_ex01, R.drawable.dongmu_lower_ex01};
    String[] MarkText = {"단골 맛집", "술집", "고깃집", "밥집", "분식집"};
    String[] Title = {"꼬꼬치킨", "대두네 순두부", "제육볶음", "오리주물럭", "김바압천국"};
    String[] Comment = {"1562", "452", "4651", "489", "1465"};
    String[] Recommend = {"12", "626", "132", "151", "6262"};
    String[] Tag1 = {"#맛집", "#어제는", "#지금은", "#산은", "#보리차보다"};
    String[] Tag2 = {"#배고프다", "#치킨", "#배가", "#산이오", "#보아차가"};
    String[] Tag3 = {"#저녁", "#먹었는데", "#고픈지", "#물은", "#더별로"};
    String[] Tag4 = {"#뭐먹지", "#오늘또", "#안고픈지", "#물이다", "#인것같아"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.bottom_dongmu, container, false);

        listView = root.findViewById(R.id.Dongmu_Bottom_List);
        adapter = new Bottom_DongmuFragment.DongmuAdapter();
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_red, R.drawable.dongmu_bottomlist_donation_on, R.drawable.dongmu_bottomlist_present_on, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_red, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_on, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_off, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_off, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_red, R.drawable.dongmu_bottomlist_donation_on, R.drawable.dongmu_bottomlist_present_on, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_red, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_on, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_off, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_off, "맛집", "35M", "더차이나", "서울특별시 강남구 테헤란로 1..."));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            Intent intent = new Intent(requireContext().getApplicationContext(), Dongmu_Detail.class);
            startActivity(intent);
        });

        Dongmu_Lower_carousel = root.findViewById(R.id.Dongmu_Lower_carousel);
        Dongmu_Lower_carousel.setPageCount(LowerImages.length);
        Dongmu_Lower_carousel.setViewListener(viewListener);

        Dongmu_Lower_carousel.setImageClickListener(position -> {
            Intent intent = new Intent(requireContext().getApplicationContext(), Dongmu_Detail.class);
            startActivity(intent);
        });

        ScrollBefore = root.findViewById(R.id.ScrollBefore);
        ScrollAfter = root.findViewById(R.id.ScrollAfter);
        onClickUnfold = root.findViewById(R.id.onClickUnfold);
        onClickUnfold.setOnClickListener(v -> {
            ScrollBefore.setVisibility(View.GONE);
            ScrollAfter.setVisibility(View.VISIBLE);
        });
        onClickFold = root.findViewById(R.id.onClickFold);
        onClickFold.setOnClickListener(v -> {
            ScrollAfter.setVisibility(View.GONE);
            ScrollBefore.setVisibility(View.VISIBLE);
        });
        DongmuList01 = root.findViewById(R.id.DongmuList01);
        DongmuList01.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext().getApplicationContext(), Dongmu_List.class);
            startActivity(intent);
        });

        DongmuSearch = root.findViewById(R.id.DongmuSearch);
        DongmuSearch.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext().getApplicationContext(), Dongmu_Search.class);
            startActivity(intent);
        });

        DongmuSearchText = root.findViewById(R.id.DongmuSearchText);
        DongmuSearchText.setClickable(false);
        DongmuSearchText.setFocusable(false);

        return root;
    }


    ViewListener viewListener = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {

            View customView = getLayoutInflater().inflate(R.layout.dongmu_main_lower_carousel, null);

            TextView Dongmu_Lower_MarkText = customView.findViewById(R.id.Dongmu_Lower_MarkText);
            TextView Dongmu_Lower_Comment = customView.findViewById(R.id.Dongmu_Lower_Comment);
            TextView Dongmu_Lower_Recommend = customView.findViewById(R.id.Dongmu_Lower_Recommend);
            TextView Dongmu_Lower_Title = customView.findViewById(R.id.Dongmu_Lower_Title);
            TextView Dongmu_Lower_Tag1 = customView.findViewById(R.id.Dongmu_Lower_Tag1);
            TextView Dongmu_Lower_Tag2 = customView.findViewById(R.id.Dongmu_Lower_Tag2);
            TextView Dongmu_Lower_Tag3 = customView.findViewById(R.id.Dongmu_Lower_Tag3);
            TextView Dongmu_Lower_Tag4 = customView.findViewById(R.id.Dongmu_Lower_Tag4);
            ImageView Images = customView.findViewById(R.id.Dongmu_Lower_Img);

            Images.setImageResource(LowerImages[position]);
            Dongmu_Lower_Title.setText(Title[position]);
            Dongmu_Lower_MarkText.setText(MarkText[position]);
            Dongmu_Lower_Comment.setText(Comment[position]);
            Dongmu_Lower_Recommend.setText(Recommend[position]);
            Dongmu_Lower_Tag1.setText(Tag1[position]);
            Dongmu_Lower_Tag2.setText(Tag2[position]);
            Dongmu_Lower_Tag3.setText(Tag3[position]);
            Dongmu_Lower_Tag4.setText(Tag4[position]);

            Dongmu_Lower_carousel.setIndicatorGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);

            return customView;
        }
    };

    class DongmuAdapter extends BaseAdapter {
        ArrayList<Dongmu_Bottom_ListItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Dongmu_Bottom_ListItem item) {
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
            Dongmu_Bottom_List view = new Dongmu_Bottom_List(requireContext().getApplicationContext());

            Dongmu_Bottom_ListItem item = items.get(position);
            view.setFoodImgresId(item.getFoodImgresId());
            view.setImgTag1resId(item.getImgTag1resId());
            view.setImgTag2resId(item.getImgTag2resId());
            view.setImgTag3resId(item.getImgTag3resId());
            view.setImgTag4resId(item.getImgTag4resId());

            view.setCategory(item.getCategory());
            view.setDistance(item.getDistance());
            view.setTitle(item.getTitle());
            view.setLocation(item.getLocation());
            return view;
        }
    }
}
