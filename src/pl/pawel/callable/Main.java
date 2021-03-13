package pl.pawel.callable;

import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Główny wątek: " + Thread.currentThread().getName());

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> worker1 = () ->{
            System.out.println("Callable interface " + Thread.currentThread().getName());
            return 100;
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


        Future<Integer> res = executorService.submit(worker1);
        System.out.println(res.get());

        executorService.shutdown();

    }
}
