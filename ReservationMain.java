import java.util.Scanner;

public class ReservationMain {

    private static final User DEMO_USER = new User("admin", "admin123", "Karan");
    private static final int MAX_LOGIN_ATTEMPTS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("       ONLINE RESERVATION SYSTEM         ");
        System.out.println("==========================================");

        if (!doLogin(scanner)) {
            System.out.println("Too many failed attempts. Access denied.");
            scanner.close();
            return;
        }

        ReservationSystem system = new ReservationSystem();
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readValidInt(scanner);

            switch (choice) {
                case 1:
                    system.makeReservation(scanner);
                    break;
                case 2:
                    system.cancelReservation(scanner);
                    break;
                case 3:
                    system.viewReservation(scanner);
                    break;
                case 4:
                    System.out.println("\nLogged out successfully. Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Choose 1-4.");
            }
        }

        scanner.close();
    }

    private static boolean doLogin(Scanner scanner) {
        for (int attempt = 1; attempt <= MAX_LOGIN_ATTEMPTS; attempt++) {
            System.out.print("\nLogin ID : ");
            String id = scanner.next();
            System.out.print("Password : ");
            String pass = scanner.next();

            if (DEMO_USER.authenticate(id, pass)) {
                System.out.println("Login successful. Welcome, " + DEMO_USER.getName() + "!");
                return true;
            } else {
                int remaining = MAX_LOGIN_ATTEMPTS - attempt;
                if (remaining > 0)
                    System.out.println("Invalid credentials. " + remaining + " attempt(s) remaining.");
            }
        }
        return false;
    }

    private static void printMenu() {
        System.out.println("\n======== MAIN MENU ========");
        System.out.println("1. Make Reservation");
        System.out.println("2. Cancel Reservation");
        System.out.println("3. View Reservation");
        System.out.println("4. Logout");
        System.out.print("Choose an option: ");
    }

    private static int readValidInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
