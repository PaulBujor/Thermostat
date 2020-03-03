package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InternalThermometer implements Runnable, PropertyChangeSubject {
    private double outTemp;
    private double lastTemp = 10;
    private int distance;
    private int heaterMode = 0;
    private PropertyChangeSupport property;
    private String thermoId;

    public InternalThermometer(String thermoId, int distance) {
        property = new PropertyChangeSupport(this);
        this.thermoId = thermoId;
        this.distance = distance;
    }

    public void changeHeaterMode(int mode) {
        heaterMode = mode;
    }

    @Override
    public void run() {
        property.firePropertyChange(thermoId, lastTemp, temperature(lastTemp, heaterMode, distance, outTemp, 6));
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double temperature(double t, int p, int d, double t0, int s) {
        double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
        tMax = Math.max(Math.max(t, tMax), t0);
        double heaterTerm = 0;
        if (p > 0) {
            double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
            heaterTerm = 30 * s * Math.abs(tMax - t) / den;
        }
        double outdoorTerm = (t - t0) * s / 250.0;
        t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
        return t;
    }

    public void updateOutTemp(double outTemp) {
        this.outTemp = outTemp;
    }

    @Override
    public void addListener(String evtid, PropertyChangeListener listener) {
        property.addPropertyChangeListener(evtid, listener);
    }

    @Override
    public void removeListener(String evtid, PropertyChangeListener listener) {
        property.removePropertyChangeListener(evtid, listener);
    }
}
