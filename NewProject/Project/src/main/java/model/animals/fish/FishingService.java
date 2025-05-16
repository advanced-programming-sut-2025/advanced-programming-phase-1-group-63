package model.animals.fish;


import model.enums.FishingPole;
import model.enums.Season;
import model.enums.Weather;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class FishingService {

    /**
     * Execute fishing command!!!!
     *
     * @param player   the player
     * @param poleName name of the pole
     * @param season   current season
     **/
    public void fish(Player player, String poleName, Season season) {
        Optional<FishingPole> poleOpt = FishingPole.fromName(poleName);
        if (!poleOpt.isPresent()) {
            System.out.println("Unknown fishing pole: " + poleName);
            return;
        }
        if (!player.hasPole(poleName)) {
            System.out.println("You don't have a " + poleName + " in inventory.");
            return;
        }
        FishingPole pole = poleOpt.get();

        // determine weather multiplier M
        Weather w = WeatherService.getCurrentWeather();
        double M;
        switch (w) {
            case SUNNY:
                M = 0.5;
                break;
            case RAIN:
                M = 1.2;
                break;
            case STORM:
                M = 1.5;
                break;
            default:
                M = 1.0;
                break;
        }

        double skill = player.getSkill();
        double rCount = Math.random();
        int count = (int) Math.ceil(rCount * M * (skill + 2));
        count = Math.min(count, 6);
        // this is a part of fish service that help us to be better in controlling anything about Fish and Fishing
        boolean includeLegendary = (int) skill >= 10; // assume max skill 10
        List<Fish> pool = FishData.getAvailableFish(season, includeLegendary);
        if (pool.isEmpty() || count == 0) {
            System.out.println("No fish caught.");
            return;
        }
        System.out.println("Caught " + count + " fish:");
        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            Fish f = pool.get(rnd.nextInt(pool.size()));
            double rQual = Math.random(); // maybe we use this in the end of phase 2/3;
            int quality = f.getQuality(skill, M, pole.getFactor());
            int price = f.getFinalPrice(quality);
            String qLabel = quality == 1 ? "Low" : quality == 2 ? "Medium" : "High";
            System.out.println(" - " + f.getName() + " (q=" + qLabel + ") price=" + price + "g");
        }
    }
}
