package model.crop;

import model.crop.GiantCrop;
import java.util.*;

public class FarmEngine {
    private final Plot[][] field;
    private final int width, height;

    public FarmEngine(int width, int height) {
        this.width = width;
        this.height = height;
        field = new Plot[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                field[x][y] = new Plot();
            }
        }
    }

    /** Count all non-empty plots (crops, trees, giant crops) */
    public int countPlanted() {
        int c = 0;
        for (Plot[] col : field) for (Plot p : col) if (!p.isEmpty()) c++;
        return c;
    }

    /** Return a random non-empty plot */
    public Plot randomPlantedPlot() {
        List<Plot> planted = new ArrayList<>();
        for (Plot[] col : field) for (Plot p : col) if (!p.isEmpty()) planted.add(p);
        if (planted.isEmpty()) return null;
        return planted.get(new Random().nextInt(planted.size()));
    }

    public void tryGiant(int x, int y) {

    }

    public void nightlyCrowAttack(boolean scarecrowPresent) {
        int count = countPlanted();
        int groups = count / 16;
        Random rand = new Random();
        for (int i = 0; i < groups; i++) {
            if (rand.nextDouble() < 0.25) {
                Plot p = randomPlantedPlot();
                if (p != null && !scarecrowPresent) p.removeCropOrFruit();
            }
        }
    }

    // water(direction), showPlant(x,y), howMuchWater(), harvest(x,y), etc.
}