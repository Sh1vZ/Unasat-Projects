package sr.unasat.oop.app;

import sr.unasat.oop.entities.Dog;
import sr.unasat.oop.entities.Person;

public class Application {
    public static void main(String[] args) {
        Person per1 = new Person("Person 1", "Person 1");
        Dog dog1 = new Dog("Dog 1","Owner 1");
        per1.getName();
        dog1.getName();
    }
}
