package com.example.filling.Drawer.Alert;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.filling.R;


public class Drawer_Alert_List extends LinearLayout {
    TextView text1, text2;
    
    public Drawer_Alert_List(Context context){
        super(context);
        init(context);
    }

    public Drawer_Alert_List(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.alert_list, this, true);

        text1 = findViewById(R.id.Contents);
        text2 = findViewById(R.id.Date);
    }

    public void setContents(String Contents) {
        text1.setText(Contents);
    }
    public void setDate(String Date) {
        text2.setText(Date);
    }

}
