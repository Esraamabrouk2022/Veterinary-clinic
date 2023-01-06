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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class PetprofileController implements Initializable {

    public String[] addpro = new String[6];
    @FXML
    public TextField petnametf, petidtf, ownernametf, imagetf, petagetf, petgendertf;

    @FXML
    public Button clear, add, exit, back;
    @FXML
    private Label user;
    @FXML
    private Circle circle;
    
    @FXML
    public void clear() {
        petnametf.setText("");
        petagetf.setText("");
        petgendertf.setText("");
        petidtf.setText("");
        ownernametf.setText("");
        imagetf.setText("");
    }

    @FXML
    public void close() {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void back() {
        Doctor.switchPage(Doctor.Page.owner,1000,596);

    }

    @FXML
    public void add() throws SQLException {
    Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ownernametf.setText(Doctor.s1);
        user.setText(Doctor.s1);
        circle.setFill(new ImagePattern(new Image("/pic/defult.png")));
    }

}
