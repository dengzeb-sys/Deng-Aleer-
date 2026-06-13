package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder> {

    private List<Appointment> appointmentList;
    private OnCancelClickListener listener;

    public interface OnCancelClickListener {
        void onCancelClick(int position);
    }

    public AppointmentAdapter(List<Appointment> appointmentList, OnCancelClickListener listener) {
        this.appointmentList = appointmentList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment, parent, false);
        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentViewHolder holder, int position) {
        Appointment appt = appointmentList.get(position);
        holder.serviceName.setText(appt.getService().getName());
        holder.dateTime.setText(appt.getDate() + " at " + appt.getTime());
        holder.btnCancel.setOnClickListener(v -> listener.onCancelClick(position));
    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }

    static class AppointmentViewHolder extends RecyclerView.ViewHolder {
        TextView serviceName, dateTime;
        Button btnCancel;

        public AppointmentViewHolder(@NonNull View itemView) {
            super(itemView);
            serviceName = itemView.findViewById(R.id.appt_service_name);
            dateTime = itemView.findViewById(R.id.appt_date_time);
            btnCancel = itemView.findViewById(R.id.btn_cancel_appt);
        }
    }
}
