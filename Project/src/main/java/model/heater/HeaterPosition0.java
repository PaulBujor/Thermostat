package model.heater;

public class HeaterPosition0 extends HeaterState
{
  public HeaterPosition0(Heater heater){

  }
  public void up(Heater heater){
    heater.setState(new HeaterPosition1(heater));
  }
  public int status(){
    return 0;
  }
}
