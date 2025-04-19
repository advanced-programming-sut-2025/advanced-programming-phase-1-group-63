package model;

import model.enums.ToolMaterial;

public class WateringCan extends Tool implements Upgradeable {
    private ToolMaterial material;
    private int numberOfCells;

    public WateringCan(int requiredEnergy, ToolMaterial material, int numberOfCells) {
        super(requiredEnergy);
        this.material = material;
        this.numberOfCells = numberOfCells;
    }

    @Override
    public void upgrade() {

    }
}
