// model/tools/TrashCan.java
package model.tools;

import model.Map;
import model.Player;
import model.enums.Direction;
import model.enums.SkillType;
import model.enums.ToolTier;



public class TrashCan extends Tool {
    private final ToolTier tier;

    public TrashCan(TrashCanBuilder builder) {
        super(builder);
        this.tier = builder.tier;
    }

    public double getRefundRate() {
        switch (tier) {
            case COPPER: return 0.15;
            case IRON: return 0.30;
            case GOLD: return 0.45;
            case IRIDIUM: return 0.60;
            default: return 0.0; // initial trashcan
        }
    }

    @Override
    public void use(Direction dir, Player player, Map map) {
    // It has no direct use just with using inventory
    }

    @Override
    public void use(Direction dir, Player player, java.util.Map map) throws ToolException {

    }

    @Override
    protected Tool buildUpgraded(ToolTier newTier) {
        return new TrashCanBuilder(newTier)
                .name("TrashCan " + newTier.name())
                .skill(SkillType.FORAGING)
                .baseEnergy(0)
                .build();
    }

    @Override
    public int getEnergyCost(Player player) {
        return 0; //  without using energy
    }

    public ToolTier getTier() {
        return tier;
    }

    public static class TrashCanBuilder extends Builder<TrashCanBuilder> {
        private final ToolTier tier;

        public TrashCanBuilder(ToolTier tier) {
            this.tier = tier;
        }

        @Override
        protected TrashCanBuilder self() {
            return this;
        }

        @Override
        public TrashCan build() {
            return new TrashCan(this);
        }
    }
}
