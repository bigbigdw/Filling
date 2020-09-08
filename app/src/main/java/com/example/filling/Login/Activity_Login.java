package com.example.filling.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.filling.MainActivity;
import com.example.filling.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Activity_Login extends AppCompatActivity {

    TextInputLayout IDtext, PWtext;
    Editable idCheck, pwCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        IDtext = findViewById(R.id.IDtext);
        PWtext = findViewById(R.id.PWtext);
        final CheckBox AutoLogin = findViewById(R.id.AutoLogin);

        Intent intent = new Intent(this, Activity_Splash.class);
        startActivity(intent);

        AutoLogin.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (AutoLogin.isChecked()) {
                            Toast.makeText(getApplicationContext(), "자동로그인이 활성화 되었습니다", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "자동로그인이 비활성화 되었습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public void btnFindCheck(View v) {
        Intent intent = new Intent(getApplicationContext(), Activity_Find.class);
        startActivity(intent);
    }

    public void onClickLogin(View v) {
        idCheck = Objects.requireNonNull(IDtext.getEditText()).getText();
        pwCheck = Objects.requireNonNull(PWtext.getEditText()).getText();

//        if(idCheck.toString().equals("kdw0310@ajou.ac.kr") && pwCheck.toString().equals("bigbigdw")){
//            Toast.makeText(getApplicationContext(), "환영합니다 김대우님!", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
////            System.out.println("hello");
//        }else{
//            Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다", Toast.LENGTH_SHORT).show();
//        }

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

    public void onClickRegister(View v) {
        Toast.makeText(getApplicationContext(), "필링은 처음이신가요? 환영합니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Activity_Register.class);
        startActivity(intent);
    }
}