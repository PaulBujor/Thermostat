package model;

import model.heater.Heater;

public class Testing
{

  public static void main(String[] args)
  {
    Heater heater = new Heater();
    System.out.println(heater.status());
    heater.up();
    System.out.println(heater.status());
    heater.down();
    System.out.println(heater.status());
  }
}
