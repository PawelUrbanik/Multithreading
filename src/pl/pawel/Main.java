package pl.pawel;

public class Main {



    public static void main(String[] args) {
        System.out.println("Główny wątek: " + Thread.currentThread().getName());
        Thread myThread = new MyThread("My thread");
        Thread secondThread = new MyThread("My thread 2");
        myThread.start();
        secondThread.start();

        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable, "My runnable");
        thread.start();

//        Runnable runnable2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(" | Wykonywany wątek " + Thread.currentThread().getName());
//            }
//        };
        //Lambda expression
        Thread thread1 = new Thread(() -> System.out.println(" | Wykonywany wątek " + Thread.currentThread().getName()), "My runnable anonymous");
        thread1.start();
    }
}
