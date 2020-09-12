package com.example.filling.Bottom.Filling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.filling.R;
import com.example.filling.ui.dashboard.DashboardViewModel;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Bottom_FillingFragment extends Fragment {

    private Bottom_FillingViewModel Bottom_FillingViewModel;

    CarouselView carouselView;

    int[] sampleImages = {R.drawable.filling_ad01, R.drawable.filling_ad02, R.drawable.filling_ad03};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.bottom_filling, container, false);

        carouselView = (CarouselView) root.findViewById(R.id.customCarouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        return root;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}