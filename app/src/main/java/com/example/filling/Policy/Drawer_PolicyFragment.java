package com.example.filling.Policy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.filling.Main;
import com.example.filling.R;

public class Drawer_PolicyFragment extends Fragment {

    Button BtnBack;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.policy, container, false);

        BtnBack = root.findViewById(R.id.BtnBack);
        BtnBack.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext().getApplicationContext(), Main.class);
            startActivity(intent);
        });

        return root;
    }
}