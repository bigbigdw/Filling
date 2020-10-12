package com.example.filling.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.filling.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Login_FindID extends AppCompatActivity {

    TextInputLayout Phone, Num;
    TextView ID;
    Button onClickPhone, onClickNum;


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
        onClickNum = findViewById(R.id.onClickNum);
        onClickPhone = findViewById(R.id.onClickPhone);

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
    }

    public void onClickPhone(View v) {
        Toast.makeText(getApplicationContext(),"인증번호가 전송되었습니다", Toast.LENGTH_SHORT).show();
        Num.setVisibility(View.VISIBLE);
    }

    public void onClickNum(View v) {
        Toast.makeText(getApplicationContext(),"인증이 완료되었습니다", Toast.LENGTH_SHORT).show();
        ID.setVisibility(View.VISIBLE);
    }

    public void onClickFindPW(View v) {
        Intent intent = new Intent(getApplicationContext(), Login_FindPW.class);
        startActivity(intent);
    }

    public void onClickBack(View v) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
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
