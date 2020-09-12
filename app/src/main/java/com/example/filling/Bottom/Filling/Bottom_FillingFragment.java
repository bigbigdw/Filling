package com.example.filling.Bottom.Filling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.filling.R;
import com.example.filling.ui.dashboard.DashboardViewModel;

public class Bottom_FillingFragment extends Fragment {

    private Bottom_FillingViewModel Bottom_FillingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.bottom_filling, container, false);


        return root;
    }
}