package com.example.filling.Dongmu;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.R;

public class Dongmu_ListViewHolder extends  RecyclerView.ViewHolder {

    ImageView FoodImg, ImgTag1, ImgTag2, ImgTag3, ImgTag4;
    TextView Category, Distance, Title, Location;
    LinearLayout Item;


    public Dongmu_ListViewHolder(@NonNull View itemView) {
        super(itemView);

        Item = itemView.findViewById(R.id.Item);

        Item.setOnClickListener(v -> {
//            Toast.makeText(v.getContext(), "Item is clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent (v.getContext(), Dongmu_Detail.class);
            v.getContext().startActivity(intent);
        });

        FoodImg = itemView.findViewById(R.id.FoodImg);
        Category = itemView.findViewById(R.id.Category);
        Distance = itemView.findViewById(R.id.Distance);
        Title = itemView.findViewById(R.id.Title);
        Location = itemView.findViewById(R.id.Location);
        ImgTag1 = itemView.findViewById(R.id.ImgTag1);
        ImgTag2 = itemView.findViewById(R.id.ImgTag2);
        ImgTag3 = itemView.findViewById(R.id.ImgTag3);
        ImgTag4 = itemView.findViewById(R.id.ImgTag4);
    }

    public void onBind(Dongmu_ListData data){
        Category.setText(data.getCategory());
        Distance.setText(data.getDistance());
        Title.setText(data.getTitle());
        Location.setText(data.getLocation());
        FoodImg.setImageResource(data.getFoodImg());
        ImgTag1.setImageResource(data.getImgTag1());
        ImgTag2.setImageResource(data.getImgTag2());
        ImgTag3.setImageResource(data.getImgTag3());
        ImgTag4.setImageResource(data.getImgTag4());
    }

}