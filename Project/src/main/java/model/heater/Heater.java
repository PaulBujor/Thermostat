package model.heater;

import utility.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Heater implements PropertyChangeSubject
{
  private HeaterState state;
  private PropertyChangeSupport property;

  public Heater(){
    this.state = new HeaterPosition0(this);
    property = new PropertyChangeSupport(this);
  }

  public void up(){
state.up(this);
property.firePropertyChange("heater",0,1);
  }
  public void down(){
state.down(this);
property.firePropertyChange("heater",0,1);
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
property.addPropertyChangeListener(evtid,listener);
  }

  @Override public void removeListener(String evtid,
      PropertyChangeListener listener)
  {
property.removePropertyChangeListener(evtid,listener);
  }
}
