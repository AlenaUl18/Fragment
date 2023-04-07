package com.example.my2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.my2.Model.CinemaInfo;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    public interface OnClickListener {
        void OnClick(CinemaInfo list, int position);
    }
    private final OnClickListener onClickListener;
    private final LayoutInflater inflater;
    private  List<CinemaInfo> cinemaInfo;

    public RecycleAdapter(Context context, OnClickListener onClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
        this.cinemaInfo =new ArrayList<>();
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CinemaInfo list = cinemaInfo.get(position);
        holder.image.setImageResource(list.getImage());
        holder.text.setText(list.getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.OnClick(list, position);
            }
        });
    }
    @SuppressLint("NotifyDataSetChanged")
    public void update(final List<CinemaInfo> cinemaInfo){
        this.cinemaInfo.clear();
        this.cinemaInfo = cinemaInfo;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return cinemaInfo.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView text;

        ViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.images);
            text = view.findViewById(R.id.texts);
        }
    }
}
