interface BookIntreface {
    void setTitle(String title);
    String getTitle();
    void setAuthor(String author);
    String getAuthor();
    void setPublishedDate(int publishedDate);
    int getPublishedDate();
    void setReadDate(int readDate);
    int getReadDate();
    void setMedium(BookMedium readMedium);
    BookMedium getMedium();
    void setGenre(BookGenre genre);
    BookGenre getGenre();
    void setRating(BookRating rating);
    BookRating getRating();
}

enum BookGenre {
    Fiction(0),
    NonFiction(1),
    SciFi(2),
    Mystery(3),
    Romance(4),
    Thriller(5),
    Biography(6),
    History(7);

    private final int value;

    private BookGenre(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

enum BookMedium {
    PhysicalBook,
    EBook,
    AudioBook
}

enum BookRating {
    Rating1,
    Rating2,
    Rating3,
    Rating4,
    Rating5
}

class Book implements BookIntreface {
    String title;
    String author;
    int publishedDate;
    int readDate;
    BookMedium medium;
    BookGenre genre;
    BookRating rating;

    public static void main(String[] args) {
        Book b1 = new Book("Children of Time", "Adrian Tchaikovsky", BookGenre.Fiction);
        System.out.println(b1);
        Book b2 = new Book("The Fifth Season", "N. K. Jemisin", BookGenre.Fiction, 2015);
        System.out.println(b2);
        Book b3 = new Book("Perdido Street Station", "China Miéville", BookGenre.SciFi, 2000, 2020, BookMedium.EBook, BookRating.Rating5);
        System.out.println(b3);
    }

    public Book(String title, String author, BookGenre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(String title, String author, BookGenre genre, int publishedDate) {
        this(title, author, genre);
        this.publishedDate = publishedDate;
    }

    public Book(String title, String author, BookGenre genre, int publishedDate, int readDate, BookMedium medium, BookRating rating) {
        this(title, author, genre, publishedDate);
        this.readDate = readDate;
        this.medium = medium;
        this.rating = rating;
    }

    // Getters and setters
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getPublishedDate() {
        return this.publishedDate;
    }

    public void setReadDate(int readDate) {
        this.readDate = readDate;
    }

    public int getReadDate() {
        return this.readDate;
    }

    public void setMedium(BookMedium readMedium) {
        this.medium = readMedium;
    }

    public BookMedium getMedium() {
        return this.medium;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public BookGenre getGenre() {
        return this.genre;
    }

    public void setRating(BookRating rating) {
        this.rating = rating;
    }

    public BookRating getRating() {
        return this.rating;
    }

    // To string
    public String toString() {
        String output;

        if (publishedDate == 0 ) {
            output = getTitle() + " by " + getAuthor();
        } else {
            output = getTitle() + " by " + getAuthor() + " (" + getPublishedDate() + ")";
        }

        if (getReadDate() != 0) {
            output += " - read in " + getReadDate();
        }
        if (getRating() != null) {
            output += ", rated " + getRating().toString().substring(6) + "/5";
        }

        return output;
    }

}

class PublishedBook extends Book{

    BookGenre pGenre;
    String pTitle;
    String pAuthor;
    int pPubDate;
    BookMedium pMedium;

    public PublishedBook(BookGenre pGenre,String pTitle, String pAuthor, int pPubDate, BookMedium pMedium) {
        super(pTitle, pAuthor, pGenre);
        this.pPubDate = pPubDate;
        this.pMedium = pMedium;
    }

    // Getters
    public String getPubTitle() {
        return this.pTitle;
    }

    public String getPubAuthor() {
        return this.pAuthor;
    }

    public BookGenre getPubGenre() {
        return this.pGenre;
    }

    public int getPubDate() {
        return this.pPubDate;
    }

    public BookMedium getPubBookMedium() {
        return this.pMedium;
    }

    // Setters
    public void setPubTitle(String title) {
        this.pTitle = title;
    }

    public void setPubAuthor(String author) {
        this.pAuthor = author;
    }

    public void sePubtBookGenre(BookGenre genre) {
        this.pGenre = genre;
    }

    public void setPubDate(int pubDate) {
        this.pPubDate = pubDate;
    }

    public void setPubBookMedium(BookMedium medium) {
        this.pMedium = medium;
    }

    // To String
    public String toString() {

        if (this.getPubDate() != 0) {
            return super.toString() + " (" + this.getPubDate()  + ")";
        } 

        return super.toString();
    }

}

class ReadBook extends Book {

    BookGenre rGenre;
    String rTitle;
    String rAuthor;
    int rCompDate;
    BookRating rRating;

    public ReadBook(BookGenre rGenre, String rTitle, String rAuthor, int rCompDate, BookRating rRating) {
        super(rTitle, rAuthor, rGenre);
        this.rCompDate = rCompDate;
        this.rRating = rRating;
    }

    // Getters
    public String getReadTitle() {
        return this.rTitle;
    }

    public String getReadAuthor() {
        return this.rAuthor;
    }

    public BookGenre getReadGenre() {
        return this.rGenre;
    }

    public int getReadCompDate() {
        return this.rCompDate;
    }

    public BookRating getReadRating() {
        return this.rRating;
    }

    // Setters
    public void setReadTitle(String title) {
        this.rTitle = title;
    }

    public void setReadAuthor(String author) {
        this.rAuthor = author;
    }

    public void setReadBookGenre(BookGenre genre) {
        this.rGenre = genre;
    }

    public void setReadCompDate(int compDate) {
        this.rCompDate = compDate;
    }

    public void setReadRting(BookRating rating) {
        this.rRating = rating;
    }

    // To string
    public String toString() {
        
        if (this.getReadGenre() != null && this.getReadCompDate() != 0 && this.getReadRating() != null) {
            return super.toString() + "( " + Integer.toString(this.getReadCompDate()) + " " + this.getReadRating() + " " + this.getReadGenre() + ")";
        }

        return super.toString();
    }

}
