package model.tools;

import model.enums.ToolTier;
import model.enums.Direction;
// we need to import player and gameMap(MainMap)


public class Hoe extends Tool {
    private final ToolTier tier;

    private Hoe(HoeBuilder builder) {
        super(builder);
        this.tier = builder.tier;
    }

    @Override
    public void use(Direction dir, Player player, GameMap map) throws ToolException {
        Tile tile = map.getAdjacent(player.getPosition(), dir);
        int energy = getEnergyCost(player);
        if (!player.hasEnergy(energy)) throw new ToolException("Not enough energy");
        if (!tile.isTillable()) {
            player.consumeEnergy(energy);
            throw new ToolException("Cannot hoe " + tile.getType());
        }
        tile.hoe();
        player.consumeEnergy(energy);
    }

    @Override
    protected Tool buildUpgraded(ToolTier tier) {
        return new HoeBuilder(tier)
                .name(getName())
                .skill(getSkill())
                .baseEnergy(baseEnergy)
                .addTierCost(tier, tierCosts.get(tier))
                .build();
    }

    @Override
    public int getEnergyCost(Player player) {
        int cost = baseEnergy;
        if (player.hasMaxSkill(getSkill())) cost = Math.max(1, cost - 1);
        return cost;
    }

    public static class HoeBuilder extends Builder<HoeBuilder> {
        private final ToolTier tier;

        public HoeBuilder(ToolTier tier) { this.tier = tier; }
        @Override protected HoeBuilder self() { return this; }
        @Override public Hoe build() { return new Hoe(this); }
    }
}