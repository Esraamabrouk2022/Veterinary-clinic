package Controller;

/**
 *
 * @author computer market
 */
public class find_doctor {
   private String name;
   private String phone;
   //private Integer id;
   private String email;

    public find_doctor(String name, String phone,  String email) {
        this.name = name;
        this.phone = phone;
        
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

//    public Integer getId() {
//        return id;
//    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
