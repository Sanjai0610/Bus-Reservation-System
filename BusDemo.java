package busResv;

import java.util.Scanner;
import java.util.ArrayList;

public class BusDemo {

    public static void main(String[] args) {
        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        buses.add(new Bus(1, true, 2));
        buses.add(new Bus(2, false, 50));
        buses.add(new Bus(3, true, 48));

        Scanner scanner = new Scanner(System.in);
        int userOpt;

        System.out.println("Welcome to the Bus Reservation System!");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. View all buses");
            System.out.println("2. Book a ticket");
            System.out.println("3. View all bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            userOpt = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (userOpt) {
                case 1:
                    System.out.println("\nAvailable Buses:");
                    for (Bus b : buses) {
                        b.displayBusInfo();
                    }
                    break;
                case 2:
                    Booking booking = new Booking();
                    if (booking.isAvailable(bookings, buses)) {
                        bookings.add(booking);
                        System.out.println("Your booking is confirmed!");
                    } else {
                        System.out.println("Sorry. Bus is full. Try another bus or date.");
                    }
                    break;
                case 3:
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings yet.");
                    } else {
                        System.out.println("\nAll Bookings:");
                        for (Booking b : bookings) {
                            System.out.println(b);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the Bus Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (userOpt != 4);

        scanner.close();
    }
}