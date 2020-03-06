package view;

import java.io.IOException;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import viewmodel.MainViewModel;
import viewmodel.SecondaryViewModel;

public class SecondaryController
{


  @FXML TableView<TableRowData> thermometerTable;
  @FXML TableColumn<TableRowData, String> thermometerIdColumn;
  @FXML TableColumn<TableRowData, Number> temperatureValue;
  //TODO needs local date or whatever its called
  @FXML TableColumn<TableRowData, String> timeColumn;


  private ViewHandler viewHandler;
private SecondaryViewModel secondaryViewModel;
  private Region root;

  public SecondaryController()
  {

  }
   public void init(ViewHandler viewHandler, SecondaryViewModel secondaryViewModel, Region root){
    this.viewHandler = viewHandler;
    this.secondaryViewModel= secondaryViewModel;
    this.root = root;

    thermometerIdColumn.setCellValueFactory(cellData -> cellData.getValue().thermometerIDProperty());
    temperatureValue.setCellValueFactory(cellData -> cellData.getValue().temperatureValueProperty());
    timeColumn.setCellValueFactory(cellData -> cellData.getValue().timeStampStringProperty());


      thermometerTable.setItems(secondaryViewModel.getList());
   }

  public void reset(){

  }

  public Region getRoot(){
    return this.root;
  }

  @FXML private void switchToMainButtonPressed(){
viewHandler.openView("temperature");
  }


}