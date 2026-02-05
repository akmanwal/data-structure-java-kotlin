package javademo.collections.strings;

public class StringMutability {

    public static void main(String[] args) throws InterruptedException {
        String name = "Ashish";
        name.concat("Manwal");
        System.out.println(name);

        // String is thread safe

        // Internally using char Array of 16 size
        // When full then create a double size array and copy the old elements in new array
        // Mutable
        // Method chaining
        // Not Thread safe -> Better performance in compare to StringBuffer
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ashish").append("Manwal").reverse();
        stringBuilder.insert(1, "a");
        stringBuilder.replace(2, 4, "bc");
        stringBuilder.delete(2, 4);
        stringBuilder.reverse();
        String subString = stringBuilder.substring(1, 3);
        int length = stringBuilder.length();
        String charredAt = String.valueOf(stringBuilder.charAt(0));

        System.out.println(stringBuilder + "->" + subString + "->" + length + "->" + charredAt);

        // Mutable
        // Thread safe
        // Because it's thread safe so -> operations will be slow
        StringBuffer stringBuffer = new StringBuffer();


        Task task1 = new Task(stringBuffer);
        Task task2 = new Task(stringBuffer);

        task1.start();
        task2.start();

        task1.join();
        task2.join();

        //System.out.println(stringBuilder.length()); // it will not print 2000 because two thread can access the run at same time
        System.out.println(stringBuffer.length()); // Print 2000
    }


}


class Task extends Thread {
    //StringBuilder builder;
    StringBuffer builder;
    public Task(StringBuffer builder) {
        this.builder = builder;
    }
    public void run() {

        for (int i = 0; i < 1000; i++) {
            builder.append("a");
        }
    }
}
