package javademo.collections;

import java.lang.ref.WeakReference;

public class GarbageCollector {

    public static void main(String[] args) {

        Student student = new Student("Ashish", 25); // This is string reference

        // Used to cashing
        WeakReference<Student> weakStudent = new WeakReference<>(new Student("Manwal", 25));
        System.out.println(weakStudent.get());

        System.gc();

        System.out.println(weakStudent.get());


    }
}

class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
