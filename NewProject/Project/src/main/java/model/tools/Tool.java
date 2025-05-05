package model.tools;

import model.enums.ToolTier;
import model.enums.SkillType;
import model.enums.Direction;
import model.tools.ToolException;
import model.trading.Player;

import java.util.EnumMap;
import java.util.Map;

public abstract class Tool {
    private final String name;
    private final SkillType skill;
    private final Map<ToolTier, UpgradeCost> tierCosts;
    private final int baseEnergy;

    protected Tool(Builder<?> builder) {
        this.name = builder.name;
        this.skill = builder.skill;
        this.tierCosts = builder.tierCosts;
        this.baseEnergy = builder.baseEnergy;
    }

    public String getName() { return name; }
    public SkillType getSkill() { return skill; }


    public abstract void use(Direction dir, Player player, GameMap map) throws ToolException;

    public void upgrade(ToolTier newTier, Player player) throws ToolException {
        if (!player.isAtBlacksmith()) throw new ToolException("Must be at blacksmith");
        UpgradeCost cost = tierCosts.get(newTier);
        if (cost == null) throw new ToolException("Cannot upgrade to " + newTier);
        if (!player.hasResources(cost.getCoins(), cost.getMaterials()))
            throw new ToolException("Not enough resources");
        player.deductResources(cost.getCoins(), cost.getMaterials());
        player.replaceTool(buildUpgraded(newTier));
    }

    protected abstract Tool buildUpgraded(ToolTier tier);

    public abstract int getEnergyCost(Player player);

    public static abstract class Builder<T extends Builder<T>> {
        private String name;
        private SkillType skill;
        private int baseEnergy;
        private Map<ToolTier, UpgradeCost> tierCosts = new EnumMap<>(ToolTier.class);

        public T name(String name) { this.name = name; return self(); }
        public T skill(SkillType skill) { this.skill = skill; return self(); }
        public T baseEnergy(int e) { this.baseEnergy = e; return self(); }
        public T addTierCost(ToolTier tier, UpgradeCost cost) { tierCosts.put(tier, cost); return self(); }
        protected abstract T self();
        public abstract Tool build();
    }
}

