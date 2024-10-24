class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

/* Overriding class */
class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

public class MethodOverriding{
    public static void main(String[] args) {

        Animal myDog = new Dog(); // Create an instance of Dog
        myDog.sound();

        Animal myAnimal = new Animal();
        myAnimal.sound();
    }
}
