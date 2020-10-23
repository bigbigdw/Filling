package com.example.filling.Coupon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Objects;


public class Coupon_Purchase extends AppCompatActivity {
    Coupon_PurchaseAdapter adapter;
    LinearLayout Cash, CashMileage;
    TextInputLayout CashText1, ResultText1, CashText2, MileageText, ResultText2;

    ArrayList<Integer> Total = new ArrayList();
    int sum, TotalSum = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupon_purchase);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        CashText1 = findViewById(R.id.CashText1);
        ResultText1 = findViewById(R.id.ResultText1);
        CashText2 = findViewById(R.id.CashText2);
        MileageText = findViewById(R.id.MileageText);
        ResultText2 = findViewById(R.id.ResultText2);

        EditText EditCashText1 = CashText1.getEditText();

        EditText EditResultText1 = ResultText1.getEditText();
        EditText EditCashText2 = CashText2.getEditText();
        EditText EditMileageText = MileageText.getEditText();
        EditText EditResultText2 = ResultText2.getEditText();

        EditCashText1.setClickable(false);
        EditCashText1.setFocusable(false);

        EditResultText1.setClickable(false);
        EditResultText1.setFocusable(false);

        EditCashText2.setClickable(false);
        EditCashText2.setFocusable(false);

        EditMileageText.setClickable(false);
        EditMileageText.setFocusable(false);

        EditResultText2.setClickable(false);
        EditResultText2.setFocusable(false);

        Cash = findViewById(R.id.Cash);
        CashMileage = findViewById(R.id.CashMileage);

        RadioGroup Radio = findViewById(R.id.PurchaseRadio);
        Radio.check(R.id.CashBtn);
        Radio.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.CashBtn) {
                Cash.setVisibility(View.VISIBLE);
                CashMileage.setVisibility(View.GONE);
            } else {
                Cash.setVisibility(View.GONE);
                CashMileage.setVisibility(View.VISIBLE);
            }
        });
        init();
        getData();

        for (int i = 0; i < Total.size(); i++) {
            sum += Total.get(i);
        }

        EditCashText1.setText(String.format("%s", sum));
        EditResultText1.setText(String.format("%s", (sum + TotalSum) / 1000));
        EditResultText2.setText(String.format("%s", sum + TotalSum));
        EditCashText2.setText(String.format("%s", (sum + TotalSum) / 2000));
        EditMileageText.setText(String.format("%s", (sum + TotalSum) * 200));

        adapter.setOnItemClicklistener((holder, view, position, Count) -> {
            Coupon_PurchaseData item = adapter.getItem(position);
//            Toast.makeText(getApplicationContext(), "아이템 선택 " + item.getPrice() + String.format("%s", Count),
//                    Toast.LENGTH_SHORT).show();
            TotalSum += Count;
            EditCashText1.setText(String.format("%s", sum + TotalSum));
            EditResultText1.setText(String.format("%s", (sum + TotalSum) / 1000));
            EditResultText2.setText(String.format("%s", sum + TotalSum));
            EditMileageText.setText(String.format("%s", (sum + TotalSum) * 200));
            EditCashText2.setText(String.format("%s", (sum + TotalSum) / 2000));
        });
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.Coupon_Item_List);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Coupon_PurchaseAdapter();
        recyclerView.setAdapter(adapter);

    }

    private void getData() {
        Coupon_PurchaseData data = new Coupon_PurchaseData(R.drawable.mycoupon_ex02, "레몬앤오렌지", "매머드커피", "3700", "1");
        adapter.addItem(data);
        Total.add(Integer.parseInt(data.Price) * Integer.parseInt(data.Count));
        data = new Coupon_PurchaseData(R.drawable.mycoupon_ex03, "캐모마일", "매머드커피", "3400", "4");
        adapter.addItem(data);
        Total.add(Integer.parseInt(data.Price) * Integer.parseInt(data.Count));
        data = new Coupon_PurchaseData(R.drawable.mycoupon_ex09, "딸기스무디", "매머드커피", "4500", "2");
        adapter.addItem(data);
        Total.add(Integer.parseInt(data.Price) * Integer.parseInt(data.Count));
        data = new Coupon_PurchaseData(R.drawable.mycoupon_ex08, "오렌지 아일랜드 티", "매머드커피", "3700", "5");
        adapter.addItem(data);
        Total.add(Integer.parseInt(data.Price) * Integer.parseInt(data.Count));
        data = new Coupon_PurchaseData(R.drawable.mycoupon_ex06, "리얼레몬티", "매머드커피", "3700", "6");
        adapter.addItem(data);
        Total.add(Integer.parseInt(data.Price) * Integer.parseInt(data.Count));

    }

    public void onClickPurchase(View v) {
        Intent intent = new Intent(getApplicationContext(), Coupon_PurchasePW.class);
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
