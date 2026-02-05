package javademo.collections.maps;

import javademo.collections.Students;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        // Contains/ follows no order
        HashMap<Integer, String> map = getIntegerStringHashMap();

        //map.put(null, "Khushi");
        // It will replace the previous null value "Khushi" -> "Saloni"
        // It will maintain the unique key
        // No compile time or runtime error will be thrown
        //map.put(null, "Saloni");

        System.out.println(map);

        // map.get() -> takes Key not index
        System.out.println(map.get(2));
        System.out.println(map.get(5)); // If not available then return null

        // O(1) -> That's why better in compare of List (because there contains() method check every element using loop)
        // List -> contains() -> O(n)
        System.out.println(map.containsKey(1)); // O(1) better
        System.out.println(map.containsValue("Ashish")); // O(1) better

        // Check contains key or value
        System.out.println(map.containsKey(5));
        System.out.println(map.containsValue("Manwal"));

        // Iteration Set<Integers> because keys are integers
        Set<Integer> keys = map.keySet();
        for (int key : keys) {
            System.out.println(map.get(key));
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toUpperCase());
        }

        map.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });

        // Another case when we have to store objects
        Students s1 = new Students("Ashish", 18);
        Students s2 = new Students("Max", 5);
        Students s3 = new Students("Ashish", 18);

        HashMap<Students, String> studentMap = new HashMap<>();
        studentMap.put(s1, "Engineer"); // hashcode1 --> index1
        studentMap.put(s2, "Farmer"); // hashcode2 --> index2

        // After adding equals() and hashCode() in model
        // Now hashCode 1 and index1
        // Otherwise hashcode3 --> index3
        studentMap.put(s3, "JavaDemo.Student");

        // This will be stored without any problem because object s4 is created with new keyword
        // That's why it is different from first one

        System.out.println("Size: " + studentMap.size());
        System.out.println("Value for S1: " + studentMap.get(s1));
        System.out.println("Value for S3: " + studentMap.get(s3));

        mergeMaps();
    }

    @NotNull
    private static HashMap<Integer, String> getIntegerStringHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        // Add
        map.put(1, "Ashish"); // hashcode1 --> Index1
        map.put(2, "Sachin"); // hashcode2 --> Index2
        map.put(3, "Gaurav"); // hashcode3 --> Index3
        map.put(4, "Nittin");
        map.put(5, "Max");
        map.put(1, "Manwal"); // hashcode1 --> Index1 --> equals() --> replace

        // Remove
        // It takes key as input not value
        //map.remove(2);

        // remove-> when key and value both get a match in map
        map.remove(4, "Nittin"); // returns boolean
        return map;
    }

    // Merging two maps-> adding values of same key, keeping unique key as it is
    static void mergeMaps() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Orange", 10);
        map1.put("Apple", 20);
        map1.put("Banana", 30);
        map1.put("Pineapple", 40);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("Grapes", 10);
        map2.put("Apple", 18);
        map2.put("Cherry", 30);
        map2.put("Pineapple", 5);

        Map<String, Integer> map3 = new HashMap<>(map1);

        map2.forEach((key, value) -> {

            if (map1.get(key) != null) {
                map3.put(key, map1.get(key) + value);
            } else {
                map3.put(key, value);
            }
        });

        System.out.println(map3);

    }
}
