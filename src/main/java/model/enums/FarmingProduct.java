package model.enums;

public enum FarmingProduct {

    ;

    private String name;
    private String source;
    private int[] stagePeriods;
    private int sumStagePeriod;
    private boolean multipleHarvest;
    private int harvestPeriod;
    private int price;
    private boolean eatable;
    private int addedEnergy;
    private Season season;
    private boolean giantable;

    FarmingProduct(String name, String source, int[] stagePeriods, int sumStagePeriod, boolean multipleHarvest, int harvestPeriod, int price, boolean eatable, int addedEnergy, Season season, boolean giantable) {
        this.name = name;
        this.source = source;
        this.stagePeriods = stagePeriods;
        this.sumStagePeriod = sumStagePeriod;
        this.multipleHarvest = multipleHarvest;
        this.harvestPeriod = harvestPeriod;
        this.price = price;
        this.eatable = eatable;
        this.addedEnergy = addedEnergy;
        this.season = season;
        this.giantable = giantable;
    }


}
