/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Mainclass.Doctor;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author computer market
 */
public class search_all implements Initializable{
   @FXML
    private ComboBox<String> combox;
     
    @FXML
    private TextField txt;
    
    @FXML
    private TableView<Cheacked> table;

    @FXML
    private TableColumn<Cheacked, String> tc1;

    @FXML
    private TableColumn<Cheacked, String> tc2;

     @FXML
    private Button search;
    @FXML
    private TableColumn<Cheacked, String> tc3;

    @FXML
    private TableColumn<Cheacked, String> tc4;

    public ObservableList<Cheacked> getspacificdata(String url) {
        ObservableList<Cheacked> datalist = FXCollections.observableArrayList();
        try {

            Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
            ResultSet result = st.executeQuery(url);
            Cheacked date;
            while (result.next() == true) {
                date = new Cheacked(result.getString("Name"), result.getString("Password"), result.getString("Phone"),result.getString("email"));
                datalist.addAll(date);
            }
            result.close();
            st.close();
            databaseConnection.ConnectionDatabse.connect().close();
        } catch (SQLException ex) {
            //properties.messageShow.showmessage("CONNECTION ERROR", ex.toString(), Alert.AlertType.ERROR);

        } catch (Exception ex) {
            //properties.messageShow.showmessage("CONNECTION ERROR", ex.toString(), Alert.AlertType.ERROR);

        }
        return datalist;
    }

    public void showspacificdata() {
        try {

            ObservableList<Cheacked> datalist;
            String sql = "SELECT Own_Name,email,Phone,Password FROM owner where Own_Name='esraa' ";
            datalist = getspacificdata(sql);
            tablecontent();
            table.setItems(datalist);
        } catch (Exception ex) {
            properties.messageShow.showmessage("warning", ex.toString(),Alert.AlertType.ERROR);

        }

    }

    public void tablecontent() {

        tc1.setCellValueFactory(new PropertyValueFactory<>("username"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("email"));
        tc3.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("password"));
    }
    @FXML
    void back_nav(ActionEvent event) {
  Doctor.switchPage(Doctor.Page.admin,599,374);
    }

    @FXML
    void search(ActionEvent event) {
    if(combox.getValue().equals("owner")){
      // databaseConnection.ConnectionDatabse.insertdate("SELECT Own_Name,email,Phone,Password FROM owner where Own_Name='"+txt.getText()+"' OR email='"+txt.getText()+"' OR Phone='"+txt.getText()+"' OR Password='"+txt.getText()+"' ");
    showspacificdata();
    
    } else{
        
    }               

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         combox.getItems().add("owner");
         combox.getItems().add("veterinary");
    }
    
    
    
}
