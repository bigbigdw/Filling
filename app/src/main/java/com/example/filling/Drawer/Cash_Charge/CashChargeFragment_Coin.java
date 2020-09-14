package com.example.filling.Drawer.Cash_Charge;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.filling.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class CashChargeFragment_Coin extends Fragment {

    TextInputLayout EditCharge, TransCharge, PurchaseCharge;
    Editable EditChargeString;
    Button button8;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.cashcharge_coin, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);

        EditCharge = root.findViewById(R.id.EditCharge);
        TransCharge = root.findViewById(R.id.TransCharge);
        PurchaseCharge = root.findViewById(R.id.PurchaseCharge);
        button8 = root.findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext().getApplicationContext(), "비밀번호 찾기로 이동합니다.", Toast.LENGTH_SHORT).show();
            }
        });

        EditText EditChargeText = EditCharge.getEditText();
        EditText TransChargeText = TransCharge.getEditText();
        EditText PurchaseChargeText = PurchaseCharge.getEditText();

        TransChargeText.setClickable(false);
        TransChargeText.setFocusable(false);
        PurchaseChargeText.setClickable(false);
        PurchaseChargeText.setFocusable(false);

        EditChargeString = Objects.requireNonNull(EditCharge.getEditText()).getText();

        assert EditChargeText != null;
        EditChargeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 입력되는 텍스트에 변화가 있을 때
                TransChargeText.setText(EditChargeString.toString());
                PurchaseChargeText.setText(EditChargeString.toString());
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // 입력이 끝났을 때
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 입력하기 전에
            }
        });

        EditChargeText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(EditChargeText.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });


        return root;
    }

}
