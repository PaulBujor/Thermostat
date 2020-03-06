package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import model.HeaterModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class MainViewModel implements PropertyChangeListener {

    private HeaterModel model;
    private DoubleProperty t0;
    private DoubleProperty t1;
    private DoubleProperty t2;
    private IntegerProperty heaterState;
    private Color t0Color;
    private Color t1Color;
    private Color t2Color;



    public MainViewModel(HeaterModel model) {
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

    public void increaseTemperature() {
        model.heaterUp();
    }

    public void decreaseTemperature() {
        model.heaterDown();
    }

    public Color gett0Color()
    {
        return t0Color;
    }

    public Color gett1Color()
    {
        return t1Color;
    }

    public Color gett2Color()
    {
        return t2Color;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            switch (evt.getPropertyName()) {
                case "t0":
                    t0.setValue((Double) evt.getNewValue());
                    if ((Double) evt.getNewValue() <= 0)
                    {
                       t0Color = Color.rgb(31,154,255);
                    }
                    else
                    {
                        t0Color = Color.rgb(255,33,33);
                    }
                    break;
                case "t1":
                    t1.setValue((Double) evt.getNewValue());
                    if ((Double) evt.getNewValue() <= 0)
                    {
                        t1Color = Color.rgb(31,154,255);
                    }
                    else
                    {
                        t1Color = Color.rgb(255,33,33);
                    }
                    break;
                case "t2":
                    t2.setValue((Double) evt.getNewValue());
                    if ((Double) evt.getNewValue() <= 0)
                    {
                        t2Color = Color.rgb(31,154,255);
                    }
                    else
                    {
                        t2Color = Color.rgb(255,33,33);
                    }
                    break;
                case "heater":
                    heaterState.setValue((Integer) evt.getNewValue());
                    break;
            }

            

//            System.out.printf("T0: %.2f\nT1: %.2f\nT2: %.2f\nState: %d\n________________________\n",t0.get(), t1.get(), t2.get(), heaterState.get());

        });
    }
}
