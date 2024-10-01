import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonBookReader implements BookReader {
    @Override
    public List<Book> readBooks(String filePath) {
        List<Book> books = new ArrayList<>();
        StringBuilder jsonContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = new JSONArray(jsonContent.toString());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonBook = jsonArray.getJSONObject(i);
            Book book = new Book(
                    jsonBook.getString("title"),
                    jsonBook.getString("author"),
                    jsonBook.getString("genre"),
                    jsonBook.getInt("pages"),
                    jsonBook.getString("date_read")
            );
            books.add(book);
        }
        return books;
    }
}
