package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface AppointmentDao {
    @Insert
    void insert(Appointment appointment);

    @Query("SELECT * FROM appointments")
    List<Appointment> getAllAppointments();

    @Delete
    void delete(Appointment appointment);
    
    @Query("DELETE FROM appointments WHERE id = :id")
    void deleteById(int id);
}
