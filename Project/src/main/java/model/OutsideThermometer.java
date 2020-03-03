package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OutsideThermometer implements Runnable, PropertyChangeSubject {
    private PropertyChangeSupport property;
    private int prevTemp = 0;

    @Override
    public void run() {
        property.firePropertyChange("external", prevTemp, externalTemperature(prevTemp, -20, 20));
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addListener(String evtid, PropertyChangeListener listener) {
        property.addPropertyChangeListener(evtid, listener);
    }

    @Override
    public void removeListener(String evtid, PropertyChangeListener listener) {
        property.removePropertyChangeListener(evtid, listener);
    }

    /*** Calculating the external temperature.
     * Values are only valid if the temperature is being measured
     * approximately every 10th second.
     * @param t0  the last measured external temperature*
     * @param min a lower limit (may temporally be deceeded)*
     * @param max an upper limit (may temporally be exceeded)*
     * @return an updated external temperature
     * */

    public double externalTemperature(double t0, double min, double max) {
        double left = t0 - min;
        double right = max - t0;
        int sign = Math.random() * (left + right) > left ? 1 : -1;
        t0 += sign * Math.random();
        return t0;
    }
}
