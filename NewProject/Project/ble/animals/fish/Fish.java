package model.animals.fish;

import model.enums.Season;

/**
 * Base class for fish
 */
public abstract class Fish {
    protected String name;
    protected Season season;
    protected boolean isLegendary;
    protected int basePrice;

    public Fish(String name, Season season, boolean isLegendary, int basePrice) {
        this.name = name;
        this.season = season;
        this.isLegendary = isLegendary;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public Season getSeason() {
        return season;
    }

    public boolean isLegendary() {
        return isLegendary;
    }

    /**
     * Calculate quality tier: 1=Low, 2=Medium, 3=High
     */
    public int getQuality(double skill, double multiplier, double poleFactor) {
        double r = Math.random();
        double score = r * (skill + 2) * multiplier * poleFactor;
        if (score < 20) return 1;
        else if (score < 60) return 2;
        else return 3;
    }

    /*calculate FinalPrice with basePrice and quality*/
    public int getFinalPrice(int quality) {
        return basePrice * quality;
    }
}
