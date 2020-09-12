package com.example.filling.Bottom.Filling;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Bottom_FillingViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public Bottom_FillingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Filling fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
