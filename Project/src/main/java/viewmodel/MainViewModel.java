package viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.HeaterModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainViewModel implements PropertyChangeListener {

    private HeaterModel model;
    private DoubleProperty t0;
    private DoubleProperty t1;
    private DoubleProperty t2;
    private IntegerProperty heaterState;

    public MainViewModel(HeaterModel model)
    {
        this.model = model;
        t0 = new SimpleDoubleProperty();
        t1 = new SimpleDoubleProperty();
        t2 = new SimpleDoubleProperty();
        heaterState = new SimpleIntegerProperty();
        model.addListener("t0", this);
        model.addListener("t1", this);
        model.addListener("t2", this);
        model.addListener("heater", this);
    }


    public DoubleProperty t0Property() {
        return t0;
    }

    public DoubleProperty t1Property() {
        return t1;
    }

    public DoubleProperty t2Property() {
        return t2;
    }

    public IntegerProperty heaterStateProperty() {
        return heaterState;
    }

    public void increaseTemperature()
    {
        model.heaterUp();
    }

    public void decreaseTemperature()
    {
        model.heaterDown();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName())
        {
            case "t0": t0.setValue((Double) evt.getNewValue());
            break;
            case "t1": t1.setValue((Double) evt.getNewValue());
            break;
            case "t2": t2.setValue((Double) evt.getNewValue());
            break;
            case "heater": heaterState.setValue((Integer) evt.getNewValue());
            break;
        }

    }
}
