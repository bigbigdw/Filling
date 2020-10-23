package com.example.filling.Coupon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.R;

import java.util.ArrayList;

public class Coupon_PurchaseAdapter extends RecyclerView.Adapter<Coupon_PurchaseAdapter.ViewHolder>
        implements OnPersonItemClickListener {

    ArrayList<Coupon_PurchaseData> items = new ArrayList<>();
    OnPersonItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.coupon_purchase_list, viewGroup, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Coupon_PurchaseData item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClicklistener(OnPersonItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position, int Count) {
        if (listener != null) {
            listener.onItemClick(holder, view, position,Count);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView Market, Name, Price, Count;
        ImageView Img;
        String num , PriceNum;
        Button CountMinus, CountPlus;
        Integer result, ToTalPrice;

        public ViewHolder(View itemView, final OnPersonItemClickListener listener) {
            super(itemView);

            Count = itemView.findViewById(R.id.Count);
            Img = itemView.findViewById(R.id.Img);
            Market = itemView.findViewById(R.id.Market);
            Name = itemView.findViewById(R.id.Name);
            Price = itemView.findViewById(R.id.Price);
            Count = itemView.findViewById(R.id.Count);
            CountMinus = itemView.findViewById(R.id.CountMinus);
            CountPlus = itemView.findViewById(R.id.CountPlus);

            CountMinus.setOnClickListener(v -> {
                num = Count.getText().toString();
                PriceNum = Price.getText().toString();
                if(Integer.parseInt(num) > 0){
                    result = Integer.parseInt(num) - 1;
                    Count.setText(String.format("%s", result));
                    ToTalPrice = Integer.parseInt(PriceNum) * -1 ;
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, v, position, ToTalPrice);
                    }
                }
            });

            CountPlus.setOnClickListener(v -> {
                num = Count.getText().toString();
                PriceNum = Price.getText().toString();
                if(Integer.parseInt(num) < 100){
                    result = Integer.parseInt(num) + 1;
                    Count.setText(String.format("%s", result));
                    ToTalPrice =  Integer.parseInt(PriceNum) ;
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, v, position, ToTalPrice);
                    }
                }
            });

        }

        public void setItem(Coupon_PurchaseData item) {
            Img.setImageResource(item.getImg());
            Market.setText(item.getMarket());
            Name.setText(item.getName());
            Price.setText(item.getPrice());
            Count.setText(item.getCount());
        }
    }

    public void addItem(Coupon_PurchaseData item) {
        items.add(item);
    }

    public void setItems(ArrayList<Coupon_PurchaseData> items) {
        this.items = items;
    }

    public Coupon_PurchaseData getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Coupon_PurchaseData item) {
        items.set(position, item);
    }
}
