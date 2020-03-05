package view;

import java.io.IOException;

import javafx.beans.property.DoubleProperty;
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
  @FXML TableColumn<TableRowData, DoubleProperty> thermometer0Column;
  @FXML TableColumn<TableRowData, DoubleProperty> thermometer1Column;
  @FXML TableColumn<TableRowData, DoubleProperty> thermometer2Column;


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

     // thermometerTable.setItems(secondaryViewModel.getList());
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