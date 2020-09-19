package com.example.filling.Drawer.SystemInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.filling.Main;
import com.example.filling.R;

public class Drawer_SystemInfoFragment extends Fragment {

    Button BtnBack;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.drawer_systeminfo, container, false);

        Toolbar Drawer_toolbar = (Toolbar) root.findViewById(R.id.Drawer_toolbar);

        BtnBack = root.findViewById(R.id.BtnBack);
        BtnBack.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext().getApplicationContext(), Main.class);
            startActivity(intent);
        });

        root.findViewById(R.id.TooolbarBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Drawer_SystemInfoFragment.this)
                        .navigate(R.id.action_Drawer_SystemInfo_to_bottom_filling);
            }
        });

        return root;
    }
}
