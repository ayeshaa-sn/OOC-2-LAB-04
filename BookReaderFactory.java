public class BookReaderFactory {

    public static BookReader getBookReader(String filePath) {
        if (filePath.endsWith(".csv")) {
            return new CsvBookReader();
        }
        else if (filePath.endsWith(".json")) {
            return new JsonBookReader();
        }
        else if (filePath.endsWith(".xml")) {
            return new XmlBookReader();
        }
        throw new IllegalArgumentException("Unsupported file format: " + filePath);
    }
}
