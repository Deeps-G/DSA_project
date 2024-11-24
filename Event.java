package Project11;
import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
    private String title;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private String description;
    private String recurrence; // Recurrence type: "None", "Daily", "Weekly", "Monthly"

    // Constructor
    public Event(String title, LocalDate date, LocalTime time, String location, String description, String recurrence) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.recurrence = recurrence;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }
    public String getRecurrence() { return recurrence; }

    @Override
    public String toString() {
        return "Event: " + title + "\nDate: " + date + "\nTime: " + time +
               "\nLocation: " + location + "\nDescription: " + description +
               "\nRecurrence: " + recurrence;
    }
}