package model.heater;

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

