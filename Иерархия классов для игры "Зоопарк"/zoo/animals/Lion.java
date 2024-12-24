package zoo.animals;

public class Lion extends AbstractAnimal {
    public Lion(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " ест мясо.");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " рычит.");
    }
}
