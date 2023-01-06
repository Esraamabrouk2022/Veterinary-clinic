/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author computer market
 */
public class patient_show {

    private Integer id;
    private String name;
    private String phone;
    private String pet;
    private String day;
    

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPet() {
        return pet;
    }

    public String getDay() {
        return day;
    }

    

    public patient_show(Integer id, String name, String phone, String pet, String day) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.pet = pet;
        this.day = day;
        
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public void setDay(String day) {
        this.day = day;
    }

    

}
