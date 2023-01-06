/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Mainclass.Doctor;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class New_pet_profilesController implements Initializable {

    @FXML
    public Label owner_name;
    
    @FXML
    public Button exit,select , back;

    @FXML
    public Circle circleImg;
    
    @FXML
    public TextField ownernametf;

    @FXML
    public TableView<Pet_Data> petProfile;

    @FXML
    public TableColumn<Pet_Data, String> petname;

    @FXML
    public TableColumn<Pet_Data, Integer> petID;
    @FXML
    public TableColumn<Pet_Data, String> petgender;

    @FXML
    public TableColumn<Pet_Data, String> ownername;

    @FXML
    public TableColumn<Pet_Data, String> doctorname;

    @FXML
    public TableColumn<Pet_Data, String> appointment;

    @FXML
    public void getData() throws SQLException {

        Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
        ResultSet result = st.executeQuery("SELECT 	Pets_Id,Pet_Name,Gender,Owner_Name,Doctor_Name,Appointment FROM pets Where Owner_Name='" +Doctor.nameowner +"'");
        ObservableList<Pet_Data> array = FXCollections.observableArrayList();
        while (result.next()) {
            int petID = result.getInt("Pets_Id");
            String petName = result.getString("Pet_Name");
            String petGender = result.getString("Gender");
            String ownerName = result.getString("Owner_Name");
            String doctorName = result.getString("Doctor_Name");
            String appointment = result.getString("Appointment");
            array.add(new Pet_Data(petID, petName, petGender, ownerName, doctorName, appointment));
        }
        petProfile.setItems(array);
    }
    
    @FXML
    public void back(){
                Doctor.switchPage(Doctor.Page.search, 570, 600);

    }
    
    @FXML
    public void exit(){
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        owner_name.setText(Doctor.s1);
        petID.setCellValueFactory(new PropertyValueFactory<Pet_Data,Integer>("petid"));
        petname.setCellValueFactory(new PropertyValueFactory<Pet_Data,String>("petname"));
        petgender.setCellValueFactory(new PropertyValueFactory<Pet_Data,String>("petgender"));
        ownername.setCellValueFactory(new PropertyValueFactory<Pet_Data,String>("ownername"));
        doctorname.setCellValueFactory(new PropertyValueFactory<Pet_Data,String>("doctorname"));
        appointment.setCellValueFactory(new PropertyValueFactory<Pet_Data,String>("appointment"));
                
    }

}
