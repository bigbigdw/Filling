package com.example.filling.Myinfo;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.filling.Login.Login;
import com.example.filling.Main;
import com.example.filling.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class ChangePW extends AppCompatActivity {

    TextInputLayout CurrentPW, NewPW, NewPWCheck;
    Editable NewPWEditText, NewPWCheckEditText, CurrentPWEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepw);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        CurrentPW = findViewById(R.id.CurrentPW);
        NewPW = findViewById(R.id.NewPW);
        NewPWCheck = findViewById(R.id.NewPWCheck);
        NewPWEditText = Objects.requireNonNull(NewPW.getEditText()).getText();
        NewPWCheckEditText = Objects.requireNonNull(NewPWCheck.getEditText()).getText();
        CurrentPWEditText = Objects.requireNonNull(CurrentPW.getEditText()).getText();

        Objects.requireNonNull(CurrentPW.getEditText()).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (text.toString().equals("bigbigdw")) {
                    CurrentPW.setErrorEnabled(true);
                    CurrentPW.setErrorEnabled(false);
                } else {
                    CurrentPW.setError(getString(R.string.Register_PWCheck_Message));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Objects.requireNonNull(NewPWCheck.getEditText()).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (text.toString().equals(NewPWEditText.toString())) {
                    NewPWCheck.setErrorEnabled(true);
                    NewPWCheck.setErrorEnabled(false);
                } else {
                    NewPWCheck.setError(getString(R.string.Register_PWCheck_Message));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    public void BtnApply(View v) {
        if(CurrentPWEditText.toString().equals("bigbigdw") && (NewPWEditText.toString().equals(NewPWCheckEditText.toString()))){
            Toast.makeText(getApplicationContext(), "적용이 완료되었습니다", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), Main.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "비밀번호 변경을 완료할 수 없습니다", Toast.LENGTH_SHORT).show();
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

