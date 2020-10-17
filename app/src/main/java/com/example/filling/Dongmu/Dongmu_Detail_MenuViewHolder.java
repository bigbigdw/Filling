package com.example.filling.Dongmu;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.R;

public class Dongmu_Detail_MenuViewHolder extends  RecyclerView.ViewHolder {

    TextView MenuLeft, PriceLeft, MenuRight , PriceRight;
    ImageView ImgLeft, ImgRight;


    public Dongmu_Detail_MenuViewHolder(@NonNull View itemView) {
        super(itemView);

        MenuLeft = itemView.findViewById(R.id.MenuLeft);
        PriceLeft = itemView.findViewById(R.id.PriceLeft);
        MenuRight = itemView.findViewById(R.id.MenuRight);
        PriceRight = itemView.findViewById(R.id.PriceRight);
        ImgLeft = itemView.findViewById(R.id.ImgLeft);
        ImgRight = itemView.findViewById(R.id.ImgRight);

    }

    public void onBind(Dongmu_Detail_MenuData data){
        MenuLeft.setText(data.getMenuLeft());
        PriceLeft.setText(data.getPriceLeft());
        MenuRight.setText(data.getMenuRight());
        PriceRight.setText(data.getPriceRight());
        ImgLeft.setImageResource(data.getImgLeft());
        ImgRight.setImageResource(data.getImgRight());
    }
}
