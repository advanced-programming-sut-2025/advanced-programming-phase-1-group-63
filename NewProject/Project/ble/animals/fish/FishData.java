package model.animals.fish;

import model.enums.Season;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FishData {
    public static final List<Fish> allFish = Collections.unmodifiableList(
            Arrays.asList(
                    new RegularFish("Salmon", Season.FALL, 75),
                    new RegularFish("Sardine", Season.FALL, 40),
                    new RegularFish("Shad", Season.FALL, 60),
                    new RegularFish("Blue Discus", Season.FALL, 120),
                    new RegularFish("Midnight Carp", Season.WINTER, 150),
                    new RegularFish("Squid", Season.WINTER, 80),
                    new RegularFish("Tuna", Season.WINTER, 100),
                    new RegularFish("Perch", Season.WINTER, 55),
                    new RegularFish("Flounder", Season.SPRING, 100),
                    new RegularFish("Lionfish", Season.SPRING, 100),
                    new RegularFish("Herring", Season.SPRING, 30),
                    new RegularFish("Ghostfish", Season.SPRING, 45),
                    new RegularFish("Tilapia", Season.SUMMER, 75),
                    new RegularFish("Dorado", Season.SUMMER, 100),
                    new RegularFish("Sunfish", Season.SUMMER, 30),
                    new RegularFish("Rainbow Trout", Season.SUMMER, 65),
                    // Legendary fish
                    new LegendaryFish("Legend", Season.SPRING, 5000),
                    new LegendaryFish("Glacierfish", Season.WINTER, 1000),
                    new LegendaryFish("Angler", Season.FALL, 900),
                    new LegendaryFish("Crimsonfish", Season.SUMMER, 1500)
            )
    );

    /*
     * Get fishes for given season, include legendary if allowed
     */
    public static List<Fish> getAvailableFish(Season season, boolean includeLegendary) {
        List<Fish> result = new ArrayList<>();
        for (Fish fish : allFish) {
            if (fish.getSeason() == season && (!fish.isLegendary() || includeLegendary)) {
                result.add(fish);
            }
        }
        return result;
    }
}