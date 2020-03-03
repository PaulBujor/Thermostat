package model;

public class HeaterPosition2 extends HeaterState
{

  public HeaterPosition2(Heater heater){

  }
  public void up(Heater heater){
    heater.setState(new HeaterPosition3(heater));
  }
  public void down(Heater heater){
    heater.setState(new HeaterPosition1(heater));
  }
  public int status(){
    return 2;
  }
}
