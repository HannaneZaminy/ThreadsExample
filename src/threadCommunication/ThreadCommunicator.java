package threadCommunication;

public class ThreadCommunicator {

    private int number;
    private boolean isDataProduced = false;

    //Data produced: 1
    //Data consumed: 1 ...

    public synchronized void produce(int i) {
        if (isDataProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number = i;
        isDataProduced = true;
        System.out.println("Data produced: " + i);
        notify();
    }

    public synchronized void consume() {
        if (!isDataProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Data consumed: " + number);
        isDataProduced = false;
        notify();
    }
}
