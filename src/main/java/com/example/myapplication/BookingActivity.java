package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        String serviceName = getIntent().getStringExtra("SERVICE_NAME");
        double servicePrice = getIntent().getDoubleExtra("SERVICE_PRICE", 0.0);
        
        TextView tvServiceName = findViewById(R.id.booking_service_name);
        tvServiceName.setText(String.format("Booking for: %s", serviceName != null ? serviceName : "Service"));

        DatePicker datePicker = findViewById(R.id.date_picker);
        TimePicker timePicker = findViewById(R.id.time_picker);
        Button btnConfirm = findViewById(R.id.btn_confirm_booking);

        btnConfirm.setOnClickListener(v -> {
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1;
            int year = datePicker.getYear();
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();

            String date = String.format(Locale.getDefault(), "%02d/%02d/%d", day, month, year);
            String time = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);

            // Create appointment and save to database
            Appointment appointment = new Appointment("Guest", serviceName, servicePrice, date, time);
            AppDatabase.getInstance(this).appointmentDao().insert(appointment);

            Toast.makeText(this, "Booking Confirmed for " + serviceName, Toast.LENGTH_LONG).show();
            finish();
        });
    }
}
