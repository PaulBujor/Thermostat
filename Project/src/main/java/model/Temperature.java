package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Temperature {
    private String id;
    private Double temperature;
    private LocalDate timeStamp;

    public Temperature(String id, Double temperature) {
        this.id = id;
        this.temperature = temperature;
        timeStamp = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }
}
