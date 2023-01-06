/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;



/**
 *
 * @author pc
 */
public class Cheacked {

    
    public String username;
    public String password;
    public String phone;
    public String type;
    public String email;
    
    public Cheacked(String username, String password, String phone, String type,String email) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.type = type;
        this.email=email;
    }
    public Cheacked(String username, String password, String phone,String email) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email=email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
   public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;}


   

}
