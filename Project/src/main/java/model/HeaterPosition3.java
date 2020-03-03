package model;

public class HeaterPosition3 extends HeaterState
{

  public HeaterPosition3(Heater heater){
  }

  public void down(Heater heater){
    heater.setState(new HeaterPosition2(heater));
  }
}
