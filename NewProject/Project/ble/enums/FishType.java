package model.enums;

import java.util.List;
import java.util.ArrayList;

public enum FishType {
    SALMON("Salmon", Season.FALL, 75, false),
    SARDINE("Sardine", Season.FALL, 40, false),
    SHAD("Shad", Season.FALL, 60, false),
    BLUE_DISCUS("Blue Discus", Season.FALL, 120, false),
    MIDNIGHT_CARP("Midnight Carp", Season.WINTER, 150, false),
    SQUID("Squid", Season.WINTER, 80, false),
    TUNA("Tuna", Season.WINTER, 100, false),
    PERCH("Perch", Season.WINTER, 55, false),
    FLOUNDER("Flounder", Season.SPRING, 100, false),
    LIONFISH("Lionfish", Season.SPRING, 100, false),
    HERRING("Herring", Season.SPRING, 30, false),
    GHOSTFISH("Ghostfish", Season.SPRING, 45, false),
    TILAPIA("Tilapia", Season.SUMMER, 75, false),
    DORADO("Dorado", Season.SUMMER, 100, false),
    SUNFISH("Sunfish", Season.SUMMER, 30, false),
    RAINBOW_TROUT("Rainbow Trout", Season.SUMMER, 65, false),

    LEGEND("Legend", Season.SPRING, 5000, true),
    GLACIERFISH("Glacierfish", Season.WINTER, 1000, true),
    ANGLER("Angler", Season.FALL, 900, true),
    CRIMSONFISH("Crimsonfish", Season.SUMMER, 1500, true);

    private final String name;
    private final Season season;
    private final int basePrice;
    private final boolean legendary;

    FishType(String name, Season season, int basePrice, boolean legendary) {
        this.name = name;
        this.season = season;
        this.basePrice = basePrice;
        this.legendary = legendary;
    }

    public String getName() { return name; }
    public Season getSeason() { return season; }
    public int getBasePrice() { return basePrice; }
    public boolean isLegendary() { return legendary; }

    /**
     * Returns list of fish available in given season.
     * If includeLegendary is false, legendary fish are excluded.
     */
    public static List<FishType> getAvailableFish(Season season, boolean includeLegendary) {
        List<FishType> result = new ArrayList<>();
        for (FishType ft : values()) {
            if (ft.season == season && (includeLegendary || !ft.legendary)) {
                result.add(ft);
            }
        }
        return result;
    }
}
