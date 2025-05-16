package model.animals;

import model.animals.barned.Cow;
import model.animals.barned.Goat;
import model.animals.barned.Pig;
import model.animals.barned.Sheep;
import model.animals.caged.Chicken;
import model.animals.caged.Dinosaur;
import model.animals.caged.Duck;
import model.animals.caged.Rabbit;

public class animalFactory {
    public static model.animals.farmanimal.FarmAnimal createAnimal(String type, String name) {
        switch (type.toLowerCase()) {
            case "chicken":  return new Chicken(name);
            case "duck":     return new Duck(name);
            case "rabbit":   return new Rabbit(name);
            case "dinosaur": return new Dinosaur(name);
            case "cow":      return new Cow(name);
            case "goat":     return new Goat(name);
            case "sheep":    return new Sheep(name);
            case "pig":      return new Pig(name);
            default:           return null;
        }
    }
}