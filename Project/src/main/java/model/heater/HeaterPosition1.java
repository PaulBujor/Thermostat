package model.heater;

public class HeaterPosition1 extends HeaterState
{

  public HeaterPosition1(Heater heater){

  }
  public void up(Heater heater){
    heater.setState(new HeaterPosition2(heater));

  }
  public void down(Heater heater){
    heater.setState(new HeaterPosition0(heater));
  }
  public int status(){
    return 1;
  }
}
