package model;

import model.enums.Material;

public class Pickaxe extends Tool implements Upgradeable {
    private Material material;

    public Pickaxe(int requiredEnergy, Material material) {
        super(requiredEnergy);
        this.material = material;
    }

    @Override
    public void upgrade() {

    }
}
