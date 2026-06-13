package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {

    private List<Service> serviceList;
    private OnServiceClickListener listener;

    public interface OnServiceClickListener {
        void onBookClick(Service service);
    }

    public ServiceAdapter(List<Service> serviceList, OnServiceClickListener listener) {
        this.serviceList = serviceList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service, parent, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        Service service = serviceList.get(position);
        holder.name.setText(service.getName());
        holder.description.setText(service.getDescription());
        holder.price.setText(String.format(Locale.getDefault(), "$%.2f", service.getPrice()));
        holder.image.setImageResource(service.getImageResource());
        holder.bookButton.setOnClickListener(v -> listener.onBookClick(service));
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    static class ServiceViewHolder extends RecyclerView.ViewHolder {
        TextView name, description, price;
        ImageView image;
        Button bookButton;

        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.service_name);
            description = itemView.findViewById(R.id.service_description);
            price = itemView.findViewById(R.id.service_price);
            image = itemView.findViewById(R.id.service_image);
            bookButton = itemView.findViewById(R.id.book_button);
        }
    }
}
