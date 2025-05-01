package uniminuto.edu.co.models;

import java.time.Instant;

public class Consumption {

    private Instant instant;
    private Double amount;
    private String idCounter;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(String idCounter) {
        this.idCounter = idCounter;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }
}
