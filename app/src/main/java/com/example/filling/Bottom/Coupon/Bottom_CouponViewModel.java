package com.example.filling.Bottom.Coupon;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Bottom_CouponViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public Bottom_CouponViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Filling fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
