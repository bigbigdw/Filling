package com.example.filling.Drawer.Cash_Gift;

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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.filling.Drawer.CashGift_Purchase;
import com.example.filling.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Drawer_CashGiftFragment extends Fragment {

    LinearLayout Before,  BtnBefore;
    TextInputLayout EditCharge, PurchaseCharge;
    Editable EditChargeString;
    Button onClickNext, BtnPhoneConfirm;
    TextView CashCount, PurchaseCount;
    private CashGift_Popup CashGift_Popup;
    private Toolbar toolbar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.drawer_cash_gift, container, false);

        toolbar = root.findViewById(R.id.toolbarfragment);

        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        CashGift_Popup = new CashGift_Popup(getActivity(), BtnLeft, negativeListener);
        CashGift_Popup.show();

        Before = root.findViewById(R.id.Before);
        BtnBefore = root.findViewById(R.id.BtnBefore);

        CashCount = root.findViewById(R.id.CashCount);
        PurchaseCount = root.findViewById(R.id.PurchaseCount);
        EditCharge = root.findViewById(R.id.EditCharge);
        PurchaseCharge = root.findViewById(R.id.PurchaseCharge);

        BtnPhoneConfirm = root.findViewById(R.id.BtnPhoneConfirm);
        BtnPhoneConfirm.setOnClickListener(v -> {
            Toast.makeText(requireContext().getApplicationContext(), "유효한 아이디입니다", Toast.LENGTH_SHORT).show();
        });

        onClickNext = root.findViewById(R.id.onClickNext);
        onClickNext.setOnClickListener(v -> {
            Toast.makeText(requireContext().getApplicationContext(), "결제 화면으로 이동합니다", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireContext().getApplicationContext(), CashGift_Purchase.class);
            startActivity(intent);
        });

        EditCharge.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(EditCharge.getWindowToken(), 0);
                onClickNext.setVisibility(View.VISIBLE);
                return true;
            }
            return false;
        });


        EditText EditChargeText = EditCharge.getEditText();
        EditText PurchaseChargeText = PurchaseCharge.getEditText();

        PurchaseChargeText.setClickable(false);
        PurchaseChargeText.setFocusable(false);

        EditChargeString = Objects.requireNonNull(EditCharge.getEditText()).getText();

        assert EditChargeText != null;
        EditChargeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 입력되는 텍스트에 변화가 있을 때
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

        EditChargeText.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(EditChargeText.getWindowToken(), 0);
                onClickNext.setVisibility(View.VISIBLE);
                return true;
            }
            return false;
        });

        return root;
    }

    private View.OnClickListener BtnLeft = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(requireContext().getApplicationContext(), "선물을 수령하였습니다.",Toast.LENGTH_SHORT).show();
            CashGift_Popup.dismiss();
        }
    };

    private View.OnClickListener negativeListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(requireContext().getApplicationContext(), "내 정보 페이지로 이동합니다.",Toast.LENGTH_SHORT).show();
            CashGift_Popup.dismiss();
        }
    };

}




