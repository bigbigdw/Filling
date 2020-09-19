package com.example.filling.Drawer.Complain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Drawer_ComplainViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public Drawer_ComplainViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
