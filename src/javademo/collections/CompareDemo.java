package javademo.collections;

import java.util.ArrayList;
import java.util.Collections;

public class CompareDemo {

    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Ashish", 100));
        list.add(new Employee(5, "Manish", 70));
        list.add(new Employee(3, "Sintu", 80));
        list.add(new Employee(2, "Bintu", 90));

        Collections.sort(list, new ComparatorId());
        System.out.println(list);

        ArrayList<Employee> list2 = new ArrayList<>(list);

        Collections.sort(list2, new ComparatorName());
        System.out.println(list2);
    }
}
