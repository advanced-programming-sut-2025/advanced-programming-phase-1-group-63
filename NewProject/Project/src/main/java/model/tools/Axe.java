package model.tools;

import model.enums.ToolTier;
import model.enums.Direction;

import model.trading.Player;
//we need to import Tile and player and MainMap!!1
import model.tools.ToolException;

public class Axe extends Tool {
    private final ToolTier tier;
    public Axe(AxeBuilder builder) { super(builder); this.tier = builder.tier; }

    @Override
    public void use(Direction dir, Player player, GameMap map) throws ToolException {
        Tile tile = map.getAdjacent(player.getPosition(), dir);
        int energy = getEnergyCost(player);
        if (!player.hasEnergy(energy)) throw new ToolException("Not enough energy");
        if (!tile.isChoppable()) {
            player.consumeEnergy(energy);
            throw new ToolException("Cannot chop " + tile.getType());
        }
        tile.chop(tier);
        player.consumeEnergy(energy);
    }

    @Override
    protected Tool buildUpgraded(ToolTier tier) {
        return new AxeBuilder(tier)
                .name(name).skill(skill).baseEnergy(baseEnergy)
                .addTierCost(tier, tierCosts.get(tier)).build();
    }

    @Override
    public int getEnergyCost(Player player) {
        int cost = baseEnergy;
        if (player.hasMaxSkill(skill)) cost = Math.max(1, cost - 1);
        return cost;
    }

    public static class AxeBuilder extends Builder<AxeBuilder> {
        private final ToolTier tier;
        public AxeBuilder(ToolTier tier) { this.tier = tier; }
        @Override protected AxeBuilder self() { return this; }
        @Override public Axe build() { return new Axe(this); }
    }
}
