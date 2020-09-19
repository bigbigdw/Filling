package com.example.filling.Drawer.FAQ;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Drawer_FAQViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Drawer_FAQViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
