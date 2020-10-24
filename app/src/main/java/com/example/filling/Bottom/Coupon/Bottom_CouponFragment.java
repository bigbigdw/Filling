package com.example.filling.Bottom.Coupon;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.Bottom.Filling.Bottom_FillingFragment;
import com.example.filling.Coupon.Coupon_List;
import com.example.filling.Coupon.Coupon_MarketAdapter;
import com.example.filling.Coupon.Coupon_MarketData;
import com.example.filling.Coupon.Coupon_Search;
import com.example.filling.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Bottom_CouponFragment extends Fragment {

    CarouselView Coupon_Carousel;
    EditText CouponSearchText;
    LinearLayout CouponList, CouponSearch;

    Coupon_MarketAdapter adapter;

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

        CouponSearchText = root.findViewById(R.id.CouponSearchText);
        CouponSearchText.setClickable(false);
        CouponSearchText.setFocusable(false);

        root.findViewById(R.id.FillingAD).setOnClickListener(view -> Toast.makeText(requireContext().getApplicationContext(), "이젠 든든하지 않습니다." , Toast.LENGTH_SHORT).show());

        root.findViewById(R.id.FAQImg).setOnClickListener(view -> NavHostFragment.findNavController(Bottom_CouponFragment.this)
                .navigate(R.id.action_Bottom_Coupon_to_Drawer_FAQ));

        RecyclerView recyclerView = root.findViewById(R.id.Coupon_Item_List);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Coupon_MarketAdapter();
        recyclerView.setAdapter(adapter);
        getData();

        return root;
    }

    private void getData(){
        Coupon_MarketData data = new Coupon_MarketData(R.drawable.mycoupon_ex91, R.drawable.mycoupon_ex92,"매머드커피", "매머드커피","4,000원", "스노우 매머드커피", "매머드커피", "4,800원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex80, R.drawable.mycoupon_ex81,"아메리카노", "매머드커피","2,500원", "카페라떼", "매머드커피", "3,100원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex82, R.drawable.mycoupon_ex83,"카푸치노", "매머드커피","3,100원", "카페모카", "매머드커피", "3,400원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex84, R.drawable.mycoupon_ex85,"바닐라라떼", "매머드커피","3,400원", "아몬드 아메리카노", "매머드커피", "2,800원");
        adapter.addItem(data);
        data = new Coupon_MarketData(R.drawable.mycoupon_ex86, R.drawable.mycoupon_ex87,"아몬드라떼", "매머드커피","3,400원", "카라멜 마끼야또", "매머드커피", "3,700원");
        adapter.addItem(data);
    }

    ImageListener imageListener = (position, imageView) -> imageView.setImageResource(UpperImages[position]);
}
