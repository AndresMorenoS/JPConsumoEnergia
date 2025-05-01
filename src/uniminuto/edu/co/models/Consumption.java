package uniminuto.edu.co.models;

import java.time.Instant;

/**
 * Represents a Consumption entity, which tracks the amount of consumption
 * associated with a specific counter at a particular instant in time.
 */
public class Consumption {

    // The timestamp when the consumption was recorded
    private Instant instant;

    // The amount of consumption (e.g., energy, water, etc.)
    private Double amount;

    // The unique identifier of the counter associated with this consumption
    private String idCounter;

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