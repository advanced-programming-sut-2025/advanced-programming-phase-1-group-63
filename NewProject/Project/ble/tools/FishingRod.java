package model.tools;


import model.Map;
import model.Player;
import model.Tile;
import model.enums.Direction;
import model.enums.ToolTier;

public class FishingRod extends Tool {
    private final ToolTier tier;

    public FishingRod(FishingRodBuilder builder) {
        super(builder);
        this.tier = builder.tier;
    }
    /**
     * @return the chance (0–100) of catching a fish based on rod tier
     */
    public int getEfficiency() {
        switch (tier) {
            case BASIC:    return 25;  // 25% base chance
            case COPPER:   return 40;
            case IRON:     return 55;
            case GOLD:     return 70;
            case IRIDIUM:  return 85;
            default:       throw new IllegalStateException("Unknown tier: " + tier);
        }
    }
    @Override
    public void use(Direction dir, Player player, Map map) throws ToolException {
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
    public void use(Direction dir, Player player, java.util.Map map) throws ToolException {

    }

    @Override
    protected Tool buildUpgraded(ToolTier newTier) {
        return new FishingRodBuilder(newTier)
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

    public static class FishingRodBuilder extends Builder<FishingRodBuilder> {
        private final ToolTier tier;
        public FishingRodBuilder(ToolTier tier) { this.tier = tier; }
        @Override protected FishingRodBuilder self() { return this; }
        @Override public FishingRod build() { return new FishingRod(this); }
    }
}
