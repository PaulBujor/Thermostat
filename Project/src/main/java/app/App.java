package app;

import javafx.application.Application;
import javafx.stage.Stage;
import model.HeaterModelManager;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class App extends Application
{

  public void start(Stage primaryStage)
  {
    HeaterModelManager model = new HeaterModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);
  }

  public static void main(String[] args) {
    launch();
  }
}
