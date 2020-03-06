package model;

import java.time.LocalTime;

public class Temperature {
    private String id;
    private Double temperature;
    private LocalTime timeStamp;

    public Temperature(String id, Double temperature) {
        this.id = id;
        this.temperature = temperature;
        timeStamp = LocalTime.now();
    }

    public String getId() {
        return id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public LocalTime getTimeStamp() {
        return timeStamp;
    }
}
