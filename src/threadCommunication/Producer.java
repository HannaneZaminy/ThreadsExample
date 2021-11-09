package threadCommunication;

public class Producer extends Thread {

    private ThreadCommunicator communicator;

    public Producer(ThreadCommunicator communicator) {
        this.communicator = communicator;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            communicator.produce(i);
        }
    }
}
