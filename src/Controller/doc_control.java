/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author computer market
 */
public class doc_control implements Initializable{
    
    @FXML
    private TableColumn<dac_controller, String> doc_email;

    @FXML
    private TableColumn<dac_controller, String> doc_name;

    @FXML
    private TableColumn<dac_controller, String> doc_pass;

    @FXML
    private TableColumn<dac_controller, String> doc_phone;

    @FXML
    private TableView<dac_controller> doc_table;
    
    
     public ObservableList<dac_controller> getspacificdata(String url) {
        ObservableList<dac_controller> datalist = FXCollections.observableArrayList();
        try {

            Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
            ResultSet result = st.executeQuery(url);
            dac_controller date;
            while (result.next() == true) {
                date = new dac_controller(result.getString("Vet_Name"), result.getString("email"), result.getString("Phone"), result.getString("Password"));
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

            ObservableList<dac_controller> datalist;
            String sql = "SELECT Vet_Name,email,Phone,Password FROM veterinary;";
            datalist = getspacificdata(sql);
            tablecontent();
            doc_table.setItems(datalist);
        } catch (Exception ex) {
            //properties.messageShow.showmessage("warning", "select unit and difficulty", Alert.AlertType.ERROR);
            
        }

    }

    public void tablecontent() {

        doc_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        doc_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        doc_pass.setCellValueFactory(new PropertyValueFactory<>("pass"));
        doc_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showspacificdata();
    }
    
}
