import java.util.*;

class ReservationSystem {
    private static Map<String, String> userDatabase = new HashMap<>();
    private static List<String> reservations = new ArrayList<>();

    
    public static void main(String[] args) {
        
        userDatabase.put("user", "password");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Reservation System!");
          
         
        
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Make a Reservation");
            System.out.println("2. View Reservations");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    makeReservation(scanner);
                    break;

                case 2:
                    viewReservations();
                    break;

                case 3:
                    cancelReservation(scanner);
                    break;

                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Online Reservation System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    
    private static void makeReservation(Scanner scanner) {
        System.out.println("\nMake a Reservation:");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter date of journey (dd-mm-yyyy): ");
        String date = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        String reservation = "Name: " + name + ", Train: " + trainNumber + ", Date: " + date + ", Destination: " + destination;
        reservations.add(reservation);
        System.out.println("Reservation successful!");
    }

      
    private static void viewReservations() {
        System.out.println("\nYour Reservations:");
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (int i = 0; i < reservations.size(); i++) {
                System.out.println((i + 1) + ". " + reservations.get(i));
            }
        }
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.println("\nCancel a Reservation:");
        if (reservations.isEmpty()) {
            System.out.println("No reservations to cancel.");
            return;
        }

        viewReservations();

        System.out.print("Enter the number of the reservation to cancel: ");
        int reservationNumber = scanner.nextInt();
        scanner.nextLine(); 

        if (reservationNumber > 0 && reservationNumber <= reservations.size()) {
            reservations.remove(reservationNumber - 1);
            System.out.println("Reservation cancelled successfully!");
        } else {
            System.out.println("Invalid reservation number. Please try again.");
        }
    }
}