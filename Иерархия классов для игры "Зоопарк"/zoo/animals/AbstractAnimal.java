package zoo.animals;

public abstract class AbstractAnimal implements Animal {
    private String name;

    public AbstractAnimal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public abstract void eat();

    @Override
    public abstract void makeSound();
}
