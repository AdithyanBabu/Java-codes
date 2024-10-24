import java.util.ArrayList;
import java.util.Scanner;

public class User extends Person {
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    private Library library;

    public User(String userId, String name, String password, Library library) {
        super(name, password);
        this.library = library;
    }

    public void displayMenu() {
        while (true) {
            System.out.println("User Menu for " + personName + ":\n" +
                    "1. Borrow a book\n" +
                    "2. Return a book\n" +
                    "3. View borrowed books\n" +
                    "4. View available books in the library\n" +
                    "5. Logout");

            int choice = -1;
            while (choice < 1 || choice > 5) {
                System.out.print("Choose an option (1-5): ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 5) {
                        System.out.println("Invalid option! Please enter a number between 1 and 5.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number between 1 and 5.");
                    scanner.next(); // Clear the invalid input
                }
            }

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Clear the newline character
                    System.out.print("Enter the name of the book to borrow (without author): ");
                    String bookToBorrow = scanner.nextLine();
                    borrowBook(bookToBorrow);
                    break;
                case 2:
                    scanner.nextLine(); // Clear the newline character
                    System.out.print("Enter the name of the book to return (without author): ");
                    String bookToReturn = scanner.nextLine();
                    returnBook(bookToReturn);
                    break;
                case 3:
                    displayBorrowedBooks();
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Logging out.");
                    return; // Exit the menu loop
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    void borrowBook(String bookName) {
        Book bookToBorrow = library.getBook(bookName);
        if (bookToBorrow != null) {
            borrowedBooks.add(bookToBorrow);
            library.removeBook(bookToBorrow); // Assuming you have this method to remove a book
            System.out.println("You have borrowed: " + bookToBorrow.getName());
        } else {
            System.out.println("Sorry, the book \"" + bookName + "\" is not available.");
        }
    }

    void returnBook(String bookName) {
        Book bookToReturn = null;
        // Check if the book to return is in the borrowed list
        for (Book book : borrowedBooks) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                bookToReturn = book;
                break;
            }
        }

        if (bookToReturn != null) {
            borrowedBooks.remove(bookToReturn); // Remove the book from borrowed list
            library.addBook(bookToReturn); // Assuming you have this method to add a book back to the library
            System.out.println("You have returned: " + bookToReturn.getName());
        } else {
            System.out.println("You have not borrowed the book \"" + bookName + "\".");
        }
    }

    void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("You have not borrowed any books.");
        } else {
            System.out.println("Borrowed Books:");
            for (Book book : borrowedBooks) {
                System.out.println(book.getName());
            }
        }
    }
}
