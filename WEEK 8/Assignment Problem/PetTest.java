interface Animal { void eat(); }
interface Pet extends Animal { void play(); }
class Dog implements Pet { public void eat() { System.out.println("Dog eats"); } public void play() { System.out.println("Dog plays"); } }
public class PetTest { public static void main(String[] args) { Dog d = new Dog(); d.eat(); d.play(); } }