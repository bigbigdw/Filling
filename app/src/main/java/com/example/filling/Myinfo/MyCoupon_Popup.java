package com.example.filling.Myinfo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.filling.R;

import java.util.Objects;

public class MyCoupon_Popup extends Dialog {

    private View.OnClickListener mNegativeListener;

    public MyCoupon_Popup(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //다이얼로그 밖의 화면은 흐리게 만들어줌
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        Objects.requireNonNull(getWindow()).setAttributes(layoutParams);

        setContentView(R.layout.mycoupon_popup);

        //셋팅
        Button mNegativeButton = (Button) findViewById(R.id.nbutton);

        //클릭 리스너 셋팅 (클릭버튼이 동작하도록 만들어줌.)
        mNegativeButton.setOnClickListener(mNegativeListener);
    }

    //생성자 생성
    public MyCoupon_Popup(@NonNull Context context, View.OnClickListener negativeListener) {
        super(context);
        this.mNegativeListener = negativeListener;
    }
}
