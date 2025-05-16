package model.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * Different fishing poles and their quality factors
 */
public enum FishingPole {
    TRAINING_ROD("Training Rod", 0.1),
    BAMBOO_POLE("Bamboo Pole", 0.5),
    FIBERGLASS_ROD("Fiberglass Rod", 0.9),
    IRIDIUM_ROD("Iridium Rod", 1.2);

    private final String name;
    private final double factor;

    FishingPole(String name, double factor) {
        this.name = name;
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }

    public static Optional<FishingPole> fromName(String input) {
        return Arrays.stream(values())
                .filter(p -> p.name().equalsIgnoreCase(input.replace(' ', '_')))
                .findFirst();
    }
}
