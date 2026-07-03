import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ReservationSystem {
    private final Map<String, Ticket> reservations;
    private final Random random;

    // Predefined train data (train number → train name)
    private static final Map<String, String> TRAINS = new HashMap<>();

    static {
        TRAINS.put("12345", "Rajdhani Express");
        TRAINS.put("22221", "Duronto Express");
        TRAINS.put("11001", "Shatabdi Express");
        TRAINS.put("16001", "Kerala Express");
        TRAINS.put("12001", "Gatimaan Express");
    }

    public ReservationSystem() {
        this.reservations = new HashMap<>();
        this.random = new Random();
    }

    public void makeReservation(Scanner scanner) {
        System.out.println("\n====== RESERVATION FORM ======");

        scanner.nextLine(); // clear buffer
        System.out.print("Passenger Name      : ");
        String name = scanner.nextLine();

        System.out.print("Train Number        : ");
        String trainNumber = scanner.nextLine().trim();

        String trainName = TRAINS.getOrDefault(trainNumber, "Unknown Train");
        System.out.println("Train Name          : " + trainName);

        System.out.println("Class Type Options  : 1. Sleeper  2. AC 3-Tier  3. AC 2-Tier  4. First Class");
        System.out.print("Select Class Type   : ");
        int classChoice = readValidInt(scanner);
        String classType = getClassType(classChoice);

        System.out.print("Date of Journey (DD/MM/YYYY): ");
        String date = scanner.nextLine().trim();

        System.out.print("From (Source)       : ");
        String from = scanner.nextLine().trim();

        System.out.print("To (Destination)    : ");
        String to = scanner.nextLine().trim();

        String pnr = generatePNR();

        Ticket ticket = new Ticket(pnr, name, trainNumber, trainName, classType, date, from, to);
        reservations.put(pnr, ticket);

        System.out.println("\nReservation successful!");
        ticket.display();
        System.out.println("Please save your PNR Number: " + pnr);
    }

    public void cancelReservation(Scanner scanner) {
        System.out.println("\n====== CANCELLATION FORM ======");
        System.out.print("Enter PNR Number: ");
        String pnr = scanner.next().trim();

        Ticket ticket = reservations.get(pnr);

        if (ticket == null) {
            System.out.println("No reservation found for PNR: " + pnr);
            return;
        }

        ticket.display();

        System.out.print("\nConfirm cancellation? (yes/no): ");
        String confirm = scanner.next();

        if (confirm.equalsIgnoreCase("yes")) {
            reservations.remove(pnr);
            System.out.println("Ticket with PNR " + pnr + " has been successfully cancelled.");
        } else {
            System.out.println("Cancellation aborted.");
        }
    }

    public void viewReservation(Scanner scanner) {
        System.out.print("\nEnter PNR Number to view: ");
        String pnr = scanner.next().trim();

        Ticket ticket = reservations.get(pnr);
        if (ticket != null) {
            ticket.display();
        } else {
            System.out.println("No reservation found for PNR: " + pnr);
        }
    }

    private String generatePNR() {
        return "PNR" + (100000 + random.nextInt(900000));
    }

    private String getClassType(int choice) {
        switch (choice) {
            case 1: return "Sleeper";
            case 2: return "AC 3-Tier";
            case 3: return "AC 2-Tier";
            case 4: return "First Class";
            default: return "Sleeper";
        }
    }

    private int readValidInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        return val;
    }
}
