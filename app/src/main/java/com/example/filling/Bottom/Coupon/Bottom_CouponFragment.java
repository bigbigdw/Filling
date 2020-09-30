package com.example.filling.Bottom.Coupon;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.filling.Coupon.Coupon_Detail;
import com.example.filling.Coupon.Coupon_List;
import com.example.filling.Coupon.Coupon_Search;
import com.example.filling.Dongmu.Dongmu_List;
import com.example.filling.Dongmu.Dongmu_Search;
import com.example.filling.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Bottom_CouponFragment extends Fragment {

    CarouselView Coupon_Carousel;
    EditText CouponSearchText;
    LinearLayout CouponList, CouponSearch;
    TableLayout onClickCouponDetail;

    int[] UpperImages = {R.drawable.carousel_coupon01, R.drawable.carousel_coupon02, R.drawable.carousel_coupon03, R.drawable.carousel_coupon04, R.drawable.carousel_coupon05, R.drawable.carousel_coupon06, R.drawable.carousel_coupon07, R.drawable.carousel_coupon08, R.drawable.carousel_coupon09, R.drawable.carousel_coupon10, R.drawable.carousel_coupon11, R.drawable.carousel_coupon12, R.drawable.carousel_coupon13, R.drawable.carousel_coupon14, R.drawable.carousel_coupon15, R.drawable.carousel_coupon16};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.bottom_coupon, container, false);

        Coupon_Carousel = root.findViewById(R.id.Coupon_Carousel);
        Coupon_Carousel.setPageCount(UpperImages.length);
        Coupon_Carousel.setImageListener(imageListener);

        CouponList = root.findViewById(R.id.View);
        CouponList.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext().getApplicationContext(), Coupon_List.class);
            startActivity(intent);
        });

        CouponSearch = root.findViewById(R.id.CouponSearch);
        CouponSearch.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext().getApplicationContext(), Coupon_Search.class);
            startActivity(intent);
        });

        onClickCouponDetail = root.findViewById(R.id.onClickCouponDetail);
        onClickCouponDetail.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext().getApplicationContext(), Coupon_Detail.class);
            startActivity(intent);
        });

        CouponSearchText = root.findViewById(R.id.CouponSearchText);
        CouponSearchText.setClickable(false);
        CouponSearchText.setFocusable(false);

        return root;
    }

    ImageListener imageListener = (position, imageView) -> imageView.setImageResource(UpperImages[position]);
}
