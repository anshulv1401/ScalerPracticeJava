package Test;

import Library.Librarian;

public class BookTest {

    public void BorrowBook_Test() throws Exception {

        DummyLendable dummyLendable = new DummyLendable();

        if (!dummyLendable.lend(new Librarian("DummyEmployeeNumber" )))
            throw new Exception("lending failed to librarian");
    }
}
