package model;

import model.enums.Material;

public class WateringCan extends Tool implements Upgradeable {
    private Material material;
    private int numberOfCells;

    public WateringCan(int requiredEnergy, Material material, int numberOfCells) {
        super(requiredEnergy);
        this.material = material;
        this.numberOfCells = numberOfCells;
    }

    @Override
    public void upgrade() {

    }
}
