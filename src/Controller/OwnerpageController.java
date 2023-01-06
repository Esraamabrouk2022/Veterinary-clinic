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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class OwnerpageController implements Initializable {
    
     @FXML
    private Circle circle;
    @FXML
    private TextField nametf;

    @FXML
    private TextField phonetf;
    @FXML
    private TextField emailtf;
   @FXML
   public Button search , addprofile , logout;

   @FXML
    private Label label_name;
    
   @FXML
    private Rectangle rect;
   
   @FXML
    private TableView<find_doctor> doc;

    @FXML
    private TableColumn<find_doctor, String> docemail;

    @FXML
    private TableColumn<find_doctor, Integer> docid;

    @FXML
    private TableColumn<find_doctor, String> docname;

    @FXML
    private TableColumn<find_doctor, String> docphone;

   @FXML
   public void petsearch(){
            Doctor.switchPage(Doctor.Page.search,599,374);
   }
   
   @FXML
   public void addpetprofile(){
       Doctor.switchPage(Doctor.Page.petprofile,600,400);
   }
   
   @FXML
   public void logout(){
       Stage stage = (Stage) logout.getScene().getWindow();
        stage.close();
   }
   //    }
    public ObservableList<find_doctor> getspacificdata(String url) {
        ObservableList<find_doctor> datalist = FXCollections.observableArrayList();
        try {

            Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
            ResultSet result = st.executeQuery(url);
            find_doctor date;
            while (result.next() == true) {
                date = new find_doctor(result.getString("Vet_Name"), result.getString("Phone"),result.getString("email"));
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

            ObservableList<find_doctor> datalist;
            String sql = "SELECT Vet_Name,Phone,email FROM veterinary;";
            datalist = getspacificdata(sql);
            tablecontent();
            doc.setItems(datalist);
        } catch (Exception ex) {
            properties.messageShow.showmessage("warning", "select unit and difficulty", Alert.AlertType.ERROR);
        }

    }

    public void tablecontent() {
        //docid.setCellValueFactory(new PropertyValueFactory<>("id"));
        docname.setCellValueFactory(new PropertyValueFactory<>("name"));
        docphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        docemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
    }
    public void slectrow() throws SQLException {
        int row = doc.getSelectionModel().getSelectedIndex();//index
        find_doctor doctor = doc.getSelectionModel().getSelectedItem();//data
        if (row < 0) {
            return;
        }else{
        nametf.setText(String.valueOf(doctor.getName()));
        phonetf.setText(String.valueOf(doctor.getPhone()));
        emailtf.setText(String.valueOf(doctor.getEmail()));
        photo();
        Doctor.s1=nametf.getText();
        }
    }
   public void photo() throws SQLException{
       Statement st=databaseConnection.ConnectionDatabse.connect().createStatement();
       String sel="SELECT cert_img FROM veterinary WHERE Vet_Name='"+nametf.getText()+"';";
       ResultSet resultSet= st.executeQuery(sel);
       while (resultSet.next()) {

                if (resultSet.getString(1)==null ) {
                    rect.setFill(new ImagePattern(new Image("/pic/defult.png")));
                } else {
                    String r = "file:/" + resultSet.getString(1).replace("\\", "//");
                    rect.setFill(new ImagePattern(new Image(r)));
                }
            }
   }
   
   @FXML
    void choose_doctor(ActionEvent event) {
        if(nametf.getText().isEmpty()||phonetf.getText().isEmpty()||emailtf.getText().isEmpty()){
            
        }
        else{
      Doctor.switchPage(Doctor.Page.book_appoinment, 637, 900);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     label_name.setText(Doctor.s1);
     showspacificdata();
     circle.setFill(new ImagePattern(new Image("/pic/defult.png")));
    }    
    
}
