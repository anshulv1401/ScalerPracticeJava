package Library;

public class Member extends User {

    private int borrowedBooksCount;
    static final int MAX_BORROW_LIMIT = 5;

    public Member() {
        super();
        borrowedBooksCount = 0;
    }

    public Member(String name, String contactInfo) {
        super(name, contactInfo);
        borrowedBooksCount = 0;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Library.Member Dashboard");
        System.out.println("Name" + getName());
        System.out.println("Books Borrowed: " + borrowedBooksCount);
    }

    @Override
    public boolean canBorrowBooks() {
        return borrowedBooksCount < MAX_BORROW_LIMIT;
    }

    @Override
    public void returnBook() {
        borrowedBooksCount--;
        System.out.println("Book returned");
    }
}
