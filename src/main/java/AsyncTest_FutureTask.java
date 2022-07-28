import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class AsyncTest_FutureTask {

    public static ArrayList<Object> registry = new ArrayList<>();


    /**
     * output: good!
     */
    public static void main(String[] args) {
        IntStream.range(0, 100).forEach(i -> {
            ExecutorService threadPool = Executors.newCachedThreadPool();
            Future<?> futureTask = threadPool.submit(() -> {
                registry.add("Hello");
            });
            while(!futureTask.isDone()) {

            }
            try {
                System.out.println(futureTask.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            threadPool.shutdown();
        });

        System.out.println(registry);
    }

}
