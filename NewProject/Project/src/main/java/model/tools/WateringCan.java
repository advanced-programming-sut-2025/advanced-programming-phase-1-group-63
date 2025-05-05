package model.tools;

import model.enums.ToolTier;
import model.enums.Direction;


import model.trading.Player;

public class WateringCan extends Tool {
    private final ToolTier tier;
    public WateringCan(WateringCanBuilder builder) { super(builder); this.tier = builder.tier; }

    @Override
    public void use(Direction dir, Player player, GameMap map)  {
        Tile tile = map.getAdjacent(player.getPosition()
                , dir);
        int energy = getEnergyCost(player);
        if (!player.hasEnergy(energy)) throw new ToolException("Not enough energy");
        if (!tile.hasWaterSource() && !tile.isCrop()) {
            player.consumeEnergy(energy);
            throw new ToolException("Cannot water " + tile.getType());
        }
        if (tile.hasWaterSource()) tile.fillCan(this);
        else if (tile.isCrop()) tile.water();
        player.consumeEnergy(energy);
    }

    @Override
    protected Tool buildUpgraded(ToolTier tier) {
        return new WateringCanBuilder(tier)
                .name(name).skill(skill).baseEnergy(baseEnergy)
                .addTierCost(tier, tierCosts.get(tier)).build();
    }

    @Override
    public int getEnergyCost(Player player) {
        int cost = baseEnergy;
        if (player.hasMaxSkill(skill)) cost = Math.max(1, cost - 1);
        return cost;
    }

    public static class WateringCanBuilder extends Builder<WateringCanBuilder> {
        private final ToolTier tier;
        public WateringCanBuilder(ToolTier tier) { this.tier = tier; }
        @Override protected WateringCanBuilder self() { return this; }
        @Override public WateringCan build() { return new WateringCan(this); }
    }
}

