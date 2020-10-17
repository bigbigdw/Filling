package com.example.filling.Dongmu;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;

public class Dongmu_Detail_Tab2 extends Fragment {

    Dongmu_Detail_MenuAdapter adapter;

    CarouselView Dongmu_Detail_carousel;
    int[] Menu1Image = {R.drawable.dongmu_detail_menu00, R.drawable.dongmu_detail_menu04, R.drawable.dongmu_detail_menu10};
    int[] Menu2Image = {R.drawable.dongmu_detail_menu07, R.drawable.dongmu_detail_menu06, R.drawable.dongmu_detail_menu07};
    int[] Menu3Image = {R.drawable.dongmu_detail_menu00, R.drawable.dongmu_detail_menu00, R.drawable.dongmu_detail_menu00};
    String[] MenuName1 = {"샤오롱빠오", "카페라떼", "카페라떼"};
    String[] MenuName2 = {"팬케이크", "팬케이크", "팬케이크"};
    String[] MenuName3 = {"티라미슈", "티라미슈", "티라미슈"};
    String[] MenuPrice1 = {"16,000원(10개)", "4500원", "4500원"};
    String[] MenuPrice2 = {"6500원", "6500원", "6500원"};
    String[] MenuPrice3 = {"6000원", "6000원", "6000원"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dongmu_detail_tab2, container, false);

        Dongmu_Detail_carousel = root.findViewById(R.id.Dongmu_Detail_carousel);
        Dongmu_Detail_carousel.setPageCount(Menu1Image.length);
        Dongmu_Detail_carousel.setViewListener(viewListener);


        RecyclerView recyclerView = root.findViewById(R.id.Dongmu_Detail_Menu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Dongmu_Detail_MenuAdapter();
        recyclerView.setAdapter(adapter);
        getData();

        return root;
    }


    private void getData(){
        Dongmu_Detail_MenuData data = new Dongmu_Detail_MenuData(R.drawable.dongmu_detail_menu00, R.drawable.dongmu_detail_menu01,"샤오롱빠오 샘플러", "16,000원(10개)","새우 샤오롱빠오", "16,000원(10개)");
        adapter.addItem(data);
        data = new Dongmu_Detail_MenuData(R.drawable.dongmu_detail_menu02, R.drawable.dongmu_detail_menu03,"닭고기 샤오롱빠오", "15,000원(10개)","새우 샤오마이", "16,000원(10개)");
        adapter.addItem(data);
        data = new Dongmu_Detail_MenuData(R.drawable.dongmu_detail_menu04, R.drawable.dongmu_detail_menu05,"매운 게살 샤오마이", "16,000원(10개)","새우 쩡자오", "15,000원(10개)");
        adapter.addItem(data);
        data = new Dongmu_Detail_MenuData(R.drawable.dongmu_detail_menu06, R.drawable.dongmu_detail_menu07,"야채 쩡자오", "14,000원(10개)","새우 군만두", "9,000원(6개)");
        adapter.addItem(data);
        data = new Dongmu_Detail_MenuData(R.drawable.dongmu_detail_menu08, R.drawable.dongmu_detail_menu09,"매운 게살따바오", "7,000원(2개)","고기따바오", "4,500원(2개)");
        adapter.addItem(data);

        data = new Dongmu_Detail_MenuData(R.drawable.dongmu_detail_menu10, R.drawable.dongmu_detail_menu11,"고기부추따바오", "5,000원(2개)","샤오마이 콤보", "15,000원(8개)");
        adapter.addItem(data);
        data = new Dongmu_Detail_MenuData(R.drawable.dongmu_detail_menu12, R.drawable.dongmu_detail_menu13,"쩡자오 콤보", "11,000원(8개)","새우 완탕스프", "10,000원");
        adapter.addItem(data);
        data = new Dongmu_Detail_MenuData(R.drawable.dongmu_detail_menu14, R.drawable.dongmu_detail_menu15,"야채 완탕스프", "9,000원","매운 새우완탕", "9,000원");
        adapter.addItem(data);
        data = new Dongmu_Detail_MenuData(R.drawable.dongmu_detail_menu16, R.drawable.dongmu_detail_menu17,"매운 야채완탕", "8,000원","매운 새우완탕면", "11,500원");
        adapter.addItem(data);
        data = new Dongmu_Detail_MenuData(R.drawable.dongmu_detail_menu18, R.drawable.dongmu_detail_menu19,"새우 완탕면", "11,000원","야채 완탕면", "10,000원");
        adapter.addItem(data);

    }

    ViewListener viewListener = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {

            View customView = getLayoutInflater().inflate(R.layout.dongmu_detail_carousel, null);

            ImageView Menu1Img = customView.findViewById(R.id.Menu1Image);
            ImageView Menu2Img = customView.findViewById(R.id.Menu2Image);
            ImageView Menu3Img = customView.findViewById(R.id.Menu3Image);
            TextView Menu1Name = customView.findViewById(R.id.Menu1Name);
            TextView Menu2Name = customView.findViewById(R.id.Menu2Name);
            TextView Menu3Name = customView.findViewById(R.id.Menu3Name);
            TextView Menu1Price = customView.findViewById(R.id.Menu1Price);
            TextView Menu2Price = customView.findViewById(R.id.Menu2Price);
            TextView Menu3Price = customView.findViewById(R.id.Menu3Price);

            Menu1Img.setImageResource(Menu1Image[position]);
            Menu2Img.setImageResource(Menu2Image[position]);
            Menu3Img.setImageResource(Menu3Image[position]);
            Menu1Name.setText(MenuName1[position]);
            Menu2Name.setText(MenuName2[position]);
            Menu3Name.setText(MenuName3[position]);
            Menu1Price.setText(MenuPrice1[position]);
            Menu2Price.setText(MenuPrice2[position]);
            Menu3Price.setText(MenuPrice3[position]);

            Dongmu_Detail_carousel.setIndicatorGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);

            return customView;
        }
    };

}

