package com.example.filling.Myinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.filling.Dongmu.Dongmu_List;
import com.example.filling.Login.Login;
import com.example.filling.Login.Login_FindID;
import com.example.filling.Main;
import com.example.filling.R;
import java.util.Objects;

public class MyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    public void BtnLogout(View v) {
        Toast.makeText(getApplicationContext(), "로그인 페이지로 이동합니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }

    public void BtnApply(View v) {
        Toast.makeText(getApplicationContext(), "적용이 완료되었습니다", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Main.class);
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
