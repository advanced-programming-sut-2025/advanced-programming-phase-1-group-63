// model/tools/Axe.java
package model.tools;

import model.Map;
import model.Player;
import model.Tile;
import model.enums.Direction;
import model.enums.ToolTier;

public class Axe extends Tool {
    private final ToolTier tier;

    public Axe(AxeBuilder builder) {
        super(builder);
        this.tier = builder.tier;
    }

//    @Override
//    public void use(Direction dir, Player player, Map map) throws ToolException {
//        Tile tile = map.getAdjacent(Position,Direction);
//        int energy = getEnergyCost(player);
//        if (!player.hasEnergy(energy)) throw new ToolException("Not enough energy");
//        if (!tile.isChoppable()) {
//            player.consumeEnergy(energy);
//            throw new ToolException("Cannot chop " + tile.getType());
//        }
//        tile.chop(tier);
//        player.consumeEnergy(energy);
//    }

    @Override
    public void use(Direction dir, Player player, Map map) throws ToolException {
        Tile tile = map.getAdjacent(player.getPosition(), dir); // درست‌شده
        int energy = getEnergyCost(player);

        if (!player.hasEnergy(energy)) throw new ToolException("Not enough energy");

        if (!tile.isChoppable()) {
            player.consumeEnergy(energy);
            throw new ToolException("Cannot chop " + tile.getType());
        }

        tile.chop(getTier()); // فرض بر این است که getTier() در ابزار شما تعریف شده
        player.consumeEnergy(energy);
    }

    public ToolTier getTier() {
        return tier;
    }


    @Override
    public void use(Direction dir, Player player, java.util.Map map) throws ToolException {

    }


    @Override
    protected Tool buildUpgraded(ToolTier newTier) {
        return new AxeBuilder(newTier)
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

    public static class AxeBuilder extends Builder<AxeBuilder> {
        private final ToolTier tier;
        public AxeBuilder(ToolTier tier) { this.tier = tier; }
        @Override protected AxeBuilder self() { return this; }
        @Override public Axe build() { return new Axe(this); }
    }
}
