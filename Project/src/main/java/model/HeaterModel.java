package model;

import java.beans.PropertyChangeListener;

public interface HeaterModel extends PropertyChangeSubject {
    public void heaterUp();
    public void heaterDown();
}
