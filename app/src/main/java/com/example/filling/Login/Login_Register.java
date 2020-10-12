package com.example.filling.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.filling.Policy.Policy;
import com.example.filling.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Login_Register extends AppCompatActivity {

    TextInputLayout inputPW, inputPWcheck, inputID, Num, Phone;
    Editable initPW;
    CheckBox promise1, promise2;
    Button onClickNum, onClickPhone;
    Editable PhoneCheck, NumCheck, PwCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register);
        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        inputID = findViewById(R.id.inputID);
        inputPW = findViewById(R.id.inputPW);
        Num = findViewById(R.id.Num);
        onClickNum = findViewById(R.id.onClickNum);
        Phone = findViewById(R.id.Phone);
        onClickPhone = findViewById(R.id.onClickPhone);
        inputPWcheck = findViewById(R.id.inputPWcheck);
        initPW = Objects.requireNonNull(inputPW.getEditText()).getText();
        promise1 = findViewById(R.id.promise1);
        promise2 = findViewById(R.id.promise2);

        Objects.requireNonNull(inputID.getEditText()).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (text.toString().equals("kdw0310@ajou.ac.kr")) {
                    inputID.setError(getString(R.string.Register_IDCheck_Message));
                    inputID.setErrorEnabled(true);
                }
                else if (text.toString().length() < 10) {
                    inputID.setError(getString(R.string.FindID_IDInvalid));
                    inputID.setErrorEnabled(true);
                }
                else {
                    inputID.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Objects.requireNonNull(inputPWcheck.getEditText()).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (text.toString().equals(initPW.toString())) {
                    inputPWcheck.setErrorEnabled(true);
                    inputPWcheck.setErrorEnabled(false);
                } else {
                    inputPWcheck.setError(getString(R.string.Register_PWCheck_Message));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

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

        Objects.requireNonNull(Num.getEditText()).addTextChangedListener((new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (text.toString().length() < 5) {
                    Num.setError(getString(R.string.Find_InputNum_NO));
                    Num.setErrorEnabled(true);
                    onClickNum.setVisibility(View.GONE);
                }
                else if(text.toString().length() == 6){
                    Phone.setErrorEnabled(false);
                    onClickNum.setVisibility(View.VISIBLE);
                }
                else {
                    Num.setErrorEnabled(false);
                    onClickNum.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        }));

        promise1.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if ( promise1.isChecked()) {
                        Toast.makeText(getApplicationContext(), "이용약관에 동의하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        promise2.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if ( promise2.isChecked()) {
                        Toast.makeText(getApplicationContext(), "개인정보 및 수집 이용에 동의하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }


    public void onClickBack(View V) {
        Toast.makeText(getApplicationContext(), "로그인 화면으로 돌아갑니다", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }

    public void onClickPhone(View v) {
        Toast.makeText(getApplicationContext(),"인증번호가 전송되었습니다", Toast.LENGTH_SHORT).show();
        Num.setVisibility(View.VISIBLE);
    }

    public void onClickNum(View v) {
        Toast.makeText(getApplicationContext(),"인증이 완료되었습니다", Toast.LENGTH_SHORT).show();
    }

    public void onCLickPolicy(View v) {
        Intent intent = new Intent(getApplicationContext(), Policy.class);
        startActivity(intent);
    }

    public void onClickRegister(View v) {
        PhoneCheck = Objects.requireNonNull(Phone.getEditText()).getText();
        NumCheck = Objects.requireNonNull(Num.getEditText()).getText();
        PwCheck = Objects.requireNonNull(inputPWcheck.getEditText()).getText();

        if(promise1.isChecked() && promise2.isChecked() && NumCheck.toString().length() != 0 &&  PhoneCheck.toString().length() != 0 && PwCheck.toString().equals(initPW.toString())){
            Toast.makeText(getApplicationContext(), "카드 비밀번호 설정으로 이동합니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), Login_CardPW.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "회원가입이 완료되지 않았습니다.", Toast.LENGTH_SHORT).show();
            System.out.println(NumCheck.toString().length());
            System.out.println(PhoneCheck.toString().length());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}