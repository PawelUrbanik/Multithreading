package pl.pawel.executor;

import pl.pawel.MyRunnable;
import pl.pawel.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Główny wątek: " + Thread.currentThread().getName());

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(" | Wykonywany wątek " + Thread.currentThread().getName());
            }
        };

        Runnable runnable2 = () -> {
            IntStream.rangeClosed(1, 5).forEach(i -> {
                System.out.println(i + " | Wykonywany wątek " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        };

        executorService.submit(runnable2);
        executorService.submit(runnable1);

        executorService.shutdownNow();

    }
}
