package zoo.animals;

public class Parrot extends AbstractAnimal {
    public Parrot(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " ест фрукты.");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " говорит: Привет!");
    }
}
