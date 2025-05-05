package model.tools;

import model.enums.ToolTier;
import model.tools.ToolException;
import model.trading.Player;


public class TrashCan extends Tool {
    public TrashCan(TrashCanBuilder builder) { super(builder); }

    @Override
    public void use(model.enums.Direction dir, Player player, model.world.GameMap map) throws ToolException {
        // Not applicable
    }

    @Override
    protected Tool buildUpgraded(ToolTier tier) { return this; }

    @Override
    public int getEnergyCost(Player player) { return 0; }

    public static class TrashCanBuilder extends Builder<TrashCanBuilder> {
        @Override protected TrashCanBuilder self() { return this; }
        @Override public TrashCan build() { return new TrashCan(this); }
    }
}