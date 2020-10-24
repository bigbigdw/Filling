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

import com.example.filling.Coupon.Coupon_Purchase;
import com.example.filling.Myinfo.CashReport;
import com.example.filling.Myinfo.ChangeCardPW;
import com.example.filling.Myinfo.ChangePW;
import com.example.filling.Myinfo.MileageReport;
import com.example.filling.Myinfo.MyCoupon;
import com.example.filling.R;

public class Bottom_MyInfoFragment extends Fragment {

    LinearLayout  BtnCoupon, ChangePW, ChangeCardPW, CashReport, MileageReport, MyCart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.bottom_myinfo, container, false);

        MyCart = root.findViewById(R.id.MyCart);
        MyCart.setOnClickListener(v -> {
            Toast.makeText(requireContext().getApplicationContext(), "내 장바구니로 이동합니다" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireContext().getApplicationContext(), Coupon_Purchase.class);
            startActivity(intent);
        });

        BtnCoupon = root.findViewById(R.id.Coupon);
        BtnCoupon.setOnClickListener(v -> {
            Toast.makeText(requireContext().getApplicationContext(), "내 쿠폰 페이지로 이동합니다" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireContext().getApplicationContext(), MyCoupon.class);
            startActivity(intent);
        });

        ChangePW = root.findViewById(R.id.ChangePW);
        ChangePW.setOnClickListener(v -> {
            Toast.makeText(requireContext().getApplicationContext(), "비밀번호 변경 페이지로 이동합니다" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireContext().getApplicationContext(), ChangePW.class);
            startActivity(intent);
        });

        ChangeCardPW = root.findViewById(R.id.ChangeCardPW);
        ChangeCardPW.setOnClickListener(v -> {
            Toast.makeText(requireContext().getApplicationContext(), "카드 비밀번호 변경 페이지로 이동합니다" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireContext().getApplicationContext(), ChangeCardPW.class);
            startActivity(intent);
        });

        CashReport = root.findViewById(R.id.CashReport);
        CashReport.setOnClickListener(v -> {
            Toast.makeText(requireContext().getApplicationContext(), "Cash 이용내역 페이지로 이동합니다" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireContext().getApplicationContext(), CashReport.class);
            startActivity(intent);
        });

        MileageReport = root.findViewById(R.id.MileageReport);
        MileageReport.setOnClickListener(v -> {
            Toast.makeText(requireContext().getApplicationContext(), "마일리지 이용내역 페이지로 이동합니다" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireContext().getApplicationContext(), MileageReport.class);
            startActivity(intent);
        });

        return root;
    }
}
