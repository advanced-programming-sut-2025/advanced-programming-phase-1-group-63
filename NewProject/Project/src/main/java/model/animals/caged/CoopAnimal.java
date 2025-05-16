package model.animals.caged;

import model.animals.farmanimal.FarmAnimal;

public abstract class CoopAnimal extends FarmAnimal {
    public CoopAnimal(String name) { super(name); }

    @Override
    public String getHomeType() {
        return "Coop";
    }
}







