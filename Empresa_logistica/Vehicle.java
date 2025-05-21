public class Vehicle {
    private String id;
    private String model;
    private int year;

    public Vehicle(String id, String model, int year) {
        this.id = id;
        this.model = model;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    