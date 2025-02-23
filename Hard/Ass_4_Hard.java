import java.util.*;

class TicketBookingSystem {
    private int availableSeats = 5;

    public synchronized void bookSeat(String name, int seats) {
        if (seats <= availableSeats) {
            System.out.println(name + " booked " + seats + " seat(s).");
            availableSeats -= seats;
        } else {
            System.out.println(name + " failed to book seats. Not enough available.");
        }
    }
}

class BookingThread extends Thread {
    TicketBookingSystem system;
    int seats;

    BookingThread(TicketBookingSystem system, String name, int seats, int priority) {
        super(name);
        this.system = system;
        this.seats = seats;
        setPriority(priority); // Setting priority to simulate VIP processing first
    }

    public void run() {
        system.bookSeat(getName(), seats);
    }
}

public class Ass_4_Hard {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();

        // Creating threads for different customers
        BookingThread vip1 = new BookingThread(system, "VIP-1", 2, Thread.MAX_PRIORITY);
        BookingThread vip2 = new BookingThread(system, "VIP-2", 1, Thread.MAX_PRIORITY);
        BookingThread user1 = new BookingThread(system, "User-1", 2, Thread.NORM_PRIORITY);
        BookingThread user2 = new BookingThread(system, "User-2", 1, Thread.MIN_PRIORITY);

        // Starting threads
        vip1.start();
        vip2.start();
        user1.start();
        user2.start();

        try {
            vip1.join();
            vip2.join();
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All bookings processed.");
    }
}