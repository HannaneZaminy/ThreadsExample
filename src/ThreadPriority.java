public class ThreadPriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) {
        ThreadPriority threadPriority = new ThreadPriority();
        Thread th1 = new Thread(threadPriority);
        Thread th2 = new Thread(threadPriority);
        Thread th3 = new Thread(threadPriority);
        //Thread priority : 1 to 10 , Default priority : 5
        th1.setPriority(4);
        th2.setPriority(8);
        th3.setPriority(2);
//        th3.setPriority(Thread.MAX_PRIORITY);

        th1.start();
        th2.start();
        th3.start();
    }
}
