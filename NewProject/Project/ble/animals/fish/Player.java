package model.animals.fish;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class Player {
    private final double fishingSkill;
    private final Set<String> inventory;

    public Player(double skill, Collection<String> items) {
        this.fishingSkill = skill;
        this.inventory = new HashSet<>(items);
    }

    public double getSkill() {
        return fishingSkill;
    }

    public boolean hasPole(String poleName) {
        return inventory.contains(poleName);
    }
}
