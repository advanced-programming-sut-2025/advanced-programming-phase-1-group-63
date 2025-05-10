package model.animals;

import java.awt.Point;
import java.util.*;

public abstract class Building {
    protected Point location;
    protected int capacity;
    protected List<String> animalNames = new ArrayList<>();

    public Building(Point location, int capacity) {
        this.location = location;
        this.capacity = capacity;
    }

    public boolean hasSpace() {
        return animalNames.size() < capacity;
    }

    public boolean addAnimal(String name) {
        if (hasSpace()) {
            animalNames.add(name);
            return true;
        }
        return false;
    }

    public Point getLocation() {
        return location;
    }

    public abstract String getType();
}
