package model;

public class Metric {
    public String name;
    public int coefficient;
    public String direction;
    public double minRange, maxRange;
    public String unit;
    public double rawValue;
    public double score;

    public Metric(String name, int coefficient, String direction, double min, double max, String unit) {
        this.name = name;
        this.coefficient = coefficient;
        this.direction = direction;
        this.minRange = min;
        this.maxRange = max;
        this.unit = unit;
    }
}