package viewmodel;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.HeaterModel;
import model.Temperature;
import view.TableRowData;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class SecondaryViewModel implements PropertyChangeListener {

    private HeaterModel model;
    private DoubleProperty t0;
    private DoubleProperty t1;
    private DoubleProperty t2;
    private ObservableList<TableRowData> list;


    public SecondaryViewModel(HeaterModel model) {
        this.model = model;
        t0 = new SimpleDoubleProperty();
        t1 = new SimpleDoubleProperty();
        t2 = new SimpleDoubleProperty();
        list = createList();
        model.addListener("addTemp", this);
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


    private ObservableList<TableRowData> createList() {
        ObservableList<TableRowData> list = FXCollections.observableArrayList();

        ArrayList<Temperature> temperatures = new ArrayList<>();
        temperatures.addAll(model.getTemperatures(20));

        for (int i = 0; i < temperatures.size(); i++) {
            list.add(new TableRowData(temperatures.get(i)));
        }

        return list;

    }

    public ObservableList<TableRowData> getList() {
        return list;
    }

    public void addToList(Temperature temperature) {
        Platform.runLater(() -> {

            list.add(0, new TableRowData(temperature));
            if (list.size() > 20) {
                list.remove(list.size() - 1);
            }
        });
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "addTemp":
                addToList((Temperature) evt.getNewValue());
                break;
        }
    }
}
