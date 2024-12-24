package zoo.environment;

import zoo.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    private String name;
    private List<Animal> animals;

    public Enclosure(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " добавлен в вольер " + name + ".");
    }

    public void showAnimals() {
        System.out.println("В вольере " + name + " находятся:");
        for (Animal animal : animals) {
            System.out.println("- " + animal.getName());
        }
    }
}
