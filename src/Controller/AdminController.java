/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Mainclass.Doctor;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController implements Initializable {

    @FXML
    public Button select, back, accept, delete ;

    @FXML
    public TextField chnametf, chpasstf, chphonetf, chimgtf, chtypetf, chemailtf;

    @FXML
    public TableView<Cheacked> chtable;

    @FXML
    public TableColumn<Cheacked, String> name;
     @FXML
    private TableColumn<Cheacked, String> email;
    @FXML
    public TableColumn<Cheacked, Integer> id;
    @FXML
    public TableColumn<Cheacked, String> password;

    @FXML
    public TableColumn<Cheacked, Integer> phone;

    @FXML
    public TableColumn<Cheacked, String> img;

    @FXML
    public TableColumn<Cheacked, String> type;

    @FXML
    public void accepted() {

    }
    
    

    public void selectedRow() {
        int row = chtable.getSelectionModel().getSelectedIndex();//index
        Cheacked dat = chtable.getSelectionModel().getSelectedItem();//data
        if (row < 0) {
            return;
        }

        chnametf.setText(String.valueOf(dat.getUsername()));
        chpasstf.setText(String.valueOf(dat.getPassword()));
        chphonetf.setText(String.valueOf(dat.getPhone()));
        chtypetf.setText(String.valueOf(dat.getType()));
        chemailtf.setText(String.valueOf(dat.getEmail()));

    }

    @FXML
    public void accept_action(ActionEvent event) throws SQLException {
        
       
        if (chtypetf.getText().equals("veterinary")) {
        databaseConnection.ConnectionDatabse.insertdate("INSERT INTO veterinary ( Vet_Name,Password,Phone,email) VALUES ('" + chnametf.getText() + "','" + chpasstf.getText() + "','" + chphonetf.getText() + "','" + chemailtf.getText() + "')");
        } else {
            databaseConnection.ConnectionDatabse.insertdate("INSERT INTO owner ( Own_Name, Password, Phone , email) VALUES ('" + chnametf.getText() + "','" + chpasstf.getText() + "','" + chphonetf.getText() + "','" + chemailtf.getText() + "')");

        }

       databaseConnection.ConnectionDatabse.insertdate("DELETE FROM whaiting_cheack WHERE Name='" + chnametf.getText() + "' &&Password='" + chpasstf.getText() + "'");
       showspacificdata(); 
        chnametf.setText("");
        chpasstf.setText("");
        chphonetf.setText("");
        chtypetf.setText("");
        chemailtf.setText("");

    }

    @FXML
//    public void getData() throws SQLException {
//
//        Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
//        ResultSet result = st.executeQuery("SELECT ID,Name,Password,Phone,Img,Type FROM whaiting_cheack ");
//        ObservableList<Cheacked> array = FXCollections.observableArrayList();
//        while (result.next()) {
//            int id = result.getInt("ID");
//            String name = result.getString("Name");
//            String password = result.getString("Password");
//            int phone = result.getInt("Phone");
//            String img = result.getString("Img");
//            String type = result.getString("Type");
//            array.add(new Cheacked(id, name, password, phone, img, type));
//        }
//        chtable.setItems(array);
//    }

    public ObservableList<Cheacked> getspacificdata(String url) {
        ObservableList<Cheacked> datalist = FXCollections.observableArrayList();
        try {

            Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
            ResultSet result = st.executeQuery(url);
            Cheacked date;
            while (result.next() == true) {
                date = new Cheacked(result.getString("Name"), result.getString("Password"), result.getString("Phone"), result.getString("Type"),result.getString("email"));
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
            String sql = "SELECT Name,Password,Phone,Type,email FROM whaiting_cheack;";
            datalist = getspacificdata(sql);
            tablecontent();
            chtable.setItems(datalist);
        } catch (Exception ex) {
            //properties.messageShow.showmessage("warning", "select unit and difficulty", Alert.AlertType.ERROR);

        }

    }

    public void tablecontent() {

        name.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    public void back() {
        Doctor.switchPage(Doctor.Page.openadmin, 570, 600);
    }

    @FXML
    public void delete() throws SQLException {
        databaseConnection.ConnectionDatabse.insertdate("DELETE FROM whaiting_cheack WHERE Name='" + chnametf.getText() + "' &&Password='" + chpasstf.getText() + "'");
        showspacificdata();
        chnametf.setText("");
        chpasstf.setText("");
        chphonetf.setText("");
        chtypetf.setText("");
        chemailtf.setText("");
        //       getData();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                    showspacificdata();
        

    }

}
