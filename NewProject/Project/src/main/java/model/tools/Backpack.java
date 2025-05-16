// model/tools/Backpack.java
package model.tools;

import model.Player;
import model.enums.Direction;
import model.enums.SkillType;
import model.enums.ToolTier;

import java.util.Map;

public class Backpack extends Tool {
    private final int capacity;

    public Backpack(BackpackBuilder builder) {
        super(builder);
        this.capacity = builder.capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void use(Direction dir, Player player, model.Map map) {

    }

    @Override
    public void use(Direction dir, Player player, Map map) {
    /*Since the backpack is not an active tool, it is not useful.*/
    }

    @Override
    protected Tool buildUpgraded(ToolTier tier) {
        switch (tier) {
            case COPPER:
                return new BackpackBuilder()
                        .name("big backpack")
                        .skill(SkillType.FORAGING)
                        .baseEnergy(0)
                        .capacity(24)
                        .build();
            case IRON:
                return new BackpackBuilder()
                        .name("Deluxe backpack")
                        .skill(SkillType.FORAGING)
                        .baseEnergy(0)
                        .capacity(Integer.MAX_VALUE) // infinite
                        .build();
            default:
                return this;
        }
    }

    @Override
    public int getEnergyCost(Player player) {
        return 0; // without using energy
    }

    public static class BackpackBuilder extends Builder<BackpackBuilder> {
        private int capacity;

        public BackpackBuilder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        @Override
        protected BackpackBuilder self() {
            return this;
        }

        @Override
        public Backpack build() {
            return new Backpack(this);
        }
    }
}
