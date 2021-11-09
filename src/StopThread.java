public class StopThread {

    public static void main(String[] args) {
        Thread th1 = new Thread(new Runnable1());
        Runnable2 runnable2 = new Runnable2();
        Thread th2 = new Thread(runnable2);

        /*th1.start();
        th1.stop();
        th2.start();*/

        //th1.start(); => IllegalThreadStateException

        // stop deprecated from java 1.2
        // stop/kill threads : boolean variable, interrupt() method
        th2.start();
        //runnable2.stop = true;
        //th2.interrupt(); => InterruptedException: sleep interrupted

    }
}

class Runnable1 implements Runnable {

    @Override
    public void run() {
        System.out.println("First Runnable");
    }
}

class Runnable2 implements Runnable {

    boolean stop = false;

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Second Runnable : " + i);
            if (i == 5) {
//                Thread.currentThread().stop();

                /*if (stop) {
                    System.out.println("Come out of run() method");
                    return;
                }*/

                if (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread State : " + Thread.currentThread().getState());
                    return;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}