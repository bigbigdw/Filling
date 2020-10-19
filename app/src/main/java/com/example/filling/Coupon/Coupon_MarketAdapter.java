package com.example.filling.Coupon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.R;

import java.util.ArrayList;

public class Coupon_MarketAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Coupon_MarketData> listData = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coupon_itemlist, parent, false);
        return new Coupon_MarketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Coupon_MarketViewHolder)holder).onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void addItem(Coupon_MarketData data) {
        listData.add(data);
    }
}
