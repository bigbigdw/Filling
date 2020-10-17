package com.example.filling.Dongmu;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.R;

public class Dongmu_Detail_CommentViewHolder extends  RecyclerView.ViewHolder {

    ImageView ImgName;
    TextView NameText, IDText, DateText, TextText;


    public Dongmu_Detail_CommentViewHolder(@NonNull View itemView) {
        super(itemView);

        ImgName = itemView.findViewById(R.id.NameImg);
        NameText = itemView.findViewById(R.id.Name);
        IDText = itemView.findViewById(R.id.ID);
        DateText = itemView.findViewById(R.id.Date);
        TextText = itemView.findViewById(R.id.Text);
    }

    public void onBind(Dongmu_Detail_CommentData data){
        NameText.setText(data.getName());
        IDText.setText(data.getID());
        DateText.setText(data.getDate());
        TextText.setText(data.getText());
        ImgName.setImageResource(data.getImgNameId());
    }
}
