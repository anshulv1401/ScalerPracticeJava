package Library;

import Books.Book;

public class Librarian extends User {

    private String employeeNumber;

    public Librarian(String employeeNumber) {
        super();
        this.employeeNumber = employeeNumber;
    }

    public Librarian(String employeeNumber, String name, String contactInfo) {
        super(name, contactInfo);
        this.employeeNumber = employeeNumber;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Library.Librarian Dashboard");
        System.out.println("Name :" + getName());
        System.out.println("Employee Number: " + employeeNumber);
    }

    @Override
    public boolean canBorrowBooks() {
        return true;
    }

    @Override
    public void returnBook() {
        System.out.println("Book returned");
    }

    void addNewBook(Book book) {
        System.out.println("New book added");
    }

    void removeBook(Book book) {
        System.out.println("Book removed");
    }

}
