package model.animals.fish;



/** base class for all fish */
public abstract class Fish extends animals.farmAnimal {
    public Fish(String name) {
        super(name);
    }

    @Override
    public String getHomeType() {
        return "Fish Tank";
    }
}
