/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Mainclass.Doctor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author computer market
 */
public class Open_adminController implements Initializable {

    @FXML
    public Button backadmin, accept, search, insystem;

    @FXML
    public void backadmin() {
        Doctor.switchPage(Doctor.Page.register, 570, 600);

    }

    @FXML
    public void accept() {
        Doctor.switchPage(Doctor.Page.admin, 918, 630);

    }

    @FXML
    public void search_all() {
        Doctor.switchPage(Doctor.Page.searchAdmin, 661, 524);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
