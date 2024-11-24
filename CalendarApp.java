
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class CalendarApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManager eventManager = new EventManager();

        while (true) {
            System.out.println("---- Calendar Application ----");
            System.out.println("1. Add Event");
            System.out.println("2. View All Events");
            System.out.println("3. View Events by Date Range");
            System.out.println("4. Search Event");
            System.out.println("5. Delete Event");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter event title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter event date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter event time (HH:MM): ");
                    LocalTime time = LocalTime.parse(scanner.nextLine());
                    System.out.print("Enter event location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter event description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter recurrence (None/Daily/Weekly/Monthly): ");
                    String recurrence = scanner.nextLine();

                    Event event = new Event(title, date, time, location, description, recurrence);
                    eventManager.addEvent(event);
                    break;

                case 2:
                    eventManager.viewEvents(null, null);
                    break;

                case 3:
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    LocalDate startDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    LocalDate endDate = LocalDate.parse(scanner.nextLine());
                    eventManager.viewEvents(startDate, endDate);
                    break;

                case 4:
                    System.out.print("Enter event title to search: ");
                    String searchTitle = scanner.nextLine();
                    eventManager.searchEvent(searchTitle);
                    break;

                case 5:
                    System.out.print("Enter event title to delete: ");
                    String deleteTitle = scanner.nextLine();
                    eventManager.deleteEvent(deleteTitle);
                    break;

                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
