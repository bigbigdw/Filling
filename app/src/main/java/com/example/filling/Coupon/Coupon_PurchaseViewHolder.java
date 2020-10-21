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

public class Coupon_PurchaseViewHolder extends  RecyclerView.ViewHolder {

    TextView Market, Name, Price, Count;
    ImageView Img;
    String num;
    Button CountMinus, CountPlus;
    Integer result, Total;

    public Coupon_PurchaseViewHolder(@NonNull View itemView) {
        super(itemView);

        Count = itemView.findViewById(R.id.Count);
        Img = itemView.findViewById(R.id.Img);
        Market = itemView.findViewById(R.id.Market);
        Name = itemView.findViewById(R.id.Name);
        Price = itemView.findViewById(R.id.Price);
        Count = itemView.findViewById(R.id.Count);
        CountMinus = itemView.findViewById(R.id.CountMinus);
        CountPlus = itemView.findViewById(R.id.CountPlus);

        CountMinus.setOnClickListener(v -> {
            num = Count.getText().toString();
            if(Integer.parseInt(num) > 1){
                result = Integer.parseInt(num) - 1;
                Count.setText(String.format("%s", result));
                System.out.println(Count.getText().toString());
                Total = result * Integer.parseInt( Price.getText().toString());
                System.out.println(String.format("%s", Total));
            }
        });

        CountPlus.setOnClickListener(v -> {
            num = Count.getText().toString();
            if(Integer.parseInt(num) < 100){
                result = Integer.parseInt(num) + 1;
                Count.setText(String.format("%s", result));
                System.out.println(Count.getText().toString());
                Total = result * Integer.parseInt( Price.getText().toString());
                System.out.println(String.format("%s", Total));
            }
        });
    }

    public void onBind(Coupon_PurchaseData data){
        Img.setImageResource(data.getImg());
        Market.setText(data.getMarket());
        Name.setText(data.getName());
        Price.setText(data.getPrice());
        Count.setText(data.getCount());
    }
}

