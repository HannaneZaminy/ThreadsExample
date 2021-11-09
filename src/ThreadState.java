public class ThreadState {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread());
        Thread[] allThreads = {Thread.currentThread(), thread1, thread2};
        Thread daemonThread = new Thread(new MyDaemon(allThreads));
        daemonThread.setDaemon(true);

        daemonThread.start();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("...FINISHED...");
    }
}

class MyDaemon implements Runnable {
    private Thread[] allThreads;

    public MyDaemon(Thread[] allThreads) {
        this.allThreads = allThreads;
    }

    @Override
    public void run() {
        while (true) {
            for (Thread thread : allThreads) {
                System.out.println(thread.getId() + " state : " + thread.getState());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getId() + " start running...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}