/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Mainclass.Doctor;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

/**
 *
 * @author computer market
 */
public class book_appinmentController implements Initializable{

    @FXML
    private ComboBox<String> combo_owner;
   
    @FXML
    Label lblDoctorName;
  
  
    @FXML
    private Circle crDocImage;
    
    @FXML
    Rectangle  rec2;

    @FXML
    private TextField namepatient;

    @FXML
    private TextField pet;

    @FXML
    private TextField phone,emailpatient;
    @FXML
    private Button enterdatapatient , back;
    @FXML
    private Label docid;
  
    
  
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
           lblDoctorName.setText(Doctor.s1);
           
            getDay_comb();
            rec2.setFill(new ImagePattern(new Image("/pic/pic4.jpg")));
            
            defaultImageDoctor();
        } catch (Exception ex) {
            properties.messageShow.showmessage("", ex.toString(), Alert.AlertType.ERROR);
        }
    }



    public void defaultImageDoctor() {
        try {
           
            Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
//             System.out.println( lblDoctorName.getText().trim());
            ResultSet resultSet = st.executeQuery("SELECT veterinary.cert_img FROM veterinary WHERE veterinary.Vet_Name='" + lblDoctorName.getText().trim() + "';");
            while (resultSet.next()) {
                if (resultSet.getString(1) == null) {
                   crDocImage.setFill(new ImagePattern(new Image("/pic/defult.png")));
                } else {
                    String r = "file:/" + resultSet.getString(1).replace("\\", "//");
//                    file:/"+"C://Users//computer market//Pictures//screen shot//i1.jpg
                    crDocImage.setFill(new ImagePattern(new Image(r)));
                }
            }
             
            databaseConnection.ConnectionDatabse.connect().close();
        } catch (SQLException ex) {
            properties.messageShow.showmessage("", "invaild path", Alert.AlertType.ERROR);
        } catch (Exception ex) {
            properties.messageShow.showmessage("", ex.toString(), Alert.AlertType.ERROR);
        }
    }
   @FXML
   public void back(){
    Doctor.switchPage(Doctor.Page.owner, 1000, 900);   
   }

    public void getDay_comb() {

        try {
            Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
            ResultSet resultSet = st.executeQuery("SELECT vet_appoint.day FROM vet_appoint WHERE Vet_Name='" + lblDoctorName.getText().trim() + "';");
            while (resultSet.next()) {
                String ss = resultSet.getString("day");
//                System.out.println(ss);
                combo_owner.getItems().add(ss);
            }
            resultSet.close();
            st.close();
            combo_owner.setPromptText("Select Day");
            databaseConnection.ConnectionDatabse.connect().close();

        } catch (SQLException ex) {
            //properties.messageShow.showmessage("", ex.toString(), Alert.AlertType.ERROR);
        } catch (Exception ex) {
            //properties.messageShow.showmessage("", ex.toString(), Alert.AlertType.ERROR);
        }
    }

  

    public void enterdata() {
        try {

            
            databaseConnection.ConnectionDatabse.insertdate("INSERT INTO vet_patient ( Vet_Name, Name, pet, day, phone,email)  VALUES ('" + lblDoctorName.getText() + "' , '" + namepatient.getText() + "' , '" + pet.getText() + "' , '" + combo_owner.getValue() + "' , '" + phone.getText() + "','"+emailpatient.getText()+"' ) ");
            //properties.messageShow.showmessage("", "Inserted You Data", Alert.AlertType.INFORMATION);
        } catch (Exception ex) {
            //properties.messageShow.showmessage("", ex.toString(), Alert.AlertType.ERROR);
        }
    }

    public void clear() {
        namepatient.setText("");
        phone.setText("");
        pet.setText("");
        emailpatient.setText("");
    }


}//end


