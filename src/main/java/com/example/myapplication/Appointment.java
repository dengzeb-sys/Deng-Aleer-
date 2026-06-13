package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "appointments")
public class Appointment {
    @PrimaryKey(autoGenerate = true)
    private int id;
    
    private String userName;
    private String serviceName;
    private double servicePrice;
    private String date;
    private String time;

    public Appointment(String userName, String serviceName, double servicePrice, String date, String time) {
        this.userName = userName;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.date = date;
        this.time = time;
    }

    // Room needs getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    public double getServicePrice() { return servicePrice; }
    public void setServicePrice(double servicePrice) { this.servicePrice = servicePrice; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    
    @Ignore
    public Service getService() {
        return new Service(serviceName, servicePrice, "", 0);
    }
}
