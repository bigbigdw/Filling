package com.example.filling.Drawer.SystemInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Drawer_SystemInfoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Drawer_SystemInfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
