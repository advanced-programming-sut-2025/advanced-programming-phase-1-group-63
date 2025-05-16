// model/tools/Scythe.java
package model.tools;

import model.Player;
import model.Tile;
import model.enums.Direction;
import model.enums.ToolTier;

import model.Map;

public class Scythe extends Tool {
    public Scythe(ScytheBuilder builder) {
        super(builder);
    }

    @Override
    public void use(Direction dir, Player player, Map map) throws ToolException {
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
    public void use(Direction dir, Player player, java.util.Map map) throws ToolException {

    }

    @Override
    protected Tool buildUpgraded(ToolTier tier) {
        return this;// without upgrade !!!
    }

    @Override
    public int getEnergyCost(Player player) {
        return baseEnergy;
    }

    public static class ScytheBuilder extends Builder<ScytheBuilder> {
        @Override protected ScytheBuilder self() { return this; }
        @Override public Scythe build() { return new Scythe(this); }
    }
}
