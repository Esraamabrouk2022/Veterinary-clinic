package Mainclass;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Doctor extends Application {

    private static Stage stage;
    public static String s1;
    public static String nameowner;
    public static boolean opensearch = false;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        switchPage(Page.first, 600, 621);
        stage.show();
    }

    public enum Page {
        login, register, first, second, third, fourth, loading, owner, search, openadmin, petprofile, profile, appoint, admin, doc, user, book_appoinment, searchAdmin, newpetprofile
    };

    public synchronized static void switchPage(Page page, int width, int height) {
        URL url = null;
        switch (page) {
            case first:
                url = Doctor.class.getResource("/FXML/two.fxml");
                break;
            case second:
                url = Doctor.class.getResource("/FXML/one.fxml");
                break;
            case third:
                url = Doctor.class.getResource("/FXML/Three.fxml");
                break;
            case fourth:
                url = Doctor.class.getResource("/FXML/four.fxml");
                break;
            case login:
                url = Doctor.class.getResource("/FXML/FXMLDocument.fxml");
                break;
            case register:
                url = Doctor.class.getResource("/FXML/Register.fxml");
                break;
            case loading:
                url = Doctor.class.getResource("/FXML/loading.fxml");
                break;
            case owner:
                url = Doctor.class.getResource("/FXML/ownerpage.fxml");
                break;
            case search:
                url = Doctor.class.getResource("/FXML/petsearch.fxml");
                break;

            case petprofile:
                url = Doctor.class.getResource("/FXML/petprofile.fxml");
                break;
            case profile:
                url = Doctor.class.getResource("/FXML/profile.fxml");
                break;
            case appoint:
                url = Doctor.class.getResource("/FXML/appoint_1.fxml");
                break;
            case book_appoinment:
                url = Doctor.class.getResource("/FXML/book_appoinment.fxml");
                break;
            case admin:
                url = Doctor.class.getResource("/FXML/admin.fxml");
                break;
            case doc:
                url = Doctor.class.getResource("/FXML/doc.fxml");
                break;
            case user:
                url = Doctor.class.getResource("/FXML/user.fxml");
                break;
            case openadmin:
                url = Doctor.class.getResource("/FXML/open_admin.fxml");
                break;
            case searchAdmin:
                url = Doctor.class.getResource("/FXML/search_admin.fxml");
                break;
            case newpetprofile:
                url = Doctor.class.getResource("/FXML/new_pet_profiles.fxml");
                break;
            // Keep going ya saroaa
            // I am proud of you and your effort
        }
        if (url != null) {
            try {
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root, width, height);
                stage.setScene(scene);

            } catch (IOException ex) {
                Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
