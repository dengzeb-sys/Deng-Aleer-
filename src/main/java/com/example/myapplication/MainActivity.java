package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ServiceAdapter adapter;
    private List<Service> services;
    private Button btnRegister, btnMyAppointments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We use CoordinatorLayout and AppbarLayout for the "Figma" scroll effect
        setContentView(R.layout.activity_main);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnRegister = findViewById(R.id.btn_main_register);
        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });

        btnMyAppointments = findViewById(R.id.btn_my_appointments);
        btnMyAppointments.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AppointmentsActivity.class);
            startActivity(intent);
        });

        recyclerView = findViewById(R.id.services_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initServices();

        adapter = new ServiceAdapter(services, service -> {
            Intent intent = new Intent(MainActivity.this, BookingActivity.class);
            intent.putExtra("SERVICE_NAME", service.getName());
            intent.putExtra("SERVICE_PRICE", service.getPrice());
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
    }

    private void initServices() {
        services = new ArrayList<>();
        // Professional service list with luxury pricing
        services.add(new Service("Signature Diamond Haircut", 85.0, "Tailored precision cutting followed by a deep hydration treatment and professional styling.", android.R.drawable.ic_menu_camera));
        services.add(new Service("24K Gold Leaf Facial", 120.0, "Experience the ultimate glow with real gold leaf infusion and advanced lymphatic drainage.", android.R.drawable.ic_menu_view));
        services.add(new Service("Silk & Stone Massage", 95.0, "Combining hot stone therapy with silk-smooth essential oils for total body restoration.", android.R.drawable.ic_menu_slideshow));
        services.add(new Service("Velvet Rose Manicure", 45.0, "Luxury nail care featuring rose petal soak, scrub, and premium organic gel polishing.", android.R.drawable.ic_menu_edit));
        services.add(new Service("Parisian Balayage", 150.0, "Artisanal hand-painted highlights for a sun-kissed, natural look tailored to your hair.", android.R.drawable.ic_menu_gallery));
        services.add(new Service("Hydra-Pearl Pedicure", 60.0, "Detoxifying pearl powder soak followed by an intensive moisturizing treatment and massage.", android.R.drawable.ic_menu_manage));
    }
}
