package uniminuto.edu.co.models;

import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * Represents a Counter entity, which is associated with a client and tracks consumption data.
 */
public class Counter {

    // Unique identifier for the counter
    private final String id;

    // Address where the counter is located
    private String address;

    // City where the counter is located
    private String city;

    // Date when the counter was created or registered
    private Date date;

    private final List<Consumption> records;
    /**
     * Constructor to initialize a Counter with its ID, address, and city.
     * @param id Unique identifier for the counter.
     * @param address Address of the counter.
     * @param city City where the counter is located.
     */
    public Counter(String id, String address, String city) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.records = new ArrayList<>();
    }

    public void recordingCons(Consumption r){
        records.add(r);
    }
    // Getter for the counter's ID
    public String getId() {
        return id;
    }

    // Getter for the counter's address
    public String getAddress() {
        return address;
    }

    // Setter to update the counter's address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for the counter's city
    public String getCity() {
        return city;
    }

    // Setter to update the counter's city
    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Consumption> getRecords() {
        return records;
    }

    /**
     * Updates the current counter's address and city based on another counter object.
     * @param counter Counter object containing the new address and city.
     */
    public void update(Counter counter) {
        // Update address if the new address is not blank
        if (!counter.getAddress().isBlank()) this.address = counter.getAddress();

        // Update city if the new city is not blank
        if (!counter.getCity().isBlank()) this.city = counter.getCity();
    }

    /**
     * Filters results based on the year and month provided.
     * This method is connected to the `Consumption` class, as it would typically
     * retrieve consumption data for the specified period.
     * @param year Year to filter results.
     * @param month Month to filter results.
     */
    public void results(Integer year, Integer month) {
        // Check if the counter's date matches the provided year and month
        if (date.toInstant().get(ChronoField.YEAR) == year &&
                date.toInstant().get(ChronoField.MONTH_OF_YEAR) == month) {
            // Logic to return or process results would go here
        }
    }
}