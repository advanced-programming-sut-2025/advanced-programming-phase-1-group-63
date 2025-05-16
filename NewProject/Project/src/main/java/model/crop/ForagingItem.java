package model.crop;


import model.enums.Season;
import java.util.List;

public class ForagingItem extends Crop {
    public ForagingItem(String name, String source, Season season, int baseSellPrice) {
        super(name, source, List.of(), true, null,
                baseSellPrice, false, 0, 0,
                season, false);
    }

    @Override public void onPlanted(Plot plot) { }
    @Override public void onHarvested(Plot plot) { }
}
