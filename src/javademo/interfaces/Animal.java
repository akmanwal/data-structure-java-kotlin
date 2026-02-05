package javademo.interfaces;

/* Blueprint for making a class
 * Used for: 1. Multiple inheritance 2. Abstraction
 * Can have abstract methods, static methods, default methods, static constants
 * Methods are by default -> public and abstract
 * Constants are by default -> public, static, final
 * Only the abstract methods here must be Override in the class which implements this interface -> not the info method
 */
public interface Animal {

    // by default public, static, final
    public static final int MAX_AGE = 15;

    // by default public and abstract
    public abstract void eat();

    void sleep();

    /* After java 1.8
     * Interface can have
     * 1. static 2. default method also
     * Like this we can make Utils class of Android as interface

     * methods must be static
     * if we remove static from here then it will give error "Interface abstract methods cannot have body" -> treating as
     * abstract
     * This can be access only through Animal interface not by using Dog.info() or Cat.info()
     *
     * 1. Static Methods
     */
    public static void info() {
        System.out.println("Static: This is an Animal interface");
    }

    // 2. Default methods
    default void run() {
        /* this.sleep() means it will call the overridden methods of that class which call run ->
         * Like dog.run() or cat.run()
         * "this" means instance of the calling class
         */
        this.sleep();
        System.out.println("Default: Animal is running...");
    }

    // We can have main method also because it's a static method
    // Because JVM needs a static method to run without calling using an object
    public static void main(String[] args) {
        //Dog animal = new Dog();
        //animal.eat();
    }
}
