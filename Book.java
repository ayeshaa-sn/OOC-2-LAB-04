public class Book {

        private String title, author, genre,date;
        private int numberOfPages;

        public Book(String title, String author, String genre, int numberOfPages, String date){
            this.title=title;
            this.author=author;
            this.genre=genre;
            this.numberOfPages=numberOfPages;
            this.date=date;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getGenre() {
            return genre;
        }

        public int getNumberOfPages() {
            return numberOfPages;
        }

        public String getDate() {
            return date;
        }
    }

