package model.animals.fish;

import model.enums.Season;

class LegendaryFish extends model.animals.fish.Fish {
    public LegendaryFish(String name, Season season, int basePrice) {
        super(name, season, true, basePrice);
    }
}
