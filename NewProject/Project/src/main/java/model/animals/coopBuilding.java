package model.animals;

import java.awt.Point;

public class coopBuilding extends Building {
    public coopBuilding(Point location, int level) {
        // level 1 → capacity 4, level 2 → capacity 8, level 3 → capacity 12
        super(location, level == 1 ? 4 : level == 2 ? 8 : 12);
    }

    @Override
    public String getType() {
        return "Coop Level " + (capacity / 4);
    }
}
