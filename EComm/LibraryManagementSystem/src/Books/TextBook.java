package Books;

public class TextBook extends Book {

    private String subject;
    private String edition;


    public TextBook(String isbn, String title, String author, String subject, String edition) {
        super(isbn, title, author);
        this.subject = subject;
        this.edition = edition;
        type = "TextBook";
    }

    @Override
    public void displayBookDetails() {
        System.out.println("Isbn: " + isbn);
        System.out.println("Subject: " + subject);
        System.out.println("Edition: " + edition);
    }
}
