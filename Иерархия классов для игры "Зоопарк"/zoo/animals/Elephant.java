package zoo.animals;

public class Elephant extends AbstractAnimal {
    public Elephant(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " ест траву.");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " трубит.");
    }
}
