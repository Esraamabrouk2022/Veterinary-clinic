/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Mainclass.Doctor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class PetsearchController implements Initializable {

    @FXML
    public TextField ownernametf;

    @FXML
    public TextField petidtf;

    @FXML
    Button clear, search, back;
    @FXML
    private Label user;
    @FXML
    private Circle circle;

    @FXML
    public void clear() {
        petidtf.setText("");
    }

    @FXML
    public void back() {
        Doctor.switchPage(Doctor.Page.owner, 1000, 596);
    }

    @FXML
    public void search() {
        if ("".equals(petidtf.getText())) {
            petidtf.setText("Required");
            petidtf.setStyle("-fx-text-fill:red; -fx-border-color: red ;");
        } else {
//            we need name of pet is primary key because the owner don't have capapility to add id in database
            Doctor.nameowner = petidtf.getText();

            Doctor.switchPage(Doctor.Page.newpetprofile, 806, 527);
        }
    }

    @FXML
    public void reIdtf() {
        petidtf.setText("");
        petidtf.setStyle("-fx-text-fill:black; -fx-border-color: black ;");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user.setText(Doctor.s1);
        circle.setFill(new ImagePattern(new Image("/pic/defult.png")));
    }

}
