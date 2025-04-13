import Books.Book;
import Books.NovelBook;
import Books.TextBook;
import Library.Librarian;
import Library.Member;
import Library.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Client {
    public static void main(String[] args) {

        LibraryManagementSystem lms = new LibraryManagementSystem();
        Book book1 = new TextBook("isbn1", "Ncert", "Mohit", "Science", "IAM");
        Book book2 = new TextBook("isbn1", "Ncert", "Rakesh", "Science", "IAM");

        lms.addBook(book1);
        lms.addBook(book2);

        User user1 = new Member("Mohit", "");
        User user2 = new Librarian("emp-001", "Rajesh", "");

        lms.registerUser(user1);
        lms.registerUser(user2);

        if (book1.lend(user1)) {
            System.out.println("Book lent to " + user1.getName());
        }
        else {
            System.out.println("Book not lent to " + user1.getName());
        }

        if (book1.lend(user2)) {
            System.out.println("Book lent to " + user2.getName());
        }
        else {
            System.out.println("Book not lent to " + user2.getName());
        }

        book1.returnBook(user1);

        if (book1.lend(user2)) {
            System.out.println("Book lent to " + user2.getName());
        }
        else {
            System.out.println("Book not lent to " + user2.getName());
        }
    }
}