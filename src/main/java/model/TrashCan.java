package model;

import model.enums.ToolMaterial;

public class TrashCan extends Tool implements Upgradeable {
    private ToolMaterial material;
    private int backPercentage;

    public TrashCan(int requiredEnergy, ToolMaterial material, int backPercentage) {
        super(requiredEnergy);
        this.material = material;
        this.backPercentage = backPercentage;
    }

    @Override
    public void upgrade() {

    }
}
