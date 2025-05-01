package uniminuto.edu.co.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Client entity, which contains information about a client
 * and their associated counters.
 */
public class Client {

    // Unique identifier for the client
    private final String id;

    // Name of the client
    private String name;

    // Email address of the client
    private String email;

    // Physical address of the client
    private String address;

    // Type of identifier (e.g., CC, CE, TI, NIT)
    private Identifiers identifier;

    // List of counters associated with the client
    private List<Counter> counters;

    /**
     * Constructor to initialize a Client with a single counter.
     * @param id Unique identifier for the client.
     * @param name Name of the client.
     * @param email Email address of the client.
     * @param address Physical address of the client.
     * @param identifier Type of identifier for the client.
     * @param counter A single counter to associate with the client.
     */
    public Client(String id, String name, String email, String address, Identifiers identifier, Counter counter) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.identifier = identifier;

        // Initialize the list of counters and add the provided counter
        this.counters = new ArrayList<>();
        this.counters.add(counter);
    }

    /**
     * Constructor to initialize a Client with multiple counters.
     * @param id Unique identifier for the client.
     * @param name Name of the client.
     * @param email Email address of the client.
     * @param address Physical address of the client.
     * @param identifier Type of identifier for the client.
     * @param counters List of counters to associate with the client.
     */
    public Client(String id, String name, String email, String address, Identifiers identifier, List<Counter> counters) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.identifier = identifier;
        this.counters = counters;
    }

    // Getter for the client's unique identifier
    public String getId() {
        return id;
    }

    // Getter for the client's name
    public String getName() {
        return name;
    }

    // Setter to update the client's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the client's email address
    public String getEmail() {
        return email;
    }

    // Setter to update the client's email address
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for the client's physical address
    public String getAddress() {
        return address;
    }

    // Setter to update the client's physical address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for the client's identifier type
    public Identifiers getIdentifier() {
        return identifier;
    }

    // Setter to update the client's identifier type
    public void setIdentifier(Identifiers identifier) {
        this.identifier = identifier;
    }

    // Getter for the list of counters associated with the client
    public List<Counter> getCounters() {
        return counters;
    }

    // Setter to update the list of counters associated with the client
    public void setCounters(List<Counter> counters) {
        this.counters = counters;
    }

    /**
     * Updates the client's information based on another Client object.
     * @param client Client object containing the updated information.
     */
    public void update(Client client) {
        // Update email if the new email is not blank
        if (!client.getEmail().isBlank()) this.email = client.getEmail();

        // Update address if the new address is not blank
        if (!client.getAddress().isBlank()) this.address = client.getAddress();

        // Update name if the new name is not blank
        if (!client.getName().isBlank()) this.name = client.getName();
    }

    /**
     * Deletes a counter from the client's list of counters based on its ID.
     * @param idCounter The ID of the counter to delete.
     */
    public void deleteCounter(String idCounter) {
        // Remove the counter with the matching ID from the list
        this.counters.removeIf(counter -> counter.getId().equals(idCounter));
    }
}