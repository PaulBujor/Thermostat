package model;

import utility.PropertyChangeSubject;

public interface HeaterModel extends PropertyChangeSubject {
    public void heaterUp();
    public void heaterDown();
}
