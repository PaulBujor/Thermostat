package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Temperature {
    private String id;
    private Double temperature;
    private LocalDateTime timeStamp;

    public Temperature(String id, Double temperature) {
        this.id = id;
        this.temperature = temperature;
        timeStamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
