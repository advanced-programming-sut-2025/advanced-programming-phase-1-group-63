package model.animals;

import model.animals.farmanimal.FarmAnimal;

public abstract class BarnAnimal extends FarmAnimal {
    public BarnAnimal(String name) { super(name); }

    @Override
    public String getHomeType() {
        return "Barn";
    }
}
