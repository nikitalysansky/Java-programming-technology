package zoo.staff;

import zoo.animals.Animal;

public class Zookeeper extends Staff {
    public Zookeeper(String name) {
        super(name);
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " ухаживает за животными.");
    }

    public void feedAnimal(Animal animal) {
        System.out.println(getName() + " кормит " + animal.getName() + ".");
        animal.eat();
    }
}
