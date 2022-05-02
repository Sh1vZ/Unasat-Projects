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
        newId = rand.nextInt();
        this.id = newId;
    }

    public void getName() {
        System.out.printf("\nPerson:\nID:%d\nNaam:%s\nSurname:%s\n",this.id,this.name,this.surname);
    }

}
