package com.example.pov;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class lessonsAdapter extends RecyclerView.Adapter<lessonsAdapter.ViewHolderlessons> {


    private ArrayList<lesson>data;
    private Context mContext;

    public lessonsAdapter(ArrayList<lesson> data, Context mContext){
        this.data = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public lessonsAdapter.ViewHolderlessons onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new
                ViewHolderlessons(LayoutInflater.from(parent.getContext()).inflate(R.layout.lessons_cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull lessonsAdapter.ViewHolderlessons holder, int position) {
        final lesson less = data.get(position);
        holder.descripcion.setText(less.getDescripcion());
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(mContext, menuActivities.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolderlessons extends RecyclerView.ViewHolder{

        TextView descripcion;
        CardView cardView;

        public ViewHolderlessons(@NonNull View itemView) {
            super(itemView);
            descripcion=(TextView)itemView.findViewById(R.id.descripcion);

            cardView=(CardView) itemView.findViewById(R.id.lessonCard);
        }
    }


}
