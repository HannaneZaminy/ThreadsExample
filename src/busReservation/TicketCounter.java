package busReservation;

public class TicketCounter {

    private int availableSeats;

    public TicketCounter(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public synchronized void bookTicket(String passengerName, int numberOfSeats) {
        if (numberOfSeats <= availableSeats && numberOfSeats > 0) {
            System.out.println("Hi " + passengerName + ", " + numberOfSeats + " Seats booked successfully.");
            availableSeats -= numberOfSeats;
        } else {
            System.out.println("Hi " + passengerName + ", " + numberOfSeats + " Seats not available.");
            System.out.println("Available Seats : " + availableSeats);
        }
    }

}
