public class DaemonThread implements Runnable {

    @Override
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println(Thread.currentThread().getName() + " is a daemon thread.");
        } else {
            System.out.println(Thread.currentThread().getName() + " is a normal thread.");
        }
    }

    public static void main(String[] args) {
        DaemonThread daemon = new DaemonThread();
        Thread daemonThread = new Thread(daemon, "My Daemon Thread");
        Thread normalThread = new Thread(daemon, "My Normal Thread");
        daemonThread.setDaemon(true);

        daemonThread.start();
        normalThread.start();

        System.out.println("Main Thread");
    }
}
