import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvBookReader implements BookReader {

    @Override
    public List<Book> readBooks(String filePath) {
        List<Book> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            if ((line = br.readLine()) != null) {
                // Process the rest of the lines
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");

                    if (values.length == 5) {
                        String title = values[0].trim();
                        String author = values[1].trim();
                        String genre = values[2].trim();
                        int pages = Integer.parseInt(values[3].trim());
                        String dateRead = values[4].trim();

                        Book book = new Book(title, author, genre, pages, dateRead);
                        books.add(book);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }
}
