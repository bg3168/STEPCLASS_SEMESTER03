import java.util.*;

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();

    abstract String getType();
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount * 0.90;
    }

    String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount * 0.95;
    }

    String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount + 10;
    }

    String getType() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            switch (type) {
                case "STUDENT":
                    customer = new Student(amount);
                    break;
                case "STAFF":
                    customer = new Staff(amount);
                    break;
                default:
                    customer = new Guest(amount);
            }

            double finalAmount = customer.calculateFinalAmount();
            total += finalAmount;

            System.out.printf("%s: %.2f%n", customer.getType(), finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}