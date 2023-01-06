/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Alert;


public class ConnectionDatabse {

    public static String url = "jdbc:mysql://localhost/jdbc";
    public static String usrename = "root";
    public static String password = "";
    public static Connection conn;
    public static Statement st;
    public static ResultSet result;

    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usrename, password);
        } catch (Exception ex) {

        }
        return conn;
    }

    public static void insertdate(String query) {
        try {
            st = connect().createStatement();
            st.executeUpdate(query);
            st.close();
            conn.close();
        } catch (Exception ex) {
            properties.messageShow.showmessage("Error", ex.toString(), Alert.AlertType.ERROR);
        }

    }


}
