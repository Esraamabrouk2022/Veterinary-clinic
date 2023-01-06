
package Controller;
import Mainclass.Doctor;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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


public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox<String> combo_owner;
    @FXML
    private ComboBox<String> combo_owner1;
    @FXML
    Label lblDoctorName;
    @FXML
    TextField txtDay;
    @FXML
    TextField txtStartTime;
    @FXML
    TextField txtEndTime,idtxt;
    @FXML
    private TableColumn<Data_appoint, String> tc1;
    @FXML
    Button btnedit;
    @FXML
    Button plus , back;
    @FXML
    Button btninsert;
    @FXML
    Label l1, l2, l3, l4;
   
    @FXML
    private TableColumn<Data_appoint, String> tc2;
    @FXML
    private TableColumn<Data_appoint, String> tc4;
    @FXML
    private TableColumn<Data_appoint, String> tc3;

    @FXML
    private TableView<Data_appoint> tv;
    @FXML
    Label ll;
    @FXML
    Button btnnewForDoctor;
    @FXML
    private Hyperlink book;
    @FXML
    private Hyperlink myapp;
    @FXML
    private ImageView image;
    @FXML
    private Circle crDocImage;
    @FXML
    private Circle craddphoto;
    @FXML
    Rectangle recBackgroundMYAppoinment,shhhhh;
    @FXML
    Button btnNew;
    
    @FXML
    private Button enterdatapatient;
    @FXML
    private Label docid;
    @FXML
    private TableColumn<patient_show, Integer> idapp;
    @FXML
    private TableColumn<patient_show, String> pname;
    @FXML
    private TableColumn<patient_show, String> pnum;
    @FXML
    private TableColumn<patient_show, String> day;
    @FXML
    private TableColumn<patient_show, String> pett;
    @FXML
    private TableView<patient_show> tv2;

    
    
    @FXML
    public void back(){
            Doctor.switchPage(Doctor.Page.register, 600, 620);   

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
         lblDoctorName.setText(Doctor.s1);
            showspacificdata();
            showspacificdata2();
            btnedit.setDisable(true);
           
        
            recBackgroundMYAppoinment.setFill(new ImagePattern(new Image("/pic/pic3.jpg")));

            shhhhh.setFill(new ImagePattern(new Image("/pic/pic6.jpg")));
            craddphoto.setFill(new ImagePattern(new Image("/pic/camera.png")));
            defaultImageDoctor();
            tv.setStyle("-fx-background-color:transparent");
            btnNew.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    btninsert.setDisable(false);
                    btnedit.setDisable(true);
                    txtDay.clear();
                    txtEndTime.clear();
                    txtStartTime.clear();
                    //getmaxId();

                }
            });
        } catch (Exception ex) {
           properties.messageShow.showmessage("", ex.toString(), Alert.AlertType.ERROR);
        }
    }

    public ObservableList<Data_appoint> getspacificdata(String url) {
        ObservableList<Data_appoint> datalist = FXCollections.observableArrayList();
        try {

            Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
            ResultSet result = st.executeQuery(url);
            Data_appoint date;
            while (result.next() == true) {
                date = new Data_appoint(result.getString("app_id"),result.getString("day"), result.getString("start"), result.getString("end"));
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

            ObservableList<Data_appoint> datalist;
            String sql = "SELECT vet_appoint.app_id,vet_appoint.day,vet_appoint.start,vet_appoint.end FROM vet_appoint where Vet_Name='"+lblDoctorName.getText().trim()+"' ;";
            datalist = getspacificdata(sql);
            tablecontent();
            tv.setItems(datalist);
        } catch (Exception ex) {
            //properties.messageShow.showmessage("warning", "select unit and difficulty", Alert.AlertType.ERROR);
            
        }

    }

    public void tablecontent() {

        tc4.setCellValueFactory(new PropertyValueFactory<>("id"));
        tc1.setCellValueFactory(new PropertyValueFactory<>("day"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("start"));
        tc3.setCellValueFactory(new PropertyValueFactory<>("end"));
    }

    public void slectrow() {
        int row = tv.getSelectionModel().getSelectedIndex();//index
        Data_appoint dat = tv.getSelectionModel().getSelectedItem();//data
        if (row < 0) {
            return;
        }
        btnedit.setDisable(false);
        btninsert.setDisable(true);
        idtxt.setText(String.valueOf(dat.getId()));
        txtDay.setText(String.valueOf(dat.getDay()));
        txtStartTime.setText(String.valueOf(dat.getStart()));
        txtEndTime.setText(String.valueOf(dat.getEnd()));
        txtDay.setDisable(false);
        txtEndTime.setDisable(false);
        txtStartTime.setDisable(false);

    }

    public void insertdate() {

        
        String stDay = txtDay.getText().trim();
        String ststarttime = txtStartTime.getText().trim();
        String stendtime = txtEndTime.getText().trim();
        if (ststarttime.equals("") || stendtime.equals("") || idtxt.equals("")) {
            
        } else {

            databaseConnection.ConnectionDatabse.insertdate("insert into vet_appoint(day,start,end,Vet_Name) values ('" + ststarttime + "','" + stendtime + "','" + idtxt.getText() + "','"+lblDoctorName.getText().trim()+"');");
            //properties.messageShow.showmessage("", "inserted date", Alert.AlertType.INFORMATION);
            showspacificdata();

            txtDay.clear();
            txtEndTime.clear();
            txtStartTime.clear();
            idtxt.clear();
        }
    }

    public void updatedate() {
         
        String stDay = txtDay.getText().trim();
        String ststarttime = txtStartTime.getText().trim();
        String stendtime = txtEndTime.getText().trim();
        if (stDay.equals("") || ststarttime.equals("") || stendtime.equals("")) {
            //properties.messageShow.showmessage("", "Enter all imformation", Alert.AlertType.WARNING);
        } else {
            int row = tv.getSelectionModel().getSelectedIndex();//index
            databaseConnection.ConnectionDatabse.insertdate("update vet_appoint set day='" + ststarttime + "',start='" + stendtime + "',end='" + idtxt.getText() + "' WHERE  app_id='"+txtDay.getText()+"'  ");
            properties.messageShow.showmessage("", "updated", Alert.AlertType.INFORMATION);
            showspacificdata();
            btnedit.setDisable(true);
            btninsert.setDisable(false);
            txtDay.clear();
            txtEndTime.clear();
            txtStartTime.clear();
            idtxt.clear();

        }

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
                Image myimage = new Image(fseleced.toURI().toString());
                crDocImage.setFill(new ImagePattern(myimage));

//                System.out.println((fseleced.toString()).replaceAll("\\", "\\"));;
                databaseConnection.ConnectionDatabse.insertdate("UPDATE veterinary SET cert_img='" + t + "' WHERE Vet_Name='" + lblDoctorName.getText().trim() + "';");

            } else {

            }
        } catch (Exception ex) {
         properties.messageShow.showmessage("", ex.toString(), Alert.AlertType.ERROR);

        }
    }

    public void defaultImageDoctor() {
        try {
            Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
            ResultSet resultSet = st.executeQuery("SELECT veterinary.cert_img FROM veterinary WHERE veterinary.Vet_Name='" +lblDoctorName.getText().trim() + "';");
            while (resultSet.next()) {
                if (resultSet.getString(1)==null ) {
                    crDocImage.setFill(new ImagePattern(new Image("/pic/defult.png")));
                } else {
                    String r = "file:/" + resultSet.getString(1).replace("\\", "//");
//                    file:/"+"C://Users//computer market//Pictures//screen shot//i1.jpg
                    crDocImage.setFill(new ImagePattern(new Image(r)));
                }
            }
                                //crDocImage.setFill(new ImagePattern(new Image("/pic/defult.png")));

            databaseConnection.ConnectionDatabse.connect().close();
        } catch (SQLException ex) {
            properties.messageShow.showmessage("", "invaild path", Alert.AlertType.ERROR);
        } catch (Exception ex) {
            properties.messageShow.showmessage("", ex.toString(), Alert.AlertType.ERROR);
        }
    }

    

public ObservableList<patient_show> getspacificdata2(String url) {
        ObservableList<patient_show> datalist = FXCollections.observableArrayList();
        try {

            Statement st = databaseConnection.ConnectionDatabse.connect().createStatement();
            ResultSet result = st.executeQuery(url);
            patient_show date;
            while (result.next() == true) {
                date = new patient_show(result.getInt(1), result.getString("Name"), result.getString("phone"), result.getString("pet"),result.getString("day"));
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

    public void showspacificdata2() {
        try {

            ObservableList<patient_show> datalist;
            String sql = "SELECT app_id,Name,phone,pet,day FROM vet_patient   ;";
            datalist = getspacificdata2(sql);
            tablecontent2();
            tv2.setItems(datalist);
        } catch (Exception ex) {
           // properties.messageShow.showmessage("warning", "select unit and difficulty", Alert.AlertType.ERROR);
        }

    }

    public void tablecontent2() {

        idapp.setCellValueFactory(new PropertyValueFactory<>("id"));
        pname.setCellValueFactory(new PropertyValueFactory<>("name"));
        pnum.setCellValueFactory(new PropertyValueFactory<>("phone"));
        pett.setCellValueFactory(new PropertyValueFactory<>("pet"));
        day.setCellValueFactory(new PropertyValueFactory<>("day"));
    }

}//end
