package uniminuto.edu.co.models;

public class Consumption {

    // Matrix to store energy consumption by day and hour
    private double[][] consumptionMatrix;
    // Number of hours in a day
    private final int hours;
    // Number of days in a month
    private int days;
    // Unique identifier for the associated meter
    private String idCounter;

    private double kwh;

    // Constructor to initialize the matrix
    public Consumption(int days, int hours) {
        this.hours = hours;
        this.consumptionMatrix = new double[days][hours];
    }

    /**
     * Records energy consumption in the matrix for a specific day and hour, and updates the meter ID.
     * @param day Day of the month (1-31).
     * @param hour Hour of the day (0-23).
     * @param kwh Amount of kilowatt-hours consumed.
     * @param idCounter Meter identifier.
     */
    public void mRecordConsumptionWithId(int day, int hour, double kwh, String idCounter) {
        // Validate that the day and hour are within the allowed range
        if (day < 1 || day > consumptionMatrix.length || hour < 0 || hour >= hours) {
            throw new IllegalArgumentException("Day or hour out of range.");
        }
        // Update the matrix and set the meter identifier
        this.consumptionMatrix[day - 1][hour] = kwh;
        this.idCounter = idCounter;
    }

    /**
     * Records energy consumption in the matrix for a specific day and hour (without updating the meter ID).
     * @param day Day of the month (1-31).
     * @param hour Hour of the day (0-23).
     * @param kwh Amount of kilowatt-hours consumed.
     */
    public void mRecordConsumption(int day, int hour, double kwh) {
        // Validate that the day and hour are within the allowed range
        if (day < 1 || day > consumptionMatrix.length || hour < 0 || hour >= hours) {
            throw new IllegalArgumentException("Day or hour out of range.");
        }
        // Update the matrix
        this.consumptionMatrix[day - 1][hour] = kwh;
    }

    /**
     * Retrieves the energy consumption recorded for a specific day and hour.
     * @param day Day of the month (1-31).
     * @param hour Hour of the day (0-23).
     * @return Energy consumption in kWh.
     */
    public double mGetConsumptionByDayAndHour(int day, int hour) {
        // Validate that the day and hour are within the allowed range
        if (day < 1 || day > consumptionMatrix.length || hour < 0 || hour >= hours) {
            throw new IllegalArgumentException("Day or hour out of range.");
        }
        // Return the consumption value from the matrix
        return this.consumptionMatrix[day - 1][hour];
    }

    // Getters and setters for other attributes
    public String getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(String idCounter) {
        this.idCounter = idCounter;
    }

    public double getKwh() {
        return kwh;
    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    public double calculateTariff(int day, int hour){
        double kwh = mGetConsumptionByDayAndHour(day,hour);
        if (kwh == 0)return 0;

        if (hour <= 6 && kwh >= 100 && kwh <= 300){
            return kwh * 200;
        } else if (hour >= 7 && hour <= 17 && kwh > 300 && kwh <= 600){
            return kwh * 300;
        } else if (hour >= 18 && hour <= 23 && kwh > 600 && kwh <= 1000){
            return kwh * 500;
        }else {
            return 0;
        }
    }
    public double getTotalMonthlyKwh(){
        double total = 0;
        for(int day = 0; day < consumptionMatrix.length; day++){
            for (int hour = 0; hour < hours; hour++){
                total+= consumptionMatrix[day][hour];
            }
        }
        return total;
    }

    public double getTotalMonthlyPayment(){
        double total = 0;
        for(int day = 0; day < consumptionMatrix.length; day++){
            for( int hour = 0; hour < hours; hour++){
                total += calculateTariff(day+1,hour);
            }
        }
        return total;
    }

}
