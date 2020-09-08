package com.example.filling.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.filling.R;

import java.util.Objects;


public class Activity_CardPW extends AppCompatActivity {

    EditText pwFirst, pwSecond;
    TextView PwText1, PwText2, title, PwText3;
    Button completeBtn;
    LinearLayout Done, Before;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_cardpw);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        pwFirst = (EditText) findViewById(R.id.pwFirst);
        pwSecond = (EditText) findViewById(R.id.pwSecond);
        PwText1 = (TextView) findViewById(R.id.PwText1);
        PwText2 = (TextView) findViewById(R.id.PwText2);
        title = (TextView) findViewById(R.id.Title);
        completeBtn = (Button) findViewById(R.id.completeBtn);
        Done = (LinearLayout) findViewById(R.id.RegisterDone);
        Before = (LinearLayout) findViewById(R.id.RegisterBefore);

        pwSecond.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    PwText1.setVisibility(View.GONE);
                    pwFirst.setVisibility(View.GONE);
                    PwText2.setVisibility(View.VISIBLE);
                    pwSecond.setVisibility(View.VISIBLE);
                }
            }
        });

        pwSecond.addTextChangedListener((new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (pwSecond.getText().toString().equals(pwFirst.getText().toString())) {
                    Before.setVisibility(View.GONE);
                    Done.setVisibility(View.VISIBLE);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {//toolbar의 back키 눌렀을 때 동작
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickRegister(View v) {

        Toast.makeText(getApplicationContext(), "필링에 가입하신 것을 환영합니다", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Activity_Login.class);
        startActivity(intent);
    }

}