package com.example.filling.Coupon;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.R;

public class Coupon_MarketViewHolder extends  RecyclerView.ViewHolder {

    TextView  PriceLeft, PriceRight, NameLeft, NameRight, MarketLeft, MarketRight;
    ImageView ImgLeft, ImgRight;
    LinearLayout Item;

    public Coupon_MarketViewHolder(@NonNull View itemView) {
        super(itemView);

        Item = itemView.findViewById(R.id.Item);

        Item.setOnClickListener(v -> {
            Intent intent = new Intent (v.getContext(), Coupon_Detail.class);
            v.getContext().startActivity(intent);
        });

        PriceLeft = itemView.findViewById(R.id.PriceLeft);
        PriceRight = itemView.findViewById(R.id.PriceRight);
        ImgLeft = itemView.findViewById(R.id.ImgLeft);
        ImgRight = itemView.findViewById(R.id.ImgRight);
        NameLeft = itemView.findViewById(R.id.NameLeft);
        NameRight = itemView.findViewById(R.id.NameRight);
        MarketLeft = itemView.findViewById(R.id.MarketLeft);
        MarketRight = itemView.findViewById(R.id.MarketRight);

    }

    public void onBind(Coupon_MarketData data){
        PriceLeft.setText(data.getPriceLeft());
        MarketLeft.setText(data.getMarketLeft());
        NameLeft.setText(data.getNameLeft());
        PriceRight.setText(data.getPriceRight());
        MarketRight.setText(data.getMarketRight());
        NameRight.setText(data.getNameRight());
        ImgLeft.setImageResource(data.getImgLeft());
        ImgRight.setImageResource(data.getImgRight());
    }
}

