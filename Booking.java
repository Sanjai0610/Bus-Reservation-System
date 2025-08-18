package busResv;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
    // Make fields private for encapsulation
    private String passengerName;
    private int busNo;
    private Date date;

    // Getters for fields
    public String getPassengerName() { return passengerName; }
    public int getBusNo() { return busNo; }
    public Date getDate() { return date; }

    Booking() {
        Scanner scanner = new Scanner(System.in);

        // Input validation for passenger name
        while (true) {
            System.out.print("Enter name of passenger: ");
            passengerName = scanner.nextLine().trim();
            if (!passengerName.isEmpty()) break;
            System.out.println("Name cannot be empty. Please try again.");
        }

        // Input validation for bus number
        while (true) {
            System.out.print("Enter bus no: ");
            if (scanner.hasNextInt()) {
                busNo = scanner.nextInt();
                scanner.nextLine(); // consume newline
                break;
            } else {
                System.out.println("Invalid bus number. Please enter a valid integer.");
                scanner.nextLine(); // clear invalid input
            }
        }

        // Input validation for date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        while (true) {
            System.out.print("Enter date (dd-MM-yyyy): ");
            String dateInput = scanner.nextLine().trim();
            try {
                date = dateFormat.parse(dateInput);
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity = 0;
        for (Bus bus : buses) {
            if (bus.getBusNo() == busNo)
                capacity = bus.getCapacity();
        }

        int booked = 0;
        for (Booking b : bookings) {
            if (b.busNo == busNo && b.date.equals(date)) {
                booked++;
            }
        }

        return booked < capacity;
    }

    // Optional: Override toString for better display
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return "Booking [Name: " + passengerName + ", Bus No: " + busNo + ", Date: " + dateFormat.format(date) + "]";
    }
}