package threadCommunication;

public class Main {

    public static void main(String[] args) {
        ThreadCommunicator communicator = new ThreadCommunicator();
        Producer producer = new Producer(communicator);
        Consumer consumer = new Consumer(communicator);

        producer.start();
        consumer.start();
    }
}
