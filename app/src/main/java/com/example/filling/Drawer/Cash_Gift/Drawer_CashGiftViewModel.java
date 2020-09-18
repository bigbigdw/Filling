package com.example.filling.Drawer.Cash_Gift;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Drawer_CashGiftViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public Drawer_CashGiftViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
