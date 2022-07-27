import java.util.ArrayList;

public class Main {

    public static ArrayList<Object> registry = new ArrayList<>();


    public static void main(String[] args) {
        var thread = new Thread(() -> {
            registry.add("Hello");
            System.out.println(registry);
        });
        thread.start();
        System.out.println(registry);
    }
}
