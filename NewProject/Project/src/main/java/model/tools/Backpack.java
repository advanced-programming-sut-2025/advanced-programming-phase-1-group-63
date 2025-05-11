package model.tools;

import model.enums.ToolTier;
import model.trading.Player;


public class Backpack extends Tool {
    public Backpack(BackpackBuilder builder) { super(builder); }

    @Override
    public void use(model.enums.Direction dir, Player player, model.world.GameMap map) throws ToolException {
        // Not applicable
    }

    @Override
    protected Tool buildUpgraded(ToolTier tier) { return this; }

    @Override
    public int getEnergyCost(Player player) { return 0; }

    public static class BackpackBuilder extends Builder<BackpackBuilder> {
        @Override protected BackpackBuilder self() { return this; }
        @Override public Backpack build() { return new Backpack(this); }
    }
}