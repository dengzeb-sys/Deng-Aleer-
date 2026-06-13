package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhone;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etName = findViewById(R.id.reg_name);
        etEmail = findViewById(R.id.reg_email);
        etPhone = findViewById(R.id.reg_phone);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            String phone = etPhone.getText().toString();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Save to database
                User newUser = new User(name, email, phone);
                AppDatabase.getInstance(this).userDao().insert(newUser);

                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                finish(); // Go back to main activity
            }
        });
    }
}
