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
import androidx.navigation.fragment.NavHostFragment;

import com.example.filling.Drawer.CashGift_Purchase;
import com.example.filling.Drawer.Cash_Purchase;
import com.example.filling.Myinfo.MyInfo;
import com.example.filling.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Drawer_CashGiftFragment extends Fragment {

    LinearLayout Before,  BtnBefore;
    TextInputLayout EditCharge, PurchaseCharge, Phone, Message;
    Editable EditChargeString, MessageString;
    Button onClickNext, onClickPhone;
    private CashGift_Popup CashGift_Popup;
    private Toolbar toolbar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.drawer_cash_gift, container, false);

        toolbar = root.findViewById(R.id.toolbarfragment);

        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        CashGift_Popup = new CashGift_Popup(getActivity(), BtnLeft);
        CashGift_Popup.show();

        Before = root.findViewById(R.id.Before);
        BtnBefore = root.findViewById(R.id.BtnBefore);

        Phone = root.findViewById(R.id.Phone);
        Message = root.findViewById(R.id.Message);

        EditCharge = root.findViewById(R.id.EditCharge);
        PurchaseCharge = root.findViewById(R.id.PurchaseCharge);

        onClickPhone = root.findViewById(R.id.onClickPhone);
        onClickPhone.setOnClickListener(v -> Toast.makeText(requireContext().getApplicationContext(), "유효한 번호입니다", Toast.LENGTH_SHORT).show());

        onClickNext = root.findViewById(R.id.onClickNext);
        onClickNext.setOnClickListener(v -> {
            Toast.makeText(requireContext().getApplicationContext(), "결제 화면으로 이동합니다", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireContext().getApplicationContext(), CashGift_Purchase.class);
            intent.putExtra("SendCash",String.format("%s Cash", EditChargeString));
            intent.putExtra("SendMessage",String.format("%s", MessageString));
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
        MessageString = Objects.requireNonNull(Message.getEditText()).getText();

        assert EditChargeText != null;
        EditChargeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                PurchaseChargeText.setText(String.format("%s", Integer.parseInt(EditChargeString.toString())*10));
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });

        Objects.requireNonNull(Phone.getEditText()).addTextChangedListener((new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (text.toString().length() < 10) {
                    Phone.setError(getString(R.string.Find_InputPhone_NO));
                    Phone.setErrorEnabled(true);
                    onClickPhone.setVisibility(View.GONE);
                } else if(text.toString().length() == 11){
                    Phone.setErrorEnabled(false);
                    onClickPhone.setVisibility(View.VISIBLE);
                } else {
                    Phone.setErrorEnabled(false);
                    onClickPhone.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        }));

        EditChargeText.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(EditChargeText.getWindowToken(), 0);
                onClickNext.setVisibility(View.VISIBLE);
                return true;
            }
            return false;
        });

        root.findViewById(R.id.TooolbarBack).setOnClickListener(view -> NavHostFragment.findNavController(Drawer_CashGiftFragment.this)
                .navigate(R.id.action_Drawer_CashGift_to_bottom_filling));

        return root;
    }

    private View.OnClickListener BtnLeft = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(requireContext().getApplicationContext(), "선물을 수령하였습니다.",Toast.LENGTH_SHORT).show();
            CashGift_Popup.dismiss();
        }
    };

}




