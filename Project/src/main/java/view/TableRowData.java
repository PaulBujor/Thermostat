package view;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Temperature;
import model.thermometer.InternalThermometer;
import model.thermometer.OutsideThermometer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TableRowData {
    private StringProperty thermometerID;
    private DoubleProperty temperatureValue;
    private StringProperty time;



public TableRowData(Temperature temperature){
thermometerID = new SimpleStringProperty(temperature.getId());
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
time.set(temperature.getTimeStamp().format(formatter));
temperatureValue = new SimpleDoubleProperty(temperature.getTemperature());
}


  public StringProperty thermometerIDProperty()
  {
    return thermometerID;
  }

  public DoubleProperty temperatureValueProperty()
  {
    return temperatureValue;
  }
  public StringProperty timeStampStringProperty(){
  return time;
  }

  public Temperature getTemperature(){
/*  return new Temperature(thermometerIDProperty().get(),temperatureValueProperty().get(),timeStampStringProperty());*/
    return  null;
  }
}
