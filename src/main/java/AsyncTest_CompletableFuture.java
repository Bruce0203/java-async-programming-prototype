import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class AsyncTest_CompletableFuture {

    public static ArrayList<Object> registry = new ArrayList<>();

    /**
     * output : good!
     */
    public static void main(String[] args) {
        IntStream.range(0, 100).forEach(i -> {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                registry.add("Hello");
            });
            while (!completableFuture.isDone()) {
            }
            try {
                completableFuture.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }


        });

        System.out.println(registry);
    }

}
