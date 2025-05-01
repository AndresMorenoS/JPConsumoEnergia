package uniminuto.edu.co.models;


import java.util.ArrayList;
import java.util.List;

public class Client {

    private final String id;
    private String name;
    private String email;
    private String address;
    private Identifiers identifier;
    private List<Counter> counters;

    public Client(String id, String name, String email, String address, Identifiers identifier, Counter counter) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.identifier = identifier;

        this.counters = new ArrayList<>();
        this.counters.add(counter);
    }

    public Client(String id, String name, String email, String address, Identifiers identifier, List<Counter> counters) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.identifier = identifier;
        this.counters = counters;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Identifiers getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifiers identifier) {
        this.identifier = identifier;
    }

    public List<Counter> getCounters() {
        return counters;
    }

    public void setCounters(List<Counter> counters) {
        this.counters = counters;
    }

    public void update(Client client){
        if(!client.getEmail().isBlank()) this.email = client.getEmail();
        if(!client.getAddress().isBlank()) this.address = client.getAddress();
        if(!client.getName().isBlank()) this.name = client.getName();
    }

    public void deleteCounter(String idCounter){
        this.counters.removeIf(counter -> counter.getId().equals(idCounter));
    }
}

