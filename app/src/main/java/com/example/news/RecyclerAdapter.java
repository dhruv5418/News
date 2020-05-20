package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{


    private ArrayList<News_> arrayListNumbers;
    private Context context;
    private View.OnClickListener clickListener;

    public RecyclerAdapter(ArrayList<News_> arrayListNumbers, Context context) {
        this.arrayListNumbers = arrayListNumbers;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(arrayListNumbers.get(position).getImage()).into(holder.image);
        holder.txt_title.setText(arrayListNumbers.get(position).getTitle());
       //holder.txt_date.setText((CharSequence) arrayListNumbers.get(position).getCategory());
    }

    public void setOnClickListner(View.OnClickListener onClickListner)
    {
        clickListener = onClickListner;
    }


    @Override
    public int getItemCount() {
        return arrayListNumbers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
          ImageView image;
          TextView txt_title,txt_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imgv);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_date=itemView.findViewById(R.id.txt_date);

            itemView.setTag(this);
            itemView.setOnClickListener(clickListener);

        }
    }
}
