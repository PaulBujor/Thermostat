package model;

public class HeaterPosition0 extends HeaterState
{
  public HeaterPosition0(){

  }
  public void up(Heater heater){
    heater.setState(new HeaterPosition1(heater));
  }
  public String status(){
    return "Heater Position 0";
  }
}
