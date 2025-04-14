package model;

import model.enums.Material;

public class Axe extends Tool implements Upgradeable {
    private Material material;

    public Axe(int requiredEnergy, Material material) {
        super(requiredEnergy);
        this.material = material;
    }

    @Override
    public void upgrade() {

    }
}
