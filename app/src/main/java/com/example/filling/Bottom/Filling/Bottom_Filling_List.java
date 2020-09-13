package com.example.filling.Bottom.Filling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.filling.R;

public class Bottom_Filling_List extends LinearLayout {
    TextView textView;
    TextView textView2;


    public Bottom_Filling_List(Context context) {
        super(context);
        init(context);
    }

    public Bottom_Filling_List(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.bottom_filling_list, this, true);

        textView = findViewById(R.id.Contents);
        textView2 = findViewById(R.id.Date);
    }

    public void setContents(String Contents) {
        textView.setText(Contents);
    }
    public void setDate(String Date) {
        textView2.setText(Date);
    }

}

