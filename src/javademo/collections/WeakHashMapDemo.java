package javademo.collections;

import java.util.WeakHashMap;

public class WeakHashMapDemo {

    public static void main(String[] args) throws InterruptedException {

        // Having weak keys
        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();

        imageCache.put(new String("img1"), new Image("JavaDemo.Image 1")); // Key-> img1 is stored in string literal and there these are strong ref to string
        imageCache.put(new String("img1"), new Image("JavaDemo.Image 2")); // Here weak reference of JavaDemo.Image class because no reference is there to access

        System.out.println(imageCache);

        // Suggest JVM to collect if any garbage is there
        // We do not use it in actual program

        System.gc();
        simulateAppRunning();
        System.out.println("After simulateAppRunning...(some entries may be cleared) -> " + imageCache);

    }

    private static void simulateAppRunning() throws InterruptedException {
        System.out.println("simulateAppRunning...");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Image {
    private String name;

    Image(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}
