package com.muhammad_adi_yusuf.projeksubmission2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muhammad_adi_yusuf.projeksubmission2.R;
import com.muhammad_adi_yusuf.projeksubmission2.model.DataList;

import java.util.ArrayList;

public class AdapterRview extends RecyclerView.Adapter<AdapterRview.gViewholder> {


    private Context conText;
    private ArrayList<DataList> dataList;

    public AdapterRview(Context conText, ArrayList<DataList> dataList) {
        this.conText = conText;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public gViewholder onCreateViewHolder(@NonNull ViewGroup paRent, int viewType) {
        View itemRow = LayoutInflater.from(conText).inflate(R.layout.listitem_rv, paRent, false);
        return new gViewholder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull gViewholder ghoLder, int poSition) {
        DataList dataPosition = dataList.get(poSition);
        ghoLder.dataTitle.setText(dataPosition.getDataTitle());
        ghoLder.dataRelease.setText(dataPosition.getDataRelease());
        ghoLder.dataRate.setText(dataPosition.getDataRate());
        ghoLder.dataImage.setImageResource(dataPosition.getDataImage());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class gViewholder extends RecyclerView.ViewHolder {
        ImageView dataImage;
        TextView dataTitle, dataRelease, dataRate;

        public gViewholder(@NonNull View itemView) {
            super(itemView);
            dataImage = itemView.findViewById(R.id.iv_image);
            dataTitle = itemView.findViewById(R.id.tv_title);
            dataRelease = itemView.findViewById(R.id.tv_release);
            dataRate = itemView.findViewById(R.id.tv_rating);
        }
    }
}
