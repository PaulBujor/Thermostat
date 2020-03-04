package model.heater;

import utility.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Heater implements PropertyChangeSubject
{
  private HeaterState state;
  private PropertyChangeSupport propertyChangeSupport;

  public Heater(){
    this.state = new HeaterPosition0(this);
    propertyChangeSupport = new PropertyChangeSupport(this);
  }

  public void up(){
state.up(this);
propertyChangeSupport.firePropertyChange("heater",0,1);
  }
  public void down(){
state.down(this);
propertyChangeSupport.firePropertyChange("heater",0,1);
  }
  public void setState(HeaterState state){
    this.state = state;
  }
  public int status(){
    return state.status();
  }

  @Override public void addListener(String evtid,
      PropertyChangeListener listener)
  {
propertyChangeSupport.addPropertyChangeListener(evtid,listener);
  }

  @Override public void removeListener(String evtid,
      PropertyChangeListener listener)
  {
propertyChangeSupport.removePropertyChangeListener(evtid,listener);
  }
}
