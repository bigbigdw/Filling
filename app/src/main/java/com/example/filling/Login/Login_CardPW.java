package com.example.filling.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.filling.R;

import java.util.Objects;

public class Login_CardPW extends AppCompatActivity {

    EditText pwFirst, pwSecond;
    TextView PwText1, PwText2;
    Button onClickDone , onClickNext;
    LinearLayout Done, Before;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_cardpw);
        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        pwFirst = findViewById(R.id.pwFirst);
        pwSecond = findViewById(R.id.pwSecond);
        PwText1 = findViewById(R.id.PwText1);
        PwText2 = findViewById(R.id.PwText2);
        Done = findViewById(R.id.RegisterDone);
        Before = findViewById(R.id.RegisterBefore);
        onClickNext = findViewById(R.id.onClickNext);
        onClickDone =  findViewById(R.id.onClickDone);

        pwSecond.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                PwText1.setVisibility(View.GONE);
                pwFirst.setVisibility(View.GONE);
                PwText2.setVisibility(View.VISIBLE);
                onClickNext.setVisibility(View.VISIBLE);
            }
        });

        pwSecond.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(pwSecond.getWindowToken(), 0);
                return true;
            }
            return false;
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {//toolbar의 back키 눌렀을 때 동작
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickNext(View v) {
        Before.setVisibility(View.GONE);
        onClickNext.setVisibility(View.GONE);
        Done.setVisibility(View.VISIBLE);
        onClickDone.setVisibility(View.VISIBLE);
    }

    public void onClickDone(View v) {
        Toast.makeText(getApplicationContext(), "필링에 가입하신 것을 환영합니다", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }

}
