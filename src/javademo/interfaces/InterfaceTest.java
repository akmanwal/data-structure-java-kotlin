package javademo.interfaces;

public class InterfaceTest {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.sleep();

        Cat cat = new Cat();
        cat.eat();
        cat.sleep();

        System.out.println(Dog.MAX_AGE);
        System.out.println(Animal.MAX_AGE);

        // This can be access through Animal interface not by using Dog.info() or Cat.info()
        Animal.info(); // static method

        // Default methods can be called only through the classes which implements this interface
        dog.run(); // default method calling
        cat.run(); // default method calling

        SmartPhone smartPhone = new SmartPhone();
        smartPhone.makeCall();
        smartPhone.endCall();
        smartPhone.takePhoto();
        smartPhone.recordVideo();

    }
}
