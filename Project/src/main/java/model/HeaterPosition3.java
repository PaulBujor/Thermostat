package model;

public class HeaterPosition3 extends HeaterState
{
  private Thread timeOutThread;
  private boolean completed=false;


  public HeaterPosition3(Heater heater){
    timeOutThread = new Thread(()->{
      try{
        Thread.sleep(40000);
        timeOut(heater);
      }
      catch (InterruptedException e){
        System.out.println("Time out interrupted");
      }
    });
    timeOutThread.start();
  }

  public synchronized void down(Heater heater){
    if(!completed)
    {
completed = true;
timeOutThread.interrupt();
      heater.setState(new HeaterPosition2(heater));
    }
  }

  public synchronized void timeOut(Heater heater){
if(!completed){
  completed=true;

  heater.setState(new HeaterPosition2(heater));
}
  }

  public int status(){
    return 3;
  }
}
/*
public class DoorOpen extends DoorState {
  private Thread timeout;
  private boolean completed = false;

  public DoorOpen(Door door) {
    timeout = new Thread(() -> {
      try {
        Thread.sleep(5000);
        timeout(door);
      } catch (InterruptedException e) {
        System.out.println("Timeout interrupted");
      }
    });
    timeout.start();
  }

  @Override
  public synchronized void click(Door door) {
    if (!completed) {
      completed = true;
      timeout.interrupt();
      door.setState(new DoorStayOpen());
    }
  }

  public synchronized void timeout(Door door) {
    if (!completed) {
      completed = true;
      door.setState(new DoorClosing(door));
    }
  }
}
*/
