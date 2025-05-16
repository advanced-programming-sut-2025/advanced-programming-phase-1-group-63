package model.animals.store;


import model.animals.farmanimal.FarmAnimal;
import model.animals.Building;
import model.animals.animalFactory;

import java.util.*;

public class marniesRanch {
    private Map<String, FarmAnimal> animals = new HashMap<>();

    public boolean buyAnimal(String type, String name, Building home) {
        if (animals.containsKey(name) || home == null || !home.hasSpace()) {
            System.out.println("Cannot buy " + type + " named " + name);
            return false;
        }
        model.animals.farmanimal.FarmAnimal a = animalFactory.createAnimal(type, name);
        if (a == null) return false;
        home.addAnimal(name);
        animals.put(name, a);
        System.out.println(type + " " + name + " purchased.");
        return true;
    }

    public FarmAnimal getAnimal(String name) {
        return animals.get(name);
    }
}
