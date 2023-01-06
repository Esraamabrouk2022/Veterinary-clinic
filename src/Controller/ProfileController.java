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
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


public class ProfileController implements Initializable {
    @FXML
    public Circle c1;
    
    @FXML
    public Button back;
    
    @FXML
    public void back(){
        Doctor.switchPage(Doctor.Page.owner, 961, 596);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image im = new Image("C:\\Users\\pc\\OneDrive\\Documents\\NetBeansProjects\\Project\\src\\Image\\sayed.jpg", false);
        c1.setFill(new ImagePattern(im));
    }

}
