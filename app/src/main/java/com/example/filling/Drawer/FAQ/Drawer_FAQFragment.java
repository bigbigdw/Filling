package com.example.filling.Drawer.FAQ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.filling.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Drawer_FAQFragment extends Fragment {

    ExpandableRelativeLayout Expand1, Expand2, Expand3, Expand4, Expand5, Expand6 , Expand7;
//    Button Btn1;
    LinearLayout Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.drawer_faq, container, false);

        Btn1 = root.findViewById(R.id.Btn1);
        Btn1.setOnClickListener(v -> {
            Expand1 = (ExpandableRelativeLayout) root.findViewById(R.id.Expand1);
            Expand1.toggle(); // toggle expand and collapse
        });

        Btn2 = root.findViewById(R.id.Btn2);
        Btn2.setOnClickListener(v -> {
            Expand2 = (ExpandableRelativeLayout) root.findViewById(R.id.Expand2);
            Expand2.toggle(); // toggle expand and collapse
        });

        Btn3 = root.findViewById(R.id.Btn3);
        Btn3.setOnClickListener(v -> {
            Expand3 = (ExpandableRelativeLayout) root.findViewById(R.id.Expand3);
            Expand3.toggle(); // toggle expand and collapse
        });

        Btn4 = root.findViewById(R.id.Btn4);
        Btn4.setOnClickListener(v -> {
            Expand4 = (ExpandableRelativeLayout) root.findViewById(R.id.Expand4);
            Expand4.toggle(); // toggle expand and collapse
        });

        Btn5 = root.findViewById(R.id.Btn5);
        Btn5.setOnClickListener(v -> {
            Expand5 = (ExpandableRelativeLayout) root.findViewById(R.id.Expand5);
            Expand5.toggle(); // toggle expand and collapse
        });

        Btn6 = root.findViewById(R.id.Btn6);
        Btn6.setOnClickListener(v -> {
            Expand6 = (ExpandableRelativeLayout) root.findViewById(R.id.Expand6);
            Expand6.toggle(); // toggle expand and collapse
        });

        Btn7 = root.findViewById(R.id.Btn7);
        Btn7.setOnClickListener(v -> {
            Expand7 = (ExpandableRelativeLayout) root.findViewById(R.id.Expand7);
            Expand7.toggle(); // toggle expand and collapse
        });

        root.findViewById(R.id.TooolbarBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Drawer_FAQFragment.this)
                        .navigate(R.id.action_Drawer_FAQ_to_bottom_filling);
            }
        });

        return root;
    }


}