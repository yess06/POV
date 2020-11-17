package com.example.pov;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class  AdapterQualification extends RecyclerView.Adapter<AdapterQualification.ViewHolder>{
    ArrayList<Qualifications> listqual;
    public AdapterQualification(ArrayList<Qualifications> listqual){
        this.listqual = listqual;
    }
    @NonNull
    @Override
    public AdapterQualification.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemqualifications, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterQualification.ViewHolder holder, int position) {
        holder.lesson_id.setText(listqual.get(position).getLesson_id());
        holder.name.setText(listqual.get(position).getName());
        holder.email.setText(listqual.get(position).getEmail());
        holder.qualification.setText(listqual.get(position).getQualification());
    }

    @Override
    public int getItemCount() {
        return listqual.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lesson_id, name, email, qualification;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lesson_id = itemView.findViewById(R.id.txtlessonidrv);
            name = itemView.findViewById(R.id.txtusernamerv);
            email = itemView.findViewById(R.id.txtuseremailrv);
            qualification = itemView.findViewById(R.id.txtqualificationrv);
        }
    }
}
