import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Event {
    String name;
    LocalDate date;

    public Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); 

        List<Event> events = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String eventName = parts[0];
            String dateStr = parts[1];

            
            LocalDate date = LocalDate.parse(dateStr);
            events.add(new Event(eventName, date));
        }

        
        events.sort(Comparator.comparing(Event::getDate));

        
        String sortedNames = events.stream()
                .map(Event::getName)
                .collect(Collectors.joining(" "));
        System.out.println(sortedNames);

        
        if (!events.isEmpty()) {
            System.out.println(events.get(0).getName()); 
            System.out.println(events.get(events.size() - 1).getName()); 
        }

        
        if (sc.hasNextInt()) {
            int targetMonth = sc.nextInt();
            
            String monthEvents = events.stream()
                    .filter(e -> e.getDate().getMonthValue() == targetMonth)
                    .map(Event::getName)
                    .collect(Collectors.joining(" "));
            
            if (!monthEvents.isEmpty()) {
                System.out.println(monthEvents);
            }
        }
        
        sc.close();
    }
}