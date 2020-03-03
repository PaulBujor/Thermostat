package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ViewModelFactory viewModelFactory;
  private PrimaryController primaryController;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("temperature");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "temperature":
        root = loadHeatView("HeaterView.fxml");
        break;
    }
    currentScene.setRoot(root);
    String title = "Temperature";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadHeatView(String fxmlFile)
  {
    if (primaryController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        primaryController = loader.getController();
        primaryController
            .init(this, viewModelFactory.getHeaterViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      primaryController.reset();
    }
    return primaryController.getRoot();
  }
}
