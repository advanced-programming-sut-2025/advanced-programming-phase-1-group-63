package model.tools;

import model.enums.ToolTier;
import model.enums.Direction;
import model.tools.ToolException;
import model.trading.Player;

public class FishingRod extends Tool {
    private final ToolTier tier;
    public FishingRod(FishingRodBuilder builder) { super(builder); this.tier = builder.tier; }

    @Override
    public void use(Direction dir, Player player, GameMap map) throws ToolException {
        Tile tile = map.getAdjacent(player.getPosition(), dir);
        int energy = getEnergyCost(player);
        if (!player.hasEnergy(energy)) throw new ToolException("Not enough energy");
        if (!tile.isFishable()) {
            player.consumeEnergy(energy);
            throw new ToolException("Cannot fish here");
        }
        tile.fish(this);
        player.consumeEnergy(energy);
    }

    @Override
    protected Tool buildUpgraded(ToolTier tier) {
        return new FishingRodBuilder(tier)
                .name(name).skill(skill).baseEnergy(baseEnergy)
                .addTierCost(tier, tierCosts.get(tier)).build();
    }

    @Override
    public int getEnergyCost(Player player) {
        int cost = baseEnergy;
        if (player.hasMaxSkill(skill)) cost = Math.max(1, cost - 1);
        return cost;
    }

    public static class FishingRodBuilder extends Builder<FishingRodBuilder> {
        private final ToolTier tier;
        public FishingRodBuilder(ToolTier tier) { this.tier = tier; }
        @Override protected FishingRodBuilder self() { return this; }
        @Override public FishingRod build() { return new FishingRod(this); }
    }
}