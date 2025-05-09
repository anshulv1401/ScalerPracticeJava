package Books;

public class NovelBook extends Book{

    private String genre;

    public NovelBook(String isbn, String title, String author, String genre) {
        super(isbn, title, author);
        this.genre = genre;
        type = "NovelBook";
    }

    @Override
    public void displayBookDetails() {
        System.out.println("Isbn: " + isbn);
        System.out.println("Genre: " + genre);
    }
}
