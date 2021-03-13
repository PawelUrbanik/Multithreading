package pl.pawel.completablefuture;

import java.sql.Time;
import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture.runAsync(()->
            System.out.println("Wątek: "+ Thread.currentThread().getName())
        );

        CompletableFuture<Integer> res = CompletableFuture.supplyAsync(() ->
        {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Wątek: " + Thread.currentThread().getName());
            return 102;
        }, executorService);

        System.out.println(res.get());


        Thread.sleep(1000);
        executorService.shutdown();

    }
}
