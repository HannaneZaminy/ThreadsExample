package threadCommunication;

public class Consumer extends Thread {
    private ThreadCommunicator communicator;

    public Consumer(ThreadCommunicator communicator) {
        this.communicator = communicator;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            communicator.consume();
        }
    }
}
