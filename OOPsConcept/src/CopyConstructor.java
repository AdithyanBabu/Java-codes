class Copy{
    String name;
    String name2;

    Copy(String name){
        this.name = name;
    }

    Copy(Copy c){ // creating a copy constructor
        System.out.println("Copy constructor");
        name2 = c.name;
    }

    public void display(){
        System.out.println("Name in the copy constructor is: " + name2);
    }
}

public class CopyConstructor {
    public static void main(String[] args) {
        Copy c1 = new Copy("Adithyan");
        Copy c2 = new Copy(c1);
        c2.display();
    }

}
