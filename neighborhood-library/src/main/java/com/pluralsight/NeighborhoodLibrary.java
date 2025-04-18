package com.pluralsight;

// Import
import java.util.Scanner;

// Main class
public class NeighborhoodLibrary {

    private static Book[] books = new Book[20];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBooks();
        runLibrary();
    }
//Array for books
    private static void initializeBooks() {
        for (int i = 0; i < 20; i++) {
            books[0] = new Book(1, "ISBN1001", "The Great Gatsby");
            books[1] = new Book(2, "ISBN1002", "To Kill a Mockingbird");
            books[2] = new Book(3, "ISBN1003", "1984");
            books[3] = new Book(4, "ISBN1004", "Pride and Prejudice");
            books[4] = new Book(5, "ISBN1005", "Moby-Dick");
            books[5] = new Book(6, "ISBN1006", "The Catcher in the Rye");
            books[6] = new Book(7, "ISBN1007", "Jane Eyre");
            books[7] = new Book(8, "ISBN1008", "The Hobbit");
            books[8] = new Book(9, "ISBN1009", "Fahrenheit 451");
            books[9] = new Book(10, "ISBN1010", "Little Women");
            books[10] = new Book(11, "ISBN1011", "Brave New World");
            books[11] = new Book(12, "ISBN1012", "Wuthering Heights");
            books[12] = new Book(13, "ISBN1013", "The Odyssey");
            books[13] = new Book(14, "ISBN1014", "Frankenstein");
            books[14] = new Book(15, "ISBN1015", "Crime and Punishment");
            books[15] = new Book(16, "ISBN1016", "The Scarlet Letter");
            books[16] = new Book(17, "ISBN1017", "Dracula");
            books[17] = new Book(18, "ISBN1018", "The Adventures of Huckleberry Finn");
            books[18] = new Book(19, "ISBN1019", "Les Misérables");
            books[19] = new Book(20, "ISBN1020", "The Count of Monte Cristo");
        }
    }
// Main menu loop
    private static void runLibrary() {
        while (true) {
            System.out.println("\nWelcome to the Neighborhood Library!");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    showCheckedOutBooks();
                    break;
                case 3:
                    System.out.println("Thank you for visiting the library. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.printf("ID: %d | ISBN: %s | Title: %s\n", book.getId(), book.getIsbn(), book.getTitle());
            }
        }
        System.out.println("Enter the ID of the book to check out or 0 to return to main menu: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (id > 0 && id <= books.length && !books[id - 1].isCheckedOut()) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            books[id - 1].checkOut(name);
            System.out.println("Book checked out successfully.");
        }
    }

    private static void showCheckedOutBooks() {
        System.out.println("\nChecked Out Books:");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.printf("ID: %d | ISBN: %s | Title: %s | Checked Out To: %s\n",
                        book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
            }
        }
        System.out.println("Enter 'C' to check in a book or 'X' to return to main menu: ");
        String input = scanner.nextLine().toUpperCase();
        if (input.equals("C")) {
            System.out.print("Enter the ID of the book to check in: ");
            int id = Integer.parseInt(scanner.nextLine());
            if (id > 0 && id <= books.length && books[id - 1].isCheckedOut()) {
                books[id - 1].checkIn();
                System.out.println("Book checked in successfully.");
            } else {
                System.out.println("Invalid book ID.");
            }
        }
    }
}