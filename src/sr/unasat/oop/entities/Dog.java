package sr.unasat.oop.entities;


public class Dog {
    String naam;
    String owner;
    public Dog(String name ,String owner) {
        this.naam = name;
        this.owner = owner;
    }
    public void getName() {
        System.out.println("Naam: " + this.naam+"\nOwner: "+this.owner+"\n");
    }

}
