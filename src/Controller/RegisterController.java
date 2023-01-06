package Controller;

import java.sql.Statement;
import java.sql.ResultSet;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Mainclass.Doctor;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.FileChooser;

public class RegisterController implements Initializable {

    String name, pass;
    int i = 0, j = 0;
//    @FXML
//    public Hyperlink signup, login;

    @FXML
    public Button first, second, third, fourth, clear, exit, signup, setimage1, clear1, exit1, signup1;

    @FXML
    public TextField usernametf, email, phototf1, phonetf1, usernametf1;
    @FXML
    private PasswordField passwordtf, passwordtf1;
    @FXML
    public ComboBox combobox, combobox1;

    @FXML
    public void first() {
        Doctor.switchPage(Doctor.Page.first, 600, 650);
    }

    @FXML
    public void second() {
        Doctor.switchPage(Doctor.Page.second, 600, 650);
    }

    @FXML
    public void third() {
        Doctor.switchPage(Doctor.Page.third, 600, 650);
    }

    @FXML
    public void fourth() {
        Doctor.switchPage(Doctor.Page.fourth, 600, 650);
    }

    @FXML
    public void toLogin() {
        Doctor.switchPage(Doctor.Page.register, 600, 650);
    }

    @FXML
    public void clearData() {
        usernametf.setText("");
        passwordtf.setText("");
//        numidtf1.setText("");
//        phototf1.setText("");
//        phonetf1.setText("");
        combobox.setValue("");
    }

    @FXML
    public void clearData1() {
        usernametf1.setText("");
        passwordtf1.setText("");
//        numidtf1.setText("");
        phototf1.setText("");
        phonetf1.setText("");
        combobox1.setValue("");
    }

    @FXML
    public void exitWind() {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void reUsertf() {
        usernametf.setText("");
        usernametf.setStyle("-fx-text-fill:black; -fx-border-color: black ;");

    }

    @FXML
    public void rePasstf() {
        passwordtf.setText("");
        passwordtf.setStyle("-fx-text-fill:black; -fx-border-color: black ;");

    }

    @FXML
    public void reNumtf() {
        email.setText("");
        email.setStyle("-fx-text-fill:black; -fx-border-color: black ;");
    }

    @FXML
    public void rephototf() {
        phototf1.setText("");
        phototf1.setStyle("-fx-text-fill:black; -fx-border-color: black ;");

    }

    @FXML
    public void reteletf() {
        phonetf1.setText("");
        phonetf1.setStyle("-fx-text-fill:black; -fx-border-color: black ;");
    }

    public void chooseimage() {
        try {
            FileChooser filechooser = new FileChooser();
            filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("image", "*.png", "*.jpg", "*.jpeg", "*.apng", "*.avif", "*.gif", "*.pjp", "*.pjpeg", "*.jfif", "*.apng"));
            File fseleced = filechooser.showOpenDialog(null);

//            System.out.println(fseleced);
            String t = fseleced.toString();
            t = t.replaceAll("\\\\", "\\\\\\\\");
//             System.out.println(t);
            if (fseleced != null) {
                phototf1.setText(t);
                databaseConnection.ConnectionDatabse.insertdate("UPDATE veterinary SET Img='" + t + "' WHERE Vet_Name='" + usernametf1.getText().trim() + "';");

            } else {

            }
        } catch (Exception ex) {
            properties.messageShow.showmessage("", ex.toString(), Alert.AlertType.ERROR);

        }
    }

    public void setPhoto() {
        chooseimage();
    }

    @FXML
    public void login() throws SQLException {
        if ("".equals(usernametf.getText()) || "".equals(passwordtf.getText()) || "".equals(combobox.getValue())) {
            usernametf.setText("Requierd");
            usernametf.setStyle("-fx-text-fill:red; -fx-border-color: red ;");
            passwordtf.setText("Requierd");
            passwordtf.setStyle("-fx-text-fill:red; -fx-border-color: red ;");
            combobox.setStyle("-fx-border-color: red ;");

        } else {
            if (combobox.getValue() == "owner") {
                log("owner");

            } else if (combobox.getValue() == "veterinary") {
                log("veterinary");

            } else if (combobox.getValue() == "admin") {
                log("admin");
                Doctor.switchPage(Doctor.Page.openadmin, 469, 181);

            }
        }

    }

    @FXML
    public void signup() throws SQLException {
        if ("".equals(usernametf1.getText()) || "".equals(passwordtf1.getText()) || "".equals(email.getText()) || "".equals(phonetf1.getText())) {
            usernametf1.setText("Requierd");
            usernametf1.setStyle("-fx-text-fill:red; -fx-border-color: red ;");
            passwordtf1.setText("Requierd");
            passwordtf1.setStyle("-fx-text-fill:red; -fx-border-color: red ;");
            email.setText("Requierd");
            email.setStyle("-fx-text-fill:red; -fx-border-color: red ;");
            phonetf1.setText("Requierd");
            phonetf1.setStyle("-fx-text-fill:red; -fx-border-color: red ;");

        } else {
            if (combobox1.getValue() == "owner") {
                reg("owner");
                //Doctor.switchPage(Doctor.Page.owner, 1000, 600);

            } else if (combobox1.getValue() == "veterinary") {
                reg("veterinary");
                //Doctor.switchPage(Doctor.Page.appoint, 637, 900);

            }
        }

    }

//    public void getmaxId() {
//        try {
//
//            Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
//            ResultSet resultSet = st.executeQuery("SELECT MAX(Own_Id) FROM owner;");
//
//            while (resultSet.next()) {
//                if (resultSet.getString(1) == null) {
//                    numidtf1.setText("1");
//
//                } else {
//                    int x = Integer.valueOf(resultSet.getString(1)) + 1;
//                    numidtf1.setText(String.valueOf(x));
//
//                }
//                System.out.println(numidtf1.getText());
//            }
//
//        } catch (SQLException ex) {
//            properties.messageShow.showmessage("", ex.toString(), Alert.AlertType.ERROR);
//        } catch (Exception ex) {
//            properties.messageShow.showmessage("", ex.toString(), Alert.AlertType.ERROR);
//        }
//
//    }
//
//    public void getmaxId2() {
//        try {
//
//            Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
//            ResultSet resultSet = st.executeQuery("SELECT MAX(Vet_Id) FROM veterinary;");
//
//            while (resultSet.next()) {
//                if (resultSet.getString(1) == null) {
//                    numidtf1.setText("1");
//                } else {
//                    int x = Integer.valueOf(resultSet.getString(1)) + 1;
//                    numidtf1.setText(String.valueOf(x));
//                }
//                System.out.println(numidtf1.getText());
//
//            }
//
//        } catch (SQLException ex) {
//
//        } catch (Exception ex) {
//
//        }
//
//    }
    @FXML
    public void select() {
        if (combobox1.getSelectionModel().getSelectedItem() != "veterinary") {
            phototf1.setVisible(false);
            setimage1.setVisible(false);
            //getmaxId();

        } else {
            //getmaxId2();
        }

    }

    public void log(String m) throws SQLException {
        String sel;
        Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
        if ("owner".equals(m)) {
            sel = "SELECT Own_Name,Password FROM owner WHERE Own_Name ='" + usernametf.getText() + "' AND Password ='" + passwordtf.getText() + "'";
        } else if ("veterinary".equals(m)) {
            sel = "SELECT Vet_Name,Password FROM veterinary WHERE Vet_Name ='" + usernametf.getText() + "' AND Password ='" + passwordtf.getText() + "'";

        } else {
            sel = "SELECT Admin_Name,Admin_Pass FROM admin WHERE Admin_Name ='" + usernametf.getText() + "' AND Admin_Pass ='" + passwordtf.getText() + "'";
        }

        Doctor.s1 = usernametf.getText();

        ResultSet rst = st.executeQuery(sel);
        while (rst.next()) {
            if (rst.getString(1).equals(usernametf.getText()) && rst.getString(2).equals(passwordtf.getText())) {
                if (combobox.getValue() == "owner") {
                    Doctor.switchPage(Doctor.Page.owner, 1000, 600);
                } else if (combobox.getValue() == "veterinary") {
                    Doctor.switchPage(Doctor.Page.appoint, 630, 900);
                } else if (combobox.getValue() == "admin") {
                    Doctor.switchPage(Doctor.Page.openadmin, 729, 600);
                }
            } else {
                properties.messageShow.showmessage("", "You should sign up frist", Alert.AlertType.INFORMATION);
            }
        }

    }

    public void reg(String m) throws SQLException {

        if ("owner".equals(m)) {

            databaseConnection.ConnectionDatabse.insertdate("INSERT INTO whaiting_cheack (Name,Password,Phone,email,Type) VALUES ( '" + usernametf1.getText() + "','" + passwordtf1.getText() + "','" + phonetf1.getText() + "','" + email.getText() + "','owner')");
            properties.messageShow.showmessage("", "Wait a mintue", Alert.AlertType.INFORMATION);
        } else if ("veterinary".equals(m)) {
            databaseConnection.ConnectionDatabse.insertdate("INSERT INTO whaiting_cheack (Name,Password,Phone,email,Type) VALUES ('" + usernametf1.getText() + "','" + passwordtf1.getText() + "','" + phonetf1.getText() + "','" + email.getText() + "','veterinary')");
            properties.messageShow.showmessage("", "Wait a mintue", Alert.AlertType.INFORMATION);
        }
//else {
//            databaseConnection.ConnectionDatabse.insertdate("INSERT INTO admin (Num_Id,Admin_Name,Admin_pass,Phone) VALUES ('" + email.getText() + "','" + usernametf1.getText() + "','" + passwordtf1.getText() + "','" + phonetf1.getText() + "')");
//        }
        Doctor.s1 = usernametf1.getText();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (combobox1 != null) {
            combobox1.getItems().add("owner");
            combobox1.getItems().add("veterinary");
            //combobox1.getItems().add("admin");

        }
        if (combobox != null) {
            combobox.getItems().add("owner");
            combobox.getItems().add("veterinary");
            combobox.getItems().add("admin");

        }

    }

}
