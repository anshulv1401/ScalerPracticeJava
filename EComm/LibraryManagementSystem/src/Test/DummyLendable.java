package Test;

import Books.ILendable;
import Library.User;

public class DummyLendable implements ILendable {
    @Override
    public boolean lend(User user) {
        return false;
    }

    @Override
    public void returnBook(User user) {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }
}
