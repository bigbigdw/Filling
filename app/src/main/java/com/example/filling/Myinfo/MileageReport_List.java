package com.example.filling.Myinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.filling.R;

public class MileageReport_List extends LinearLayout {

    TextView NameText, DateText, CountText, RestText;
    ImageView Img;

    public MileageReport_List(Context context){
        super(context);
        init(context);
    }

    public MileageReport_List(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.mileagereport_list, this, true);

        NameText = findViewById(R.id.Name);
        DateText = findViewById(R.id.Date);
        CountText = findViewById(R.id.Count);
        RestText = findViewById(R.id.Rest);
        Img = findViewById(R.id.ReportImg);
    }

    public void setName(String Name) {
        NameText.setText(Name);
    }
    public void setDate(String Date) {
        DateText.setText(Date);
    }
    public void setCount(String Count) {
        CountText.setText(Count);
    }
    public void setRest(String Rest) {
        RestText.setText(Rest);
    }
    public void setImgID(int ImgID) {
        Img.setImageResource(ImgID);
    }
}
