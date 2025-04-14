package model;

import model.enums.Material;

public class Hoe extends Tool implements Upgradeable{
    private Material material;

    public Hoe(int requiredEnergy, Material material) {
        super(requiredEnergy);
        this.material = material;
    }

    @Override
    public void upgrade() {

    }
}
