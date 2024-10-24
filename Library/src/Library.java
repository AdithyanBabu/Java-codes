import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();

    public Library() {
        loadBooks();
    }

    private void loadBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader("book.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Split by comma
                if (parts.length == 2) {
                    String bookName = parts[0].trim();
                    String author = parts[1].trim();
                    books.add(new Book(bookName, author));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println(book.getName() + " by " + book.getAuthor());
        }
    }

    public Book getBook(String bookName) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null; // Book not found
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void addBook(Book book) {
        books.add(book); // Add the book back to the library
    }
}
