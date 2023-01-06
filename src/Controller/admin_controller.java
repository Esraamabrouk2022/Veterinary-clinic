/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Mainclass.Doctor;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 *
 * @author computer market
 */
public class admin_controller implements Initializable{
   @FXML
    private Circle c1;

    @FXML
    private Circle c2;

    @FXML
    private Circle c3;
    @FXML
    void show1(ActionEvent event) {
     Doctor.switchPage(Doctor.Page.doc, 600, 600);

    }
    @FXML
    void show2(ActionEvent event) {
    Doctor.switchPage(Doctor.Page.user, 600, 600);
    }

    @FXML
    void show3(ActionEvent event) {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//     c1.setFill(new ImagePattern(new Image("/pic/pic7.jpg")));
//     c2.setFill(new ImagePattern(new Image("/pic/pic6.jpg")));
//     c3.setFill(new ImagePattern(new Image("/pic/pic4.jpg")));
     
    }
    
    
}
