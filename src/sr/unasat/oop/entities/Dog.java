package sr.unasat.oop.entities;


public class Dog {
    String naam;
    Person petOwner;
    public Dog(String name ,Person owner) {
        this.naam = name;
        this.petOwner = owner;
    }
    public void getName() {
        System.out.printf("\nDog:\nNaam:%s\nOwner:%s %s\n",this.naam,this.petOwner.name,this.petOwner.surname);
    }

}
