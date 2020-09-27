package com.example.filling.Bottom.MyInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.filling.Myinfo.MyCoupon;
import com.example.filling.Myinfo.MyInfo;
import com.example.filling.R;

public class Bottom_MyInfoFragment extends Fragment {

    LinearLayout BtnMyInfo, BtnCoupon;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.bottom_myinfo, container, false);

        BtnMyInfo = root.findViewById(R.id.MyInfo);
        BtnMyInfo.setOnClickListener(v -> {
            Toast.makeText(requireContext().getApplicationContext(), "내 정보 페이지로 이동합니다" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireContext().getApplicationContext(), MyInfo.class);
            startActivity(intent);
        });

        BtnCoupon = root.findViewById(R.id.Coupon);
        BtnCoupon.setOnClickListener(v -> {
            Toast.makeText(requireContext().getApplicationContext(), "내 쿠폰 페이지로 이동합니다" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireContext().getApplicationContext(), MyCoupon.class);
            startActivity(intent);
        });

        return root;
    }
}
