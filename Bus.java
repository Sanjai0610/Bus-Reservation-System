package busResv;

public class Bus {
    private int busNo;
    private boolean ac;
    private int capacity;

    // Default constructor
    public Bus() {}

    // Parameterized constructor
    public Bus(int no, boolean ac, int cap) {
        this.busNo = no;
        this.ac = ac;
        setCapacity(cap); // Use setter for validation
    }

    // Getters
    public int getBusNo() {
        return busNo;
    }

    public boolean isAc() {
        return ac;
    }

    public int getCapacity() {
        return capacity;
    }

    // Setters with validation
    public void setBusNo(int no) {
        this.busNo = no;
    }

    public void setAc(boolean val) {
        this.ac = val;
    }

    public void setCapacity(int cap) {
        if (cap > 0) {
            this.capacity = cap;
        } else {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
    }

    // Display bus info in a user-friendly way
    public void displayBusInfo() {
        System.out.println(this);
    }

    // Override toString for easy display
    @Override
    public String toString() {
        return "Bus No: " + busNo +
               " | Type: " + (ac ? "AC" : "Non-AC") +
               " | Total Capacity: " + capacity;
    }
}