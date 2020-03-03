package viewmodel;

import model.Heater;

public class ViewModelFactory
{
  private HeatViewModel heaterViewModel;

  public ViewModelFactory(Heater heater){
    this.heaterViewModel = new HeatViewModel(heater);
  }

  public HeatViewModel getHeaterViewModel(){
    return heaterViewModel;
  }
}
