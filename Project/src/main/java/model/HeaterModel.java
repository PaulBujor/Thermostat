package model;

import utility.PropertyChangeSubject;

import java.util.ArrayList;

public interface HeaterModel extends PropertyChangeSubject {
    public void heaterUp();
    public void heaterDown();
    public ArrayList<Temperature> getTemperatures(int number);
}
