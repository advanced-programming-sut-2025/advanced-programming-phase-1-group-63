// model/tools/WateringCan.java
package model.tools;

import model.Player;
import model.Tile;
import model.enums.Direction;
import model.enums.ToolTier;


import model.Map;
public class WateringCan extends Tool {
    private final ToolTier tier;

    public WateringCan(WateringCanBuilder builder) {
        super(builder);
        this.tier = builder.tier;
    }

    @Override
    public void use(Direction dir, Player player, Map map) throws ToolException {
        Tile tile = map.getAdjacent(player.getPosition(), dir);
        int energy = getEnergyCost(player);
        if (!player.hasEnergy(energy)) throw new ToolException("Not enough energy");
        if (!tile.hasWaterSource() && !tile.isCrop()) {
            player.consumeEnergy(energy);
            throw new ToolException("Cannot water " + tile.getType());
        }
        if (tile.hasWaterSource()) tile.fillCan(this);
        else tile.water();
        player.consumeEnergy(energy);
    }

    @Override
    public void use(Direction dir, Player player, java.util.Map map) throws ToolException {

    }

    @Override
    protected Tool buildUpgraded(ToolTier newTier) {
        return new WateringCanBuilder(newTier)
                .name(getName())
                .skill(getSkill())
                .baseEnergy(baseEnergy)
                .addTierCost(newTier, tierCosts.get(newTier))
                .build();
    }

    @Override
    public int getEnergyCost(Player player) {
        int cost = baseEnergy;
        if (player.hasMaxSkill(getSkill())) cost = Math.max(1, cost - 1);
        return cost;
    }

    public static class WateringCanBuilder extends Builder<WateringCanBuilder> {
        private final ToolTier tier;
        public WateringCanBuilder(ToolTier tier) { this.tier = tier; }
        @Override protected WateringCanBuilder self() { return this; }
        @Override public WateringCan build() { return new WateringCan(this); }
    }
}
