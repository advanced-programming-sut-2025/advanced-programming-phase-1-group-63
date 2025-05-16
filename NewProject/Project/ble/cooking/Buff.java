package model.cooking;

import model.enums.Stat;

public class Buff {
    private final Stat stat;
    private final int amount;
    private final int durationHours;

    public Buff(Stat stat, int amount, int durationHours) {
        this.stat = stat;
        this.amount = amount;
        this.durationHours = durationHours;
    }

    public Stat getStat() { return stat; }
    public int getAmount() { return amount; }
    public int getDurationHours() { return durationHours; }

    @Override public String toString() {
        return stat + "+" + amount + " (" + durationHours + "h)";
    }
}