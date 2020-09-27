package com.example.filling.Myinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.filling.R;

public class MyCoupon_List extends LinearLayout {
    TextView text1, text2, text3;
    ImageView Image;

    public MyCoupon_List(Context context) {
        super(context);
        init(context);
    }

    public MyCoupon_List(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.mycoupon_list, this, true);

        text1 = findViewById(R.id.Title);
        text2 = findViewById(R.id.GoodsName);
        text3 = findViewById(R.id.Date);
        Image = findViewById(R.id.CouponImg);
    }


    public void setTitle(String Title) {
        text1.setText(Title);
    }
    public void setGoodsName(String GoodsName) {
        text2.setText(GoodsName);
    }
    public void setDate(String Date) {
        text3.setText(Date);
    }
    public void setImageId(int ImageId) { Image.setImageResource(ImageId); }
}
