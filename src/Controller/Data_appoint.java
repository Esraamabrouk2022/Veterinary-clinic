package Controller;

/**
 *
 * @author computer market
 */
public class Data_appoint {

    private String day;
    private String start;
    private String end;
    private String id;
    
    public Data_appoint(String day, String start, String end,String id) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.id = id;
       
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
   
}
