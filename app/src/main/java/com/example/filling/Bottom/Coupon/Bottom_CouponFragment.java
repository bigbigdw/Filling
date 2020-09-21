package com.example.filling.Bottom.Coupon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.filling.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Bottom_CouponFragment extends Fragment {

    CarouselView Coupon_Carousel;
    int[] UpperImages = {R.drawable.carousel_coupon01, R.drawable.carousel_coupon02, R.drawable.carousel_coupon03, R.drawable.carousel_coupon04, R.drawable.carousel_coupon05, R.drawable.carousel_coupon06, R.drawable.carousel_coupon07, R.drawable.carousel_coupon08, R.drawable.carousel_coupon09, R.drawable.carousel_coupon10, R.drawable.carousel_coupon11, R.drawable.carousel_coupon12, R.drawable.carousel_coupon13, R.drawable.carousel_coupon14, R.drawable.carousel_coupon15, R.drawable.carousel_coupon16};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.bottom_coupon, container, false);

        Coupon_Carousel = root.findViewById(R.id.Coupon_Carousel);
        Coupon_Carousel.setPageCount(UpperImages.length);
        Coupon_Carousel.setImageListener(imageListener);

        return root;
    }

    ImageListener imageListener = (position, imageView) -> imageView.setImageResource(UpperImages[position]);
}
