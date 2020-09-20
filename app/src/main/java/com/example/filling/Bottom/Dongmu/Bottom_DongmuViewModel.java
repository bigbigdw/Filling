package com.example.filling.Bottom.Dongmu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Bottom_DongmuViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public Bottom_DongmuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Filling fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
