/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author computer market
 */
public class user_controller implements Initializable {

    @FXML
    private TableColumn<user_class, String> day;

    @FXML
    private TableColumn<user_class, String> doctor;

    @FXML
    private TableColumn<user_class, String> email;

    @FXML
    private TableColumn<user_class, String> name;

    @FXML
    private TableColumn<user_class, String> pet;

    @FXML
    private TableColumn<user_class, String> phone;

    @FXML
    private TableView<user_class> user_table;

    public ObservableList<user_class> getspacificdata(String url) {
        ObservableList<user_class> datalist = FXCollections.observableArrayList();
        try {

            Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
            ResultSet result = st.executeQuery(url);
            user_class date;
            while (result.next() == true) {
                date = new user_class(result.getString("Name"), result.getString("email"), result.getString("pet"), result.getString("phone"), result.getString("day"), result.getString("Vet_Name"));
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

            ObservableList<user_class> datalist;
            String sql = "SELECT Vet_Name,pet,day,phone,email,Name FROM vet_patient;";
            datalist = getspacificdata(sql);
            tablecontent();
            user_table.setItems(datalist);
        } catch (Exception ex) {
            //properties.messageShow.showmessage("warning", "select unit and difficulty", Alert.AlertType.ERROR);

        }

    }

    public void tablecontent() {

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        pet.setCellValueFactory(new PropertyValueFactory<>("pet"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        doctor.setCellValueFactory(new PropertyValueFactory<>("doc_name"));
        day.setCellValueFactory(new PropertyValueFactory<>("day"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showspacificdata();
    }

}
