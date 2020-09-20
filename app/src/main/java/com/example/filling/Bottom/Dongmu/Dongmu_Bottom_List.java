package com.example.filling.Bottom.Dongmu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.filling.R;

public class Dongmu_Bottom_List extends LinearLayout {

    ImageView ImgFoodImg, ImgTag1, ImgTag2, ImgTag3, ImgTag4;
    TextView TextCategory, TextDistance, TextTitle, TextLocation;

    public Dongmu_Bottom_List(Context context){
        super(context);
        init(context);
    }

    public Dongmu_Bottom_List(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.dongmu_lower_list, this, true);

        ImgFoodImg = findViewById(R.id.FoodImg);
        ImgTag1 = findViewById(R.id.ImgTag1);
        ImgTag2 = findViewById(R.id.ImgTag2);
        ImgTag3 = findViewById(R.id.ImgTag3);
        ImgTag4 = findViewById(R.id.ImgTag4);

        TextCategory = findViewById(R.id.Category);
        TextDistance = findViewById(R.id.Distance);
        TextTitle = findViewById(R.id.Title);
        TextLocation = findViewById(R.id.Location);

    }

    public void setCategory(String Category) {
        TextCategory.setText(Category);
    }
    public void setDistance(String Distance) {
        TextDistance.setText(Distance);
    }
    public void setTitle(String Title) {
        TextTitle.setText(Title);
    }
    public void setLocation(String Location) {
        TextLocation.setText(Location);
    }

    public void setFoodImgresId(int FoodImgresId) {
        ImgFoodImg.setImageResource(FoodImgresId);
    }
    public void setImgTag1resId(int ImgTag1resId) {
        ImgTag1.setImageResource(ImgTag1resId);
    }
    public void setImgTag2resId(int ImgTag2resId) {
        ImgTag2.setImageResource(ImgTag2resId);
    }
    public void setImgTag3resId(int ImgTag3resId) {
        ImgTag3.setImageResource(ImgTag3resId);
    }
    public void setImgTag4resId(int ImgTag4resId) {
        ImgTag4.setImageResource(ImgTag4resId);
    }
}
