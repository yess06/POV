package com.example.pov;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder> implements View.OnClickListener{
    ArrayList<Users> listusers;
    ArrayList<Users> originallistusers;
    private View.OnClickListener listener;
    public AdapterUser(ArrayList<Users> listusers){
        this.listusers = listusers;
        this.originallistusers = new ArrayList<>();
        originallistusers.addAll(listusers);
    }
    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }
    }

    @NonNull
    @Override
    public AdapterUser.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemusers, null, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUser.ViewHolder holder, int position) {
        holder.id.setText(listusers.get(position).getId());
        holder.name.setText(listusers.get(position).getName());
        holder.email.setText(listusers.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return listusers.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = (TextView)itemView.findViewById(R.id.txtlessonidrv);
            name = (TextView)itemView.findViewById(R.id.txtusernamerv);
            email = (TextView)itemView.findViewById(R.id.txtuseremailrv);

        }
    }
    public void filter(final String strsearch){
        if (strsearch.length() == 0){
            listusers.clear();
            listusers.addAll(originallistusers);
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){

                List<Users> collect = originallistusers.stream()
                        .filter(i -> i.getName().toLowerCase().contains(strsearch))
                        .collect(Collectors.toList());

                listusers.clear();
                listusers.addAll(collect);
            }else {
                listusers.clear();
                for (Users i : originallistusers){
                    if (i.getName().toLowerCase().contains(strsearch)){
                        listusers.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
}
