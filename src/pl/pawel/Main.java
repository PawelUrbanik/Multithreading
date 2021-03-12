package pl.pawel;

import java.util.stream.IntStream;

public class Main {



    public static void main(String[] args) throws InterruptedException {
        System.out.println("Główny wątek: " + Thread.currentThread().getName());
        Thread myThread = new MyThread("My thread");
        Thread secondThread = new MyThread("My thread 2");


        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable, "My runnable");

//        Runnable runnable2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(" | Wykonywany wątek " + Thread.currentThread().getName());
//            }
//        };

        Runnable runnable2 = () ->{
                        IntStream.rangeClosed(1,5).forEach(i -> {
                            System.out.println(i+" | Wykonywany wątek " + Thread.currentThread().getName());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
        };

        //Lambda expression
        Thread thread1 = new Thread(runnable2, "My runnable anonymous");
        thread1.start();
        thread1.join();
        thread.start();
        myThread.start();
        secondThread.start();

    }
}
