package com.example.filling.Dongmu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.filling.R;

public class Dongmu_Detail_List extends LinearLayout {

    ImageView ImgName;
    TextView NameText, IDText, DateText, TextText;

    public Dongmu_Detail_List(Context context){
        super(context);
        init(context);
    }

    public Dongmu_Detail_List(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.dongmu_detail_list, this, true);

        ImgName = findViewById(R.id.NameImg);
        NameText = findViewById(R.id.Name);
        IDText = findViewById(R.id.ID);
        DateText = findViewById(R.id.Date);
        TextText = findViewById(R.id.Text);
    }

    public void setName(String Name) {
        NameText.setText(Name);
    }
    public void setID(String ID) {
        IDText.setText(ID);
    }
    public void setDate(String Date) {
        DateText.setText(Date);
    }
    public void setText(String Text) {
        TextText.setText(Text);
    }

    public void setImgNameId(int ImgNameId) {
        ImgName.setImageResource(ImgNameId);
    }
}

