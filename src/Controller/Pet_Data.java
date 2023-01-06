/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author pc
 */
public class Pet_Data {

    public IntegerProperty petid;
    public StringProperty petname;
    public StringProperty petgender;
    public StringProperty ownername;
    public StringProperty doctorname;
    public StringProperty appointment;

    public Pet_Data(int petid, String petname, String petgender, String ownername, String doctorname, String appointment) {
        
        this.petid= new SimpleIntegerProperty(petid);
        this.petname= new SimpleStringProperty(petname);
        this.petgender=new SimpleStringProperty(petgender);
        this.ownername=new SimpleStringProperty(ownername);
        this.doctorname=new SimpleStringProperty(doctorname);
        this.appointment=new SimpleStringProperty(appointment);
        

    }
    
    public IntegerProperty petidProperty(){
        return petid;
        
    }
    
    
    public StringProperty petnameProperty(){
        return petname;
    }
    public StringProperty petgenderProperty(){
        return petgender;
    }

    public StringProperty ownernameProperty(){
        return ownername;
    }

    public StringProperty doctornameProperty(){
        return doctorname;
    }

    public StringProperty appointmentProperty(){
        return appointment;
    }


}
