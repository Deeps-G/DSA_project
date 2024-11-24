package Project11;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    // Add an Event
    public void addEvent(Event event) {
        events.add(event);
        System.out.println("Event added successfully!");

        // Handle recurring events
        if (!event.getRecurrence().equalsIgnoreCase("None")) {
            addRecurringEvents(event);
        }
    }

    // Generate recurring events
    private void addRecurringEvents(Event event) {
        LocalDate currentDate = event.getDate();
        for (int i = 1; i <= 10; i++) { // Add 10 instances of the recurring event
            switch (event.getRecurrence()) {
                case "Daily":
                    currentDate = currentDate.plusDays(1);
                    break;
                case "Weekly":
                    currentDate = currentDate.plusWeeks(1);
                    break;
                case "Monthly":
                    currentDate = currentDate.plusMonths(1);
                    break;
            }
            events.add(new Event(event.getTitle(), currentDate, event.getTime(),
                                 event.getLocation(), event.getDescription(), "None"));
        }
    }

    // View Events (Optionally filter by a time frame)
    public void viewEvents(LocalDate startDate, LocalDate endDate) {
        boolean found = false;
        for (Event event : events) {
            if ((startDate == null || !event.getDate().isBefore(startDate)) &&
                (endDate == null || !event.getDate().isAfter(endDate))) {
                System.out.println(event);
                System.out.println("--------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No events found in the specified time frame.");
        }
    }

    // Other methods (search and delete remain unchanged)
    public void searchEvent(String title) {
        boolean found = false;
        for (Event event : events) {
            if (event.getTitle().equalsIgnoreCase(title)) {
                System.out.println(event);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No events found with the title: " + title);
        }
    }

    public void deleteEvent(String title) {
        boolean removed = events.removeIf(event -> event.getTitle().equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Event deleted successfully!");
        } else {
            System.out.println("No event found with the title: " + title);
        }
    }
}