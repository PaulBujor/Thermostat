package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HeaterModelManager implements HeaterModel, PropertyChangeListener {
    private PropertyChangeSupport property;
    private Heater heater;
    private final double CRITICAL_HIGH = 20;
    private final double CRITICAL_LOW = -20;
    private double externalTemp;

    public HeaterModelManager() {
        heater = new Heater();
        property = new PropertyChangeSupport(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()) {
            case "external":
                externalTemp = Double.parseDouble((String) evt.getNewValue());
                break;
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

    public void heaterUp() {
        heater.up();
    }

    public void heaterDown() {
        heater.down();
    }


}
