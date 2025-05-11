package model.animals;

import animals.farmAnimal;

public abstract class BarnAnimal extends farmAnimal {
    public BarnAnimal(String name) { super(name); }

    @Override
    public String getHomeType() {
        return "Barn";
    }
}
