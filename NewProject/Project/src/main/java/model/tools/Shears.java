// model/tools/Shears.java
package model.tools;

import model.Player;
import model.Tile;
import model.enums.Direction;
import model.enums.ToolTier;

import model.Map;

public class Shears extends Tool {
    public Shears(ShearsBuilder builder) {
        super(builder);
    }

    @Override
    public void use(Direction dir, Player player, Map map) throws ToolException {
        Tile tile = map.getAdjacent(player.getPosition(), dir);
        int energy = getEnergyCost(player);
        if (!player.hasEnergy(energy)) throw new ToolException("Not enough energy");
        if (!tile.isShearable()) {
            player.consumeEnergy(energy);
            throw new ToolException("Cannot shear here");
        }
        tile.shearAnimal();
        player.consumeEnergy(energy);
    }

    @Override
    public void use(Direction dir, Player player, java.util.Map map) throws ToolException {

    }

    @Override
    protected Tool buildUpgraded(ToolTier tier) {
        return this; // ارتقا ندارد
    }

    @Override
    public int getEnergyCost(Player player) {
        return baseEnergy;
    }

    public static class ShearsBuilder extends Builder<ShearsBuilder> {
        @Override protected ShearsBuilder self() { return this; }
        @Override public Shears build() { return new Shears(this); }
    }
}
