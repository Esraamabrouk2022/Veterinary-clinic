/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author computer market
 */
public class messageShow {
     //calss for show message
    public static void showmessage(String title, String content, AlertType alertt) {
        Alert alert = new Alert(alertt); //intilize 
        alert.setTitle(title);//give title
        alert.setHeaderText(null);//give a head
        alert.setContentText(content);//give content 
        alert.showAndWait();//show all
    }
    public static Alert question(String title, String content) {
    Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(content);
            
          return alert;
    }
    
}
