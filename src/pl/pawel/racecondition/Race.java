package pl.pawel.racecondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Race {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Counter counter = new Counter();

        for (int i = 0; i < 1000; i++) {
            executorService.submit(()-> counter.incerase());
        }

        executorService.awaitTermination(3, TimeUnit.SECONDS);
        executorService.shutdown();

        System.out.println(counter.getCount());
    }


}

class Counter{
    private int count;

    //or synchronized public void increase()
    public void incerase(){

        synchronized (this)
        {
            count = count +1;
        }
    }

    public int getCount() {
        return count;
    }
}
