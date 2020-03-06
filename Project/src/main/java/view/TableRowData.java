package view;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.thermometer.InternalThermometer;
import model.thermometer.OutsideThermometer;

public class TableRowData
{
private StringProperty thermometerID;
private DoubleProperty temperatureValue;



public TableRowData(Temperature temperature){
thermometerID = new SimpleStringProperty(temperature.getId());
temperatureValue new DoubleProperty(temperature.)
}
}
