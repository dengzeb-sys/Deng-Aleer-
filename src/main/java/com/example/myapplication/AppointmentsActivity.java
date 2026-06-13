package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AppointmentsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppointmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

        recyclerView = findViewById(R.id.appointments_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadAppointments();
    }

    private void loadAppointments() {
        List<Appointment> appointmentList = AppDatabase.getInstance(this).appointmentDao().getAllAppointments();
        
        adapter = new AppointmentAdapter(appointmentList, position -> {
            Appointment apptToCancel = appointmentList.get(position);
            AppDatabase.getInstance(this).appointmentDao().delete(apptToCancel);
            loadAppointments(); // Refresh list
            Toast.makeText(this, "Appointment Cancelled", Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapter);
    }
}
