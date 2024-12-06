package Library_java;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        library.loadBooks();

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. See All Books");
            System.out.println("4. See Who Borrowed Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    System.out.print("Enter book title to borrow: ");
                    title = scanner.nextLine();
                    System.out.print("Enter borrower's name: ");
                    String borrower = scanner.nextLine();
                    library.borrowBook(title, borrower);
                    break;
                case 3:
                    library.showAllBooks();
                    break;
                case 4:
                    System.out.print("Enter book title to see who borrowed: ");
                    title = scanner.nextLine();
                    library.showWhoBorrowedBook(title);
                    break;
                case 5:
                    library.saveBooks();
                    System.out.println("Exiting the program. Have a great day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
    }
}