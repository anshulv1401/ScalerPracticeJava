package Books;

import Library.User;

public interface ILendable {

    boolean lend(User user);

    void returnBook(User user);

    boolean isAvailable();
}
