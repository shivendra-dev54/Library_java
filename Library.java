package Library_java;

import java.io.*;
import java.util.*;

class Library {
    private List<Book> books = new ArrayList<>();
    private final String fileName = "./library_data.txt"; // Relative path for current directory

    public void loadBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    books.add(new Book(parts[0], parts[1], parts[2]));
                } else if (parts.length == 2) {
                    books.add(new Book(parts[0], parts[1]));
                } else {
                    System.out.println("Invalid book data: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
    }

    public void saveBooks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Book book : books) {
                writer.write(book.getTitle() + ";" + book.getAuthor() + ";" + book.getBorrower() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void borrowBook(String title, String borrower) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getBorrower().isEmpty()) {
                book.setBorrower(borrower);
                System.out.println("Book borrowed successfully.");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void showAllBooks() {
        System.out.println("\nAll Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showWhoBorrowedBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.getBorrower().isEmpty()) {
                    System.out.println("No one has borrowed this book yet.");
                } else {
                    System.out.println("Borrowed by: " + book.getBorrower());
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
