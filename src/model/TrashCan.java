package model;

import model.enums.Material;

public class TrashCan extends Tool implements Upgradeable {
    private Material material;
    private int backPercentage;

    public TrashCan(int requiredEnergy, Material material, int backPercentage) {
        super(requiredEnergy);
        this.material = material;
        this.backPercentage = backPercentage;
    }

    @Override
    public void upgrade() {

    }
}
