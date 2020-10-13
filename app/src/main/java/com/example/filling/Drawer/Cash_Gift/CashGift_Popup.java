package com.example.filling.Drawer.Cash_Gift;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.filling.R;

import java.util.Objects;

public class CashGift_Popup extends Dialog {

    private View.OnClickListener mNegativeListener;

    public CashGift_Popup(@NonNull Context context) {super(context);}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        Objects.requireNonNull(getWindow()).setAttributes(layoutParams);

        setContentView(R.layout.cashgift_popup);

        Button mNegativeButton = findViewById(R.id.BtnRight);
        mNegativeButton.setOnClickListener(mNegativeListener);
    }

    public CashGift_Popup(@NonNull Context context, View.OnClickListener negativeListener) {
        super(context);
        this.mNegativeListener = negativeListener;
    }
}
