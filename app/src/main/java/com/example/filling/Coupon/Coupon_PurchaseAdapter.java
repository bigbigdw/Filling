package com.example.filling.Coupon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.R;

import java.util.ArrayList;

public class Coupon_PurchaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Coupon_PurchaseData> listData = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coupon_purchase_list, parent, false);
        return new Coupon_PurchaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Coupon_PurchaseViewHolder)holder).onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void addItem(Coupon_PurchaseData data) {
        listData.add(data);
    }
}
