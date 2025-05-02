package uniminuto.edu.co.models;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

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


    private LocalDateTime dateTime;
    public void RecordCons(Instant instant, double kwh){
        this.instant = instant;
        this.kwh = kwh;
    }

        /**
         * Gets the calculate consumption
         * @return the calculate of consumption
         */
    public double calculatePrice() {
        int hour = dateTime.getHour();
            if (hour <= 6 && kwh >= 100 && kwh <= 300) {
                return kwh * 200;
            } else if (hour >= 7 && hour <= 17 && kwh > 300 && kwh <= 600) {
                return kwh * 300;
            } else if (hour >= 18 && kwh > 600 && kwh <= 1000) {
                return kwh * 500;
            } else {
                return 0;
            }
    }
    public <ClientnotReg, RecordEnergy> double calculateConsum(List<ClientnotReg> clients, int year, int month, double consum){
        double total = 0;
        for (ClientnotReg client : clients) {
            for (RecordEnergy record : client.getClass()) {
                int days = LocalDate.of(year, month, 1).lengthOfMonth();

                for (int day = 1; day <= days; day++) {
                    for (int hour = 0; hour < 24; hour++) {
                        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, 0);

                        Consumption c = new Consumption();
                        c.RecordCons(Instant.from(dateTime), consum);
                        c.setIdCounter(record.getClass());
                        double valor = c.calculatePrice();
                        total += amount;
                    }
                }
            }
        }
        return total;
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

}