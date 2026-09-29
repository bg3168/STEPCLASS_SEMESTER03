import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {
    protected String title;
    protected LocalDate currentDate = LocalDate.of(2023, 10, 26);

    LibraryItem(String title) {
        this.title = title;
    }

    abstract LocalDate calculateDueDate();
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    LocalDate calculateDueDate() {
        return currentDate.plusDays(14);
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    LocalDate calculateDueDate() {
        return currentDate.plusDays(7);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    LocalDate calculateDueDate() {
        return currentDate.plusDays(3);
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            String[] parts = line.split(" ", 2);
            String type = parts[0];
            String title = parts[1];

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                default:
                    item = new Magazine(title);
            }

            System.out.println(item.title + ": " + item.calculateDueDate());
        }

        sc.close();
    }
}