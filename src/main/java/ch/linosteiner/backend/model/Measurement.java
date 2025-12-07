package ch.linosteiner.backend.model;

public class Measurement {
    private String date;
    private String user;
    private double height;
    private double weight;

    public Measurement() {
    }

    public Measurement(String date, String user, double height, double weight) {
        this.date = date;
        this.user = user;
        this.height = height;
        this.weight = weight;
    }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
}
