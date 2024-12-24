package zoo.main;

import zoo.animals.*;
import zoo.staff.Zookeeper;
import zoo.environment.Enclosure;

public class ZooGame {
    public static void main(String[] args) {
        // Создание животных
        Lion lion = new Lion("Симба");
        Elephant elephant = new Elephant("Дамбо");
        Parrot parrot = new Parrot("Кеша");

        // Создание вольеров
        Enclosure lionEnclosure = new Enclosure("Львиный вольер");
        lionEnclosure.addAnimal(lion);

        Enclosure mixedEnclosure = new Enclosure("Общий вольер");
        mixedEnclosure.addAnimal(elephant);
        mixedEnclosure.addAnimal(parrot);

        // Показ животных в вольерах
        lionEnclosure.showAnimals();
        mixedEnclosure.showAnimals();

        // Создание смотрителя
        Zookeeper zookeeper = new Zookeeper("Анна");
        zookeeper.performDuties();
        zookeeper.feedAnimal(lion);
        zookeeper.feedAnimal(parrot);
    }
}
