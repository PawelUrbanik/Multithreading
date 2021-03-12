package pl.pawel.fiedexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Główny wątek: " + Thread.currentThread().getName());

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable worker1 = () ->{
            try {
                System.out.println("Robotnik1 - nazwa wątku: "+ Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(10);
            }
            catch (InterruptedException e)
            {
                System.err.println(e.getMessage());
            }
        };

        Runnable worker2 = () ->{
            try {
                System.out.println("Robotnik2 - nazwa wątku: "+ Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
            }
            catch (InterruptedException e)
            {
                System.err.println(e.getMessage());
            }
        };

        Runnable worker3 = () ->{
            try {
                System.out.println("Robotnik3 - nazwa wątku: "+ Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            }
            catch (InterruptedException e)
            {
                System.err.println(e.getMessage());
            }
        };


        executorService.submit(worker1);
        executorService.submit(worker2);
        executorService.submit(worker3);

        executorService.shutdown();

    }
}
