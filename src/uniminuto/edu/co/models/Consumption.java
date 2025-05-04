package uniminuto.edu.co.models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



/**
 * Represents a Consumption entity, which tracks the amount of consumption
 * associated with a specific counter at a particular instant in time.
 */
public class Consumption {
    // The timestamp when the consumption was recorded
    private Instant instant;
    // The amount of consumption (e.g., energy, water, etc.)
    private double amount;
    // The unique identifier of the counter associated with this consumption
    private String idCounter;

    private double kwh;

    public void RecordCons(Instant instant, double kwh, String idCounter){
        this.instant = instant;
        this.kwh = kwh;
        this.idCounter = idCounter;
    }

    public void recordConsuption(Instant instant , double kwh){
        this.instant = instant;
        this.kwh = kwh;
    }
    /**
     * Gets the amount of consumption.
     * @return The amount of consumption.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of consumption.
     * @param amount The amount of consumption to set.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Gets the ID of the counter associated with this consumption.
     * @return The counter ID.
     */
    public String getIdCounter() {
        return idCounter;
    }


    /**
     * Sets the ID of the counter associated with this consumption.
     * @param idCounter The counter ID to set.
     */
    public void setIdCounter(String idCounter) {
        this.idCounter = idCounter;
    }

    /**
     * Gets the timestamp of when the consumption was recorded.
     * @return The timestamp as an Instant.
     */
    public Instant getInstant() {
        return instant;
    }

    /**
     * Sets the timestamp of when the consumption was recorded.
     * @param instant The timestamp to set.
     */
    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public double getKwh() {
        return kwh;
    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static class ConsumptionService {
        /**
         * Filters consumptions for a specific month and year.
         * @param allConsumptions Complete list of consumptions.
         *@param month Month (1-12).
         * @param year Year (e.g., 2025).
         * @return List of filtered consumptions.
         */
        public static List<Consumption> loadMonthlyConsumption(List<Consumption> allConsumptions, int month, int year) {
            return allConsumptions.stream() 
                .filter(c -> {                  
                    if (c == null || c.getInstant() == null) {
                        return false; 
                    } 
                    LocalDateTime dateTime = LocalDateTime.ofInstant(c.getInstant(), ZoneId.systemDefault());                   
                    return dateTime.getMonthValue() == month && dateTime.getYear() == year;   
                }) 
                .collect(Collectors.toList()); 
        } 
    
    }
    /**
     * Calcula la tarifa a pagar para un consumo según la hora y kWh.
     * @param c Objeto consumo.
     * @return Valor total a pagar.
     */
    public static double calculateTarif(Consumption c){
        int hour = LocalDateTime.ofInstant(c.getInstant(), ZoneId.systemDefault()).getHour();
        double kwh = c.getKwh();
        if (hour <= 6 && kwh >= 100 && kwh <= 300) {
            return kwh * 200;
        } else if (hour >= 7 && hour <= 17 && kwh > 300 && kwh <= 600) {
            return kwh * 300;
        } else if (hour >= 18 && kwh > 600 && kwh <= 1000) return kwh * 500;
        else {
            return 0;
        }
    }
}
