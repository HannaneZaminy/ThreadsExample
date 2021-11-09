package busReservation;

public class Main {
    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter(5);
        TicketBookingThread thread1 = new TicketBookingThread(ticketCounter, "Passenger1", 3);
        TicketBookingThread thread2 = new TicketBookingThread(ticketCounter, "Passenger2", 3);

        thread1.start();
        thread2.start();
    }
}
