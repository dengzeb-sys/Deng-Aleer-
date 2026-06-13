package com.example.myapplication;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Appointment.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract UserDao userDao();
    public abstract AppointmentDao appointmentDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "honnels_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() // Only for simplicity in this example
                    .build();
        }
        return instance;
    }
}
