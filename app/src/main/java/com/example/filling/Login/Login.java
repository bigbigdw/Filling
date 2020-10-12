package com.example.filling.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.filling.Main;
import com.example.filling.R;
import com.example.filling.Splash;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Login extends AppCompatActivity {

    TextInputLayout IDtext, PWtext;
    Editable idCheck, pwCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        IDtext = findViewById(R.id.IDtext);
        PWtext = findViewById(R.id.PWtext);
        final CheckBox AutoLogin = findViewById(R.id.AutoLogin);

        Intent intent = new Intent(this, Splash.class);
        startActivity(intent);

        AutoLogin.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if (AutoLogin.isChecked()) {
                        Toast.makeText(Login.this.getApplicationContext(), "자동로그인이 활성화 되었습니다", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this.getApplicationContext(), "자동로그인이 비활성화 되었습니다", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void onClickFindID(View v) {
        Toast.makeText(getApplicationContext(), "아이디 찾기로 이동합니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Login_FindID.class);
        startActivity(intent);
    }

    public void onClickFindPW(View v) {
        Toast.makeText(getApplicationContext(), "비밀번호 찾기로 이동합니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Login_FindPW.class);
        startActivity(intent);
    }


    public void onClickLogin(View v) {
        idCheck = Objects.requireNonNull(IDtext.getEditText()).getText();
        pwCheck = Objects.requireNonNull(PWtext.getEditText()).getText();

        if(idCheck.toString().equals("kdw0310@ajou.ac.kr") && pwCheck.toString().equals("bigbigdw")){
            Toast.makeText(getApplicationContext(), "환영합니다 김대우님!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), Main.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickRegister(View v) {
        Toast.makeText(getApplicationContext(), "필링은 처음이신가요? 환영합니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Login_Register.class);
        startActivity(intent);
    }
}
