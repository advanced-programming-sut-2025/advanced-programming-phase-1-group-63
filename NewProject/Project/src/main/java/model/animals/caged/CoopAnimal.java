package model.animals.caged;

public abstract class CoopAnimal extends animals.farmAnimal {
    public CoopAnimal(String name) { super(name); }

    @Override
    public String getHomeType() {
        return "Coop";
    }
}







