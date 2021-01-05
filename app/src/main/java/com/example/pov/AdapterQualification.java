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

public class  AdapterQualification extends RecyclerView.Adapter<AdapterQualification.ViewHolder> implements View.OnClickListener{
    ArrayList<Qualifications> listqual;
    ArrayList<Qualifications> originallistqual;
    private View.OnClickListener listener;
    public AdapterQualification(ArrayList<Qualifications> listqual){
        this.listqual = listqual;
        this.originallistqual = new ArrayList<>();
        originallistqual.addAll(listqual);
    }
    @NonNull
    @Override
    public AdapterQualification.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemqualifications, null, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterQualification.ViewHolder holder, int position) {
        holder.user_id.setText(listqual.get(position).getUser_id());
        holder.lesson_id.setText(listqual.get(position).getLesson_id());
        holder.name.setText(listqual.get(position).getName());
        holder.email.setText(listqual.get(position).getEmail());
        holder.qualification.setText(listqual.get(position).getQualification());
    }

    @Override
    public int getItemCount() {
        return listqual.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lesson_id, name, email, qualification,user_id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user_id = itemView.findViewById(R.id.txtuseridrv);
            lesson_id = itemView.findViewById(R.id.txtlessonidrv);
            name = itemView.findViewById(R.id.txtusernamerv);
            email = itemView.findViewById(R.id.txtuseremailrv);
            qualification = itemView.findViewById(R.id.txtqualificationrv);
        }
    }
    public void filter(final String strsearch){
        if (strsearch.length() == 0){
            listqual.clear();
            listqual.addAll(originallistqual);
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){

                List<Qualifications> collect = originallistqual.stream()
                        .filter(i -> i.getName().toLowerCase().contains(strsearch))
                        .collect(Collectors.toList());

                listqual.clear();
                listqual.addAll(collect);
            }else {
                listqual.clear();
                for (Qualifications i : originallistqual){
                    if (i.getName().toLowerCase().contains(strsearch)){
                        listqual.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
}
