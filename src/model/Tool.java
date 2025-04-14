package model;

public class Tool implements Item {
    private int requiredEnergy;

    public Tool(int requiredEnergy) {
        this.requiredEnergy = requiredEnergy;
    }

    public int getRequiredEnergy() {
        return requiredEnergy;
    }

    public void setRequiredEnergy(int requiredEnergy) {
        this.requiredEnergy = requiredEnergy;
    }
}
