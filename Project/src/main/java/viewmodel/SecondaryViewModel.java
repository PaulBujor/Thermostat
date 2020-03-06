package viewmodel;

import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.HeaterModel;
import view.TableRowData;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SecondaryViewModel implements PropertyChangeListener
{

  private HeaterModel model;
  private DoubleProperty t0;
  private DoubleProperty t1;
  private DoubleProperty t2;
  private ObservableList<TableRowData> list;


  public SecondaryViewModel(HeaterModel model){
    this.model= model;
    t0 = new SimpleDoubleProperty();
    t1 = new SimpleDoubleProperty();
    t2 = new SimpleDoubleProperty();
    list = createList();
    model.addListener("t0",this);
    model.addListener("t1",this);
    model.addListener("t2",this);
  }

  public DoubleProperty t0Property()
  {
    return t0;
  }

  public DoubleProperty t1Property()
  {
    return t1;
  }

  public DoubleProperty t2Property()
  {
    return t2;
  }
  //TODO
private ObservableList<TableRowData> createList(){
return   FXCollections.observableArrayList();

}

public ObservableList<TableRowData> getList(){
  return  list;
}

public void addToList(){

}


  @Override public void propertyChange(PropertyChangeEvent evt)
  {

  }
}
