package com.example.filling.Drawer;

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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.filling.Main;
import com.example.filling.R;

import java.util.Objects;

public class Cash_Purchase extends AppCompatActivity {

    EditText pwSecond;
    Button onClickDone , onClickNext;
    LinearLayout Done, Before;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cash_purchase);
        Toolbar mToolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Done = findViewById(R.id.RegisterDone);
        Before =  findViewById(R.id.RegisterBefore);
        onClickNext = findViewById(R.id.onClickNext);
        onClickDone =  findViewById(R.id.onClickDone);
        pwSecond = findViewById(R.id.pwSecond);

        pwSecond.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(pwSecond.getWindowToken(), 0);
                onClickNext.setVisibility(View.VISIBLE);
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
        Toast.makeText(getApplicationContext(), "결제가 완료되었습니다", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Main.class);
        startActivity(intent);
    }

}