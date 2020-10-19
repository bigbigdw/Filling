package com.example.filling.Coupon;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.R;

public class Coupon_ListViewHolder extends  RecyclerView.ViewHolder {

    TextView Text1, Text2, Text3, Text4;
    ImageView Img1, Img2, Img3, Img4;
    LinearLayout Item;

    public Coupon_ListViewHolder(@NonNull View itemView) {
        super(itemView);

        Item = itemView.findViewById(R.id.Item);

        Item.setOnClickListener(v -> {
            Intent intent = new Intent (v.getContext(), Coupon_Mart.class);
            v.getContext().startActivity(intent);
        });

        Text1 = itemView.findViewById(R.id.Text1);
        Text2 = itemView.findViewById(R.id.Text2);
        Text3 = itemView.findViewById(R.id.Text3);
        Text4 = itemView.findViewById(R.id.Text4);
        Img1 = itemView.findViewById(R.id.Img1);
        Img2 = itemView.findViewById(R.id.Img2);
        Img3 = itemView.findViewById(R.id.Img3);
        Img4 = itemView.findViewById(R.id.Img4);

    }

    public void onBind(Coupon_ListData data){
        Text1.setText(data.getText1());
        Text2.setText(data.getText2());
        Text3.setText(data.getText3());
        Text4.setText(data.getText4());
        Img1.setImageResource(data.getImg1());
        Img2.setImageResource(data.getImg2());
        Img3.setImageResource(data.getImg3());
        Img4.setImageResource(data.getImg4());
    }
}
