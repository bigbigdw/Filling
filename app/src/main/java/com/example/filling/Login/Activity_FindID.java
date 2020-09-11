package com.example.filling.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.filling.R;
import com.google.android.material.textfield.TextInputLayout;



import java.util.Objects;


public class Activity_FindID extends AppCompatActivity {

    TextInputLayout Phone, Num;
    TextView ID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_findid);
        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Phone =  findViewById(R.id.Phone);
        Num =  findViewById(R.id.Num);
        ID = findViewById(R.id.ID);

        Objects.requireNonNull(Phone.getEditText()).addTextChangedListener((new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
                if (text.toString().length() < 12) {
                    Phone.setError(getString(R.string.Find_InputPhone_NO));
                    Phone.setErrorEnabled(true);
                } else {
                    Phone.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        }));

        Objects.requireNonNull(Num.getEditText()).addTextChangedListener((new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
                if (text.toString().length() < 6) {
                    Num.setError(getString(R.string.Find_InputNum_NO));
                    Num.setErrorEnabled(true);
                } else {
                    Num.setErrorEnabled(false);
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        }));
    }

    public void onClickPhone(View v) {
        Toast.makeText(getApplicationContext(),"인증번호가 전송되었습니다", Toast.LENGTH_SHORT).show();
    }

    public void onClickNum(View v) {
        Toast.makeText(getApplicationContext(),"인증이 완료되었습니다", Toast.LENGTH_SHORT).show();
        ID.setVisibility(View.VISIBLE);
    }

    public void onClickFindPW(View v) {
        Intent intent = new Intent(getApplicationContext(), Activity_FindPW.class);
        startActivity(intent);
    }

    public void onClickBack(View v) {
        Intent intent = new Intent(getApplicationContext(), Activity_Login.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {//toolbar의 back키 눌렀을 때 동작
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}