package com.example.filling.Drawer.Cash_Exchange;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Drawer_CashExchangeViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public Drawer_CashExchangeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
