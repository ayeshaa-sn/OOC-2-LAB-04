import java.util.List;

public class BookListApp {

    public List<Book> readBooksFromFile(String filePath) {
        BookReader bookReader = BookReaderFactory.getBookReader(filePath);
        return bookReader.readBooks(filePath);
    }

    public static void main(String[] args) {
        BookListApp app = new BookListApp();
        List<Book> books = app.readBooksFromFile("C:\\Users\\AYESHA\\IdeaProjects\\OOPLab04\\src\\BookList.xml");
        for (Book book: books){
            System.out.println(book.getTitle()+","+book.getAuthor()+","+book.getGenre()+","+book.getNumberOfPages()+","+book.getDate());
        }
    }
}
