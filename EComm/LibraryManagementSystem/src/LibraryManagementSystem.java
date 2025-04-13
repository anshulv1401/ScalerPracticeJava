import Books.Book;
import Library.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {

    private List<Book> bookInventory;
    private List<User> registeredUsers;

    public LibraryManagementSystem() {
        registeredUsers = new ArrayList<>();
        bookInventory = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookInventory.add(book);
    }

    public void registerUser(User user) {
        registeredUsers.add(user);
    }

    public Book searchBook(String criteria) {

        for (Book book : bookInventory) {
            if (book.getAuthor().equalsIgnoreCase(criteria)
                    || book.getTitle().equalsIgnoreCase(criteria))
                return book;
        }

        return null;
    }

    public Book searchBook(String criteria, String type) {
        for (Book book : bookInventory) {
            if (book.getAuthor().equalsIgnoreCase(criteria)
                    || book.getTitle().equalsIgnoreCase(criteria)) {

                if (type.equalsIgnoreCase(book.getType()))
                    return book;
            }
        }

        return null;
    }

}
