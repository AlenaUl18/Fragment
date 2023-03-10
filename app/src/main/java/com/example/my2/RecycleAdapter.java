package com.example.my2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<List1> list1;
     RecycleAdapter(Context context, List<List1> list1) {
     this.list1 = list1;
     this.inflater = LayoutInflater.from(context);
 }
 @Override
 public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     View view = inflater.inflate(R.layout.item, parent, false);
     return new ViewHolder(view);
 }
 @Override
  public void onBindViewHolder(RecycleAdapter.ViewHolder holder, int position) {
      List1 list = list1.get(position);
      holder.image.setImageResource(list.getImage());
      holder.text.setText(list.getText());
  }
  @Override
  public int getItemCount() {
     return list1.size();
  }
   public static class ViewHolder extends RecyclerView.ViewHolder {
     final ImageView image;
     final TextView text;
     ViewHolder(View view){
         super(view);
         image = view.findViewById(R.id.images);
         text = view.findViewById(R.id.texts);
     }
   }
}
