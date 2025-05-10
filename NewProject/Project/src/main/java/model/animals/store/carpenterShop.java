package model.animals.store;

import model.animals.Building;
import model.animals.barnBuilding;
import model.animals.coopBuilding;

import java.awt.Point;
import java.util.*;

public class carpenterShop {
    private List<Building> buildings = new ArrayList<>();

    public boolean build(String type, int level, Point loc) {
        for (Building b : buildings) {
            if (b.getLocation().equals(loc)) {
                System.out.println("Spot occupied.");
                return false;
            }
        }
        Building b = type.equalsIgnoreCase("coop")
                ? new coopBuilding(loc, level)
                : new barnBuilding(loc, level);
        buildings.add(b);
        System.out.println(b.getType() + " built at " + loc);
        return true;
    }

    public List<Building> getBuiltBuildings() {
        return buildings;
    }
}