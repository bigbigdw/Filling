package com.example.filling.Bottom.MyInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Bottom_MyInfoViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public Bottom_MyInfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Filling fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

