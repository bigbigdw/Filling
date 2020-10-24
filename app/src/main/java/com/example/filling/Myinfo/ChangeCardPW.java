package com.example.filling.Myinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

import com.example.filling.Main;
import com.example.filling.R;

import java.util.Objects;

public class ChangeCardPW extends AppCompatActivity {

    EditText pwFirst, pwSecond, pwThird;
    TextView PwText1, PwText2, PwText3;
    Button onClickDone, onClickNext;
    LinearLayout Done, Before;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changecardpw);
        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        pwFirst = findViewById(R.id.pwFirst);
        pwSecond = findViewById(R.id.pwSecond);
        pwThird = findViewById(R.id.pwThird);
        PwText1 = findViewById(R.id.PwText1);
        PwText2 = findViewById(R.id.PwText2);
        PwText3 = findViewById(R.id.PwText3);
        Done = findViewById(R.id.ChangeDone);
        Before = findViewById(R.id.ChangeBefore);
        onClickNext = findViewById(R.id.onClickNext);
        onClickDone = findViewById(R.id.onClickDone);

        Objects.requireNonNull(pwFirst).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (text.length() == 6 && text.toString().equals("930310")) {
                    pwSecond.setOnFocusChangeListener((v, hasFocus) -> {
                        if (hasFocus) {
                            PwText1.setVisibility(View.GONE);
                            pwFirst.setVisibility(View.GONE);
                            PwText2.setVisibility(View.VISIBLE);
                        }
                    });
                } else if (text.length() == 6) {
                    Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        Objects.requireNonNull(pwSecond).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (text.length() == 6) {
                    pwThird.setOnFocusChangeListener((v, hasFocus) -> {
                        if (hasFocus) {
                            PwText2.setVisibility(View.GONE);
                            pwSecond.setVisibility(View.GONE);
                            PwText3.setVisibility(View.VISIBLE);
                        }
                    });
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        System.out.println(pwSecond.getText().toString());

        Objects.requireNonNull(pwThird).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (text.length() == 6 && text.toString().equals(pwSecond.getText().toString())) {
                    onClickNext.setVisibility(View.VISIBLE);
                } else if(text.length() == 6) {
                    Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pwThird.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(pwThird.getWindowToken(), 0);
                return true;
            }
            return false;
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
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
        Toast.makeText(getApplicationContext(), "카드 비밀번호가 변경되었습니다", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Main.class);
        startActivity(intent);
    }

}

