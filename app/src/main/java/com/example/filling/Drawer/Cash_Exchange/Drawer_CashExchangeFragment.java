package com.example.filling.Drawer.Cash_Exchange;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.filling.Drawer.Cash_Purchase;
import com.example.filling.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Drawer_CashExchangeFragment extends Fragment {

    LinearLayout Before,After,BtnBefore,BtnAfter;
    TextInputLayout EditCharge,  PurchaseCharge, PurchaseCoin;
    Editable EditChargeString;
    Button onClickNext, onClickCancel, onClickPurchase;
    TextView CashCount,PurchaseCount;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.drawer_cashexchange, container, false);

        Before = root.findViewById(R.id.Before);
        After = root.findViewById(R.id.After);
        BtnBefore = root.findViewById(R.id.BtnBefore);
        BtnAfter = root.findViewById(R.id.BtnAfter);
        CashCount = root.findViewById(R.id.CashCount);
        PurchaseCount = root.findViewById(R.id.PurchaseCount);
        EditCharge = root.findViewById(R.id.EditCharge);
        PurchaseCharge = root.findViewById(R.id.PurchaseCharge);
        PurchaseCoin = root.findViewById(R.id.PurchaseCoin);

        onClickNext= root.findViewById(R.id.onClickNext);
        onClickNext.setOnClickListener(v -> {
            Before.setVisibility(View.GONE);
            BtnBefore.setVisibility(View.GONE);
            After.setVisibility(View.VISIBLE);
            BtnAfter.setVisibility(View.VISIBLE);
        });

        onClickCancel = root.findViewById(R.id.onClickCancel);
        onClickCancel.setOnClickListener(v -> {
            Before.setVisibility(View.VISIBLE);
            BtnBefore.setVisibility(View.VISIBLE);
            After.setVisibility(View.GONE);
            BtnAfter.setVisibility(View.GONE);
        });

        onClickPurchase = root.findViewById(R.id.onClickPurchase);
        onClickPurchase.setOnClickListener(v -> {
            Toast.makeText(requireContext().getApplicationContext(), "결제 화면으로 이동합니다", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireContext().getApplicationContext(), Cash_Purchase.class);
            startActivity(intent);
        });


        EditText EditChargeText = EditCharge.getEditText();
        EditText PurchaseChargeText = PurchaseCharge.getEditText();
        EditText PurchaseCoinText = PurchaseCoin.getEditText();

        PurchaseChargeText.setClickable(false);
        PurchaseChargeText.setFocusable(false);
        PurchaseCoinText.setClickable(false);
        PurchaseCoinText.setFocusable(false);

        EditChargeString = Objects.requireNonNull(EditCharge.getEditText()).getText();

        assert EditChargeText != null;
        EditChargeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                PurchaseChargeText.setText(String.format("%s", Integer.parseInt(EditChargeString.toString())*100));
                PurchaseCoinText.setText(String.format("%s", Integer.parseInt(EditChargeString.toString())/1000));
                CashCount.setText(String.format("%s"+"Coin", Integer.parseInt(EditChargeString.toString())/1000));
                PurchaseCount.setText(String.format("%s원", Integer.parseInt(EditChargeString.toString())*100));
            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });

        EditChargeText.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(EditChargeText.getWindowToken(), 0);
                onClickNext.setVisibility(View.VISIBLE);
                return true;
            }
            return false;
        });

        root.findViewById(R.id.TooolbarBack).setOnClickListener(view -> NavHostFragment.findNavController(Drawer_CashExchangeFragment.this)
                .navigate(R.id.action_Drawer_CashExchange_to_bottom_filling));

        return root;
    }
}
