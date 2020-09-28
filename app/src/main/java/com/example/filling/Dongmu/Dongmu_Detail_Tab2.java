package com.example.filling.Dongmu;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.filling.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

public class Dongmu_Detail_Tab2 extends Fragment {

    CarouselView Dongmu_Detail_carousel;
    int[] Menu1Image = {R.drawable.dongmu_detail_ex02, R.drawable.dongmu_detail_ex04, R.drawable.dongmu_detail_ex03};
    int[] Menu2Image = {R.drawable.dongmu_detail_ex03, R.drawable.dongmu_detail_ex02, R.drawable.dongmu_detail_ex02};
    int[] Menu3Image = {R.drawable.dongmu_detail_ex04, R.drawable.dongmu_detail_ex03, R.drawable.dongmu_detail_ex04};
    String[] MenuName1 = {"카페라떼", "카페라떼", "카페라떼"};
    String[] MenuName2 = {"팬케이크", "팬케이크", "팬케이크"};
    String[] MenuName3 = {"티라미슈", "티라미슈", "티라미슈"};
    String[] MenuPrice1 = {"4500원", "4500원", "4500원"};
    String[] MenuPrice2 = {"6500원", "6500원", "6500원"};
    String[] MenuPrice3 = {"6000원", "6000원", "6000원"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dongmu_detail_tab2, container, false);

        Dongmu_Detail_carousel = root.findViewById(R.id.Dongmu_Detail_carousel);
        Dongmu_Detail_carousel.setPageCount(Menu1Image.length);
        Dongmu_Detail_carousel.setViewListener(viewListener);

        return root;
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

