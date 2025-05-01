package uniminuto.edu.co.models;


import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Date;

public class Counter {

    private final String id;
    private String address;
    private String city;
    private Date date;

    public Counter(String id, String address, String city) {
        this.id = id;
        this.address = address;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void update(Counter counter){
        if(!counter.getAddress().isBlank()) this.address = counter.getAddress();
        if(!counter.getCity().isBlank()) this.city = counter.getCity();
    }

    public void results(Integer year, Integer month){
        if(date.toInstant().get(ChronoField.YEAR) == year && date.toInstant().get(ChronoField.MONTH_OF_YEAR) == month){
            //return ....;
        }
    }

}
