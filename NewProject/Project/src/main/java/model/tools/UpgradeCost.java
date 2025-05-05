package model.tools;

import java.util.Map;

public class UpgradeCost {
    private final int coins;
    private final Map<String, Integer> materials;

    public UpgradeCost(int coins, Map<String, Integer> materials) {
        this.coins = coins;
        this.materials = materials;
    }

    public int getCoins() { return coins; }
    public Map<String, Integer> getMaterials() { return materials; }
}

