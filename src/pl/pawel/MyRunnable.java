package pl.pawel;

import java.util.stream.IntStream;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        IntStream.rangeClosed(1,20).forEach(i -> {
            System.out.println(i+" | Wykonywany wątek " + Thread.currentThread().getName());
        });
    }
}
