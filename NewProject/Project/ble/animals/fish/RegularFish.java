package model.animals.fish;

import model.enums.Season;

class RegularFish extends model.animals.fish.Fish {
    public RegularFish(String name, Season season, int basePrice) {
        super(name, season, false, basePrice);
    }
}
