package sr.unasat.oop.entities;

import java.util.Random;

public class Person {
    String name;
    Integer id;
    String surname;

    public Person(String naam, String achternaam) {
        this.surname = achternaam;
        this.name = naam;
        Random rand = new Random();
        int newId;
        newId = rand.nextInt(0, 10000);
        this.id = newId;
    }

    public void getName() {
        System.out.println("ID: " + this.id + "\nNaam: " + this.name + "\nSurname: " + this.name+"\n");
    }

}
