package model;

public class Heater
{
  private HeaterState state;

  public Heater(){
    this.state = new HeaterPosition0(this);
  }

  public void up(){
state.up(this);
  }
  public void down(){
state.down(this);
  }
  public void setState(HeaterState state){
    this.state = state;
  }
  public int status(){
    return state.status();
  }
}
