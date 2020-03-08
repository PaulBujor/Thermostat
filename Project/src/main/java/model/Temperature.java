package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Temperature {
    private String id;
    private double temperature;
    private LocalDateTime timeStamp;

    public Temperature(String id, double temperature) {
        this.id = id;
        this.temperature = temperature;
        timeStamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public double getTemperature() {
        return temperature;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
