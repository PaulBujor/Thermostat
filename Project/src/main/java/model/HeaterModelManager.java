package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HeaterModelManager implements HeaterModel, PropertyChangeListener {
    private PropertyChangeSupport property;
    private Heater heater;
    private final double CRITICAL_HIGH = 20;
    private final double CRITICAL_LOW = -20;
    private double externalTemp = 0;
    private InternalThermometer t1;
    private InternalThermometer t2;

    public HeaterModelManager() {
        heater = new Heater();
        property = new PropertyChangeSupport(this);
        OutsideThermometer outT = new OutsideThermometer();
        outT.addListener("external", this);
        Thread outside = new Thread(new OutsideThermometer());
        outside.setDaemon(true);
        outside.start();
        t1 = new InternalThermometer("t1", 1);
        t2 = new InternalThermometer("t2", 7);
        t1.addListener("t1", this);
        t2.addListener("t2", this);
        Thread th1 = new Thread(t1);
        th1.setDaemon(true);
        th1.start();
        Thread th2 = new Thread(t2);
        th2.setDaemon(true);
        th2.start();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()) {
            case "t0":
                double oldExternalTemp = externalTemp;
                externalTemp = Double.parseDouble((String) evt.getNewValue());
                property.firePropertyChange("t0", oldExternalTemp, externalTemp);
                System.out.println("t0: " + externalTemp);
                break;
            case "t1":
                break;
            case "t2":
                break;
            case "heater":
                property.firePropertyChange("heater", -1, heater.status());
                t1.changeHeaterMode(heater.status());
                t2.changeHeaterMode(heater.status());
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
