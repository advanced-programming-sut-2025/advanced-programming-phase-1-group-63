package model.tools;

import model.enums.ToolTier;
import model.enums.Direction;

import model.tools.ToolException;
import model.trading.Player;

public class Scythe extends Tool {
    public Scythe(ScytheBuilder builder) { super(builder); }

    @Override
    public void use(Direction dir, Player player, GameMap map) throws ToolException {
        Tile tile = map.getAdjacent(player.getPosition(), dir);
        int energy = getEnergyCost(player);
        if (!player.hasEnergy(energy)) throw new ToolException("Not enough energy");
        if (!tile.isHarvestable()) {
            player.consumeEnergy(energy);
            throw new ToolException("Cannot harvest " + tile.getType());
        }
        tile.harvest();
        player.consumeEnergy(energy);
    }

    @Override
    protected Tool buildUpgraded(ToolTier tier) {
        // Scythe has no tiers, return same
        return this;
    }

    @Override
    public int getEnergyCost(Player player) {
        return baseEnergy; // constant
    }

    public static class ScytheBuilder extends Builder<ScytheBuilder> {
        @Override protected ScytheBuilder self() { return this; }
        @Override public Scythe build() { return new Scythe(this); }
    }
}
