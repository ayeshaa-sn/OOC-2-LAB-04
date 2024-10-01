import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlBookReader implements BookReader {
    @Override
    public List<Book> readBooks(String filePath) {
        List<Book> books = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Book book = new Book(
                            element.getElementsByTagName("title").item(0).getTextContent(),
                            element.getElementsByTagName("author").item(0).getTextContent(),
                            element.getElementsByTagName("genre").item(0).getTextContent(),
                            Integer.parseInt(element.getElementsByTagName("pages").item(0).getTextContent()),
                            element.getElementsByTagName("date_read").item(0).getTextContent()
                    );
                    books.add(book);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}
