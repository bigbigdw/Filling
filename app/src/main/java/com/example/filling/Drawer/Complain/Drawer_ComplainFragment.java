package com.example.filling.Drawer.Complain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.filling.R;

public class Drawer_ComplainFragment extends Fragment {

    Button Complain_BtnResult,Complain_BtnSubmit;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.drawer_complain, container, false);

        Complain_BtnResult = root.findViewById(R.id.Complain_BtnResult);
        Complain_BtnSubmit = root.findViewById(R.id.Complain_BtnSubmit);

        Complain_BtnSubmit.setOnClickListener(v -> {
            Toast.makeText(requireContext().getApplicationContext(), "접수가 완료되었습니다. 결과는 메일로 전송됩니다.", Toast.LENGTH_SHORT).show();
        });

        Complain_BtnResult.setOnClickListener(v -> {
//            Intent intent = new Intent(requireContext().getApplicationContext(), Complain_Result.class);
//            startActivity(intent);
        });

        root.findViewById(R.id.TooolbarBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Drawer_ComplainFragment.this)
                        .navigate(R.id.action_Drawer_Complain_to_bottom_filling);
            }
        });

        return root;
    }
}
