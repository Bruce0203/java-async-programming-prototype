import java.util.ArrayList;
import java.util.stream.IntStream;

public class AsyncTest_Thread {

    public static ArrayList<Object> registry = new ArrayList<>();


    /**
     * out put: error ConcurrentModificationException
     */
    public static void main(String[] args) {
        IntStream.range(0, 100).forEach(i -> {
            var thread = new Thread(() -> {
                registry.add("Hello");
                System.out.println(registry);
            });
            thread.start();
        });

        System.out.println(registry);
    }
}
