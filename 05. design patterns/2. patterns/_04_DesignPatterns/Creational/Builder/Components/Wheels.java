package _04_DesignPatterns.Creational.Builder.Components;

public class Wheels {

    private double diameterInInches;

    public Wheels(double diameterInInches) {
        this.diameterInInches = diameterInInches;
    }

    public double getDiameterInInches() {
        return diameterInInches;
    }
}
