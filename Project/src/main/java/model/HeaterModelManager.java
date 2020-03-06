package model;

import model.heater.Heater;
import model.thermometer.InternalThermometer;
import model.thermometer.OutsideThermometer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class HeaterModelManager implements HeaterModel, PropertyChangeListener {
    private PropertyChangeSupport property;
    private Heater heater;
    private final double CRITICAL_HIGH = 20;
    private final double CRITICAL_LOW = -20;
    private double externalTemp = 0;
    private InternalThermometer t1;
    private InternalThermometer t2;
    private ArrayList<Temperature> tempList;


    public HeaterModelManager() {
        heater = new Heater();
        property = new PropertyChangeSupport(this);
        OutsideThermometer outT = new OutsideThermometer();
        tempList = new ArrayList<Temperature>();
        t1 = new InternalThermometer("t1", 1);
        t2 = new InternalThermometer("t2", 7);
        heater.addListener("heater", this);
        outT.addListener("t0", this);
        t1.addListener("t1", this);
        t2.addListener("t2", this);
        Thread outside = new Thread(outT);
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        outside.setDaemon(true);
        th1.setDaemon(true);
        th2.setDaemon(true);
        outside.start();
        th1.start();
        th2.start();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "t0":
                double oldExternalTemp = externalTemp;
                externalTemp = (Double) evt.getNewValue();
                property.firePropertyChange("t0", oldExternalTemp, externalTemp);
                break;
            case "t1":
                property.firePropertyChange("t1", -50, evt.getNewValue());
                if((double) evt.getNewValue() < CRITICAL_LOW || (double) evt.getNewValue() > CRITICAL_HIGH){
                    property.firePropertyChange("critical", -1, 0);
                }
                break;
            case "t2":
                property.firePropertyChange("t2", -50, evt.getNewValue());
                if((double) evt.getNewValue() < CRITICAL_LOW || (double) evt.getNewValue() > CRITICAL_HIGH){
                    property.firePropertyChange("critical", -1, 0);
                }
                break;
            case "heater":
                property.firePropertyChange("heater", -1, heater.status());
                t1.changeHeaterMode(heater.status());
                t2.changeHeaterMode(heater.status());
                break;
        }
        if (!evt.getPropertyName().equals("heater")) {
            Temperature temperature = new Temperature(evt.getPropertyName(), (Double) evt.getNewValue());
            addTemp(temperature);
            property.firePropertyChange("addTemp", 0, temperature);
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

    private void addTemp(Temperature temperature) {
        tempList.add(temperature);
    }

    public ArrayList<Temperature> getTemperatures(int number) {
        ArrayList<Temperature> result = new ArrayList<Temperature>();
        int limit = Math.min(number, tempList.size());
        for (int i = tempList.size()-1; i > tempList.size()-limit; i++) {
            result.add(tempList.get(i));
        }
        return result;
    }
}
