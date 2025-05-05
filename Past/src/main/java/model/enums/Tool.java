package main.java.model.enums;

import model.Itemable;
import model.Material;
import model.Upgradeable;

public enum Tool implements Itemable, Upgradeable {
    Pickaxe,
    Hoe,
    Axe,

    ;

    private Material material;

    Tool(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public void upgrade() {
        material = material.better();
    }
}
