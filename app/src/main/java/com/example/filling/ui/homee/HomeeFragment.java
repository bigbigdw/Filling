package com.example.filling.ui.homee;

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
import com.example.filling.ui.gallery.GalleryViewModel;

public class HomeeFragment extends Fragment {

    private com.example.filling.ui.homee.HomeeViewModel homeeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeeViewModel =
                ViewModelProviders.of(this).get(HomeeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_homee, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}