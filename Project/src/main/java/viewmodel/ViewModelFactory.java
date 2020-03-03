package viewmodel;

import model.Heater;

public class ViewModelFactory
{
  private MainViewModel mainViewModel;

  public ViewModelFactory(Heater heater){
    this.mainViewModel = new MainViewModel(heater);
  }

  public MainViewModel getHeaterViewModel(){
    return mainViewModel;
  }
}
