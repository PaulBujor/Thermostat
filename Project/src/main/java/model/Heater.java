package model;

public class Heater
{
  private HeaterState state;

  public Heater(){}

  public void up(){

  }
  public void down(){

  }
  public void setState(HeaterState state){
    this.state = state;
  }
  public String status(){
    return state.status();
  }
}
