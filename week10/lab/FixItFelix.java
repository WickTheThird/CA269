
/**
* The purpose of the book interface is that each book has its own unique settings
* which are then later on changed and manipulated and set in the class.
*/
interface BookIntreface {
    /** sets the title of the book
    * @param title takes string and sets in the title of the book
    */
    void setTitle(String title);
    /** returns the title 
    * @return this returns the title
    */
    String getTitle();
    /** sets the author
    * @param author takes string and sets author name
     */
    void setAuthor(String author);
    /** gets the author name 
    * @return this returns the author name
    */
    String getAuthor();
    /** sets the published date of the book
    * @param publishedDate sets the date when the book was published
     */
    void setPublishedDate(int publishedDate);
    /** gets the published date 
    * @return this returns the published date
    */
    int getPublishedDate();
    /** sets the date the reding of the book started
    * @param readDate sets the date when reading started
    */
    void setReadDate(int readDate);
    /** gets the read date 
    * @return this returns the date the book reading started
    */
    int getReadDate();
    /** the book medium
    *@param readMedium sets the book medium
    */
    void setMedium(BookMedium readMedium);
    /** gets the book medium 
    * @return this returns the medium of the book
    */
    BookMedium getMedium();
    /** book genre
    *@param genre sets the book genre
     */
    void setGenre(BookGenre genre);
    /** returns the genre of the book 
    * @return this returns the genre of the book
    */
    BookGenre getGenre();
    /** sets the rating
    * @param rating sets the rating of the book
     */
    void setRating(BookRating rating);
    /** returns the rating of the book 
    * @return this returns the rating of the book
    */
    BookRating getRating();
}

/**
* Book genre returns a genre based on a key 
*/
enum BookGenre {
    /** this is finction enum */
    Fiction(0), 
    /** this is a nonfiction enum */
    NonFiction(1),
    /** this is a scifi enum */
    SciFi(2),
    /** this is the mystery enum */
    Mystery(3),
    /** this is the romance enum */
    Romance(4),
    /** this is the thriller enum */
    Thriller(5),
    /** this is teh biography enum */
    Biography(6),
    /** this is the history enum */
    History(7);

    /** this is the index used for the enums */
    private final int value;

    /** this sets the value that is used to get the book genre enum
    * @param value takes in for setting the genre and it returns a value with get value
    */
    private BookGenre(int value) {
        this.value = value;
    }

    /** this gets the value
    * @return returns value aka the book genre in case one needs the index/to use that genre somewhere else
     */
    public int getValue() {
        return value;
    }
}

/**
* sets medium modes that can be assigned for books
*/
enum BookMedium {
    /** this is the physical enum */
    PhysicalBook,
    /** ebook enum */
    EBook,
    /** audio book enum */
    AudioBook
}

/**
* rating levels for the books
*/
enum BookRating {
    /** rating enum */
    Rating1,
    /** rating enum */
    Rating2,
    /** rating enum */
    Rating3,
    /** rating enum */
    Rating4,
    /** rating enum */
    Rating5
}


/**
*
* this is the book class that sets book rating, medium, title, author, etc and shows the information in the terminal
*
*/
class Book implements BookIntreface {
    /** title of book*/
    String title; 
    /** author of the book */
    String author;
    /** When the book was published */
    int publishedDate;
    /** When the reading of the book started */
    int readDate;
    /** This is teh medium of the boook */
    BookMedium medium;
    /** This is the genre of the book */
    BookGenre genre;
    /** This is the rating of the book */
    BookRating rating;

    /**
    * this is the tests that happens in the class
    * @param args takes in array of strngs and here all the testing happens
    */
    public static void main(String[] args) {
        Book b1 = new Book("Children of Time", "Adrian Tchaikovsky", BookGenre.Fiction);
        System.out.println(b1);
        Book b2 = new Book("The Fifth Season", "N. K. Jemisin", BookGenre.Fiction, 2015);
        System.out.println(b2);
        Book b3 = new Book("Perdido Street Station", "China Miéville", BookGenre.SciFi, 2000, 2020, BookMedium.EBook, BookRating.Rating5);
        System.out.println(b3);
    }

/**
    * this initialises the the book class
    * @param title takes in the title to set the title of the book object
    * @param author same as title but with author
    * @param genre takes in en enum from genre
    */
    public Book(String title, String author, BookGenre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    /**
    * this initialises the class given an extra input in the class
    * @param title takes in the title to set the title of the book object
    * @param author same as title but with author
    * @param genre takes in en enum from genre
    * @param publishedDate is an int that can set the date of the book object
    */
    public Book(String title, String author, BookGenre genre, int publishedDate) {
        this(title, author, genre);
        this.publishedDate = publishedDate;
    }

    /**
    * this is the final type of initialisation given that there are extra inputs in the class
    * @param title takes in the title to set the title of the book object
    * @param author same as title but with author
    * @param genre takes in en enum from genre
    * @param publishedDate is an int that can set the date of the book object
    * @param readDate is an int which stores the date in which the book reading started
    * @param medium sets an enum for the book, from BookMedium
    * @param rating sets an enum for the book rating
    */
    public Book(String title, String author, BookGenre genre, int publishedDate, int readDate, BookMedium medium, BookRating rating) {
        this(title, author, genre, publishedDate);
        this.readDate = readDate;
        this.medium = medium;
        this.rating = rating;
    }

    // Getters and setters

    /** sets title */
    public void setTitle(String title) {
        this.title = title;
    }

    /** gets title */
    public String getTitle() {
        return this.title;
    }

    /** sets author */
    public void setAuthor(String author) {
        this.author = author;
    }

    /** gets author */
    public String getAuthor() {
        return this.author;
    }

    /**  sets published date */
    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }

     /** gets published date */
    public int getPublishedDate() {
        return this.publishedDate;
    }

     /** sets a read date */
    public void setReadDate(int readDate) {
        this.readDate = readDate;
    }

    /** gets a read date 
    * @return this returns the date reading started
    */
    public int getReadDate() {
        return this.readDate;
    }

    /** sets a medium */
    public void setMedium(BookMedium readMedium) {
        this.medium = readMedium;
    }

    /** gets the current medium 
    * @return this returs the medium of the book
    */
    public BookMedium getMedium() {
        return this.medium;
    }

    /** set genres of the book */
    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

     /** gets the book genre of the book 
     * @return this returns the genre of the book
     */
    public BookGenre getGenre() {
        return this.genre;
    }

    /** sets a rating for the book */
    public void setRating(BookRating rating) {
        this.rating = rating;
    }

    /** gets the rating of the book 
    * @return returns the rating of the book
    */
    public BookRating getRating() {
        return this.rating;
    }

    /** To string prints out the book information 
    * @return this returns the infomarion to be printed about the books
    */
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

/**
* Published books is a child class of book
* it prints out published books/shows the books that are published,
* it has 2 extra attributes compared to the parent class aka publih date and book medium
*/
class PublishedBook extends Book{

    /** genre */
    BookGenre pGenre;
    /** title */
    String pTitle;
    /** author */
    String pAuthor;
    /** publication date */
    int pPubDate;
    /** medium */
    BookMedium pMedium;

    /**
    the paramaters are explained in the parent class, but this initialises the class like in parent
    * @param pGenre book genre
    * @param pTitle book title
    * @param pAuthor book author
    * @param pPubDate publication date
    * @param pMedium medium of book
    */
    public PublishedBook(BookGenre pGenre,String pTitle, String pAuthor, int pPubDate, BookMedium pMedium) {
        super(pTitle, pAuthor, pGenre);
        this.pPubDate = pPubDate;
        this.pMedium = pMedium;
    }

    // Getters
     /** gets publication title 
     * @return this returns teh title of the book
     */
    public String getPubTitle() {
        return this.pTitle;
    }

     /** gets publication author 
     * @return this returns the author of the book
     */
    public String getPubAuthor() {
        return this.pAuthor;
    }

     /** gets the genre of the publication 
     * @return this retruns the genre of the published book
     */
    public BookGenre getPubGenre() {
        return this.pGenre;
    }

     /** gets the date that this book has been published 
     * @return this returns the date the book was published
     */
    public int getPubDate() {
        return this.pPubDate;
    }

     /** gets the published book medium 
     * @return this returns the medium of the published book
     */
    public BookMedium getPubBookMedium() {
        return this.pMedium;
    }

    // Setters

     /** sets publication title 
     * @param title this is to set the title of the book
     */
    public void setPubTitle(String title) {
        this.pTitle = title;
    }

     /** sets the author of the publication 
     * @param author this is to set the author name
     */
    public void setPubAuthor(String author) {
        this.pAuthor = author;
    }

     /** sets the genre of the book 
     * @param genre this is to set the genre of the book
     */
    public void sePubtBookGenre(BookGenre genre) {
        this.pGenre = genre;
    }

     /** sets a the date that the publication has been published on 
     * @param pubDate this is to set the publication date
     */
    public void setPubDate(int pubDate) {
        this.pPubDate = pubDate;
    }

     /** sets the medium of the book 
     * @param medium this is to set the medium of the book
     */
    public void setPubBookMedium(BookMedium medium) {
        this.pMedium = medium;
    }

    // To String
     /** returns the information of the publication 
     * @return this returns the output info for the published book
     */
    public String toString() {

        if (this.getPubDate() != 0) {
            return super.toString() + " (" + this.getPubDate()  + ")";
        } 

        return super.toString();
    }

}

/**
* Read books is a child class of book
* it prints out read books/shows the books that have been read,
* it has 2 extra attributes compared to the parent class aka completion date and rating
*/
class ReadBook extends Book {

    /** this is describes genre from enum */
    BookGenre rGenre;
    /** the title of the book */
    String rTitle;
    /** the author of the book */
    String rAuthor;
    /** the completion date of the book */
    int rCompDate;
    /** the rating of the book */
    BookRating rRating;

    /**
    the paramaters are explained in the parent class, but this initialises the class like in parent
    * @param rGenre genre of book
    * @param rTitle title of book
    * @param rAuthor author of book
    * @param rCompDate completion date of book
    * @param rRating rating of the book
    */
    public ReadBook(BookGenre rGenre, String rTitle, String rAuthor, int rCompDate, BookRating rRating) {
        super(rTitle, rAuthor, rGenre);
        this.rCompDate = rCompDate;
        this.rRating = rRating;
    }

    // Getters
    /** gets the tile of the read book 
    * @return this returns the title of the book
    */
    public String getReadTitle() {
        return this.rTitle;
    }

    /** gets the title of the author of the read book 
    * @return this returns the atuthor of the book
    */
    public String getReadAuthor() {
        return this.rAuthor;
    }

     /** gets the genre of the read book 
     * @return this returns the genre of the book
     */
    public BookGenre getReadGenre() {
        return this.rGenre;
    }

     /** gets the completion date of the read book 
     * @return this returns the date the book was completed
     */
    public int getReadCompDate() {
        return this.rCompDate;
    }

     /** gets the rating of the book read 
     * @return this returns the rating of the book
     */
    public BookRating getReadRating() {
        return this.rRating;
    }

    // Setters

     /** sets the title of the read book 
     * @param title sets the title of the book
     */
    public void setReadTitle(String title) {
        this.rTitle = title;
    }

     /** sets the author of the read book 
     * @param author sets the author of the book
     */
    public void setReadAuthor(String author) {
        this.rAuthor = author;
    }

     /** sets the genre of the read book 
     * @param genre sets the genre of teh book
     */
    public void setReadBookGenre(BookGenre genre) {
        this.rGenre = genre;
    }

     /** sets the completion date of the read book 
     * @param compDate sets teh completion date of the book
     */
    public void setReadCompDate(int compDate) {
        this.rCompDate = compDate;
    }

     /** sets the rating of the read book 
     * @param rating sets the rating of the book
     */
    public void setReadRting(BookRating rating) {
        this.rRating = rating;
    }

    // To string
     /** this returs a string to the main call that stores all the information about the read book 
     * @return this returns the output info for the read book
     */
    public String toString() {
        
        if (this.getReadGenre() != null && this.getReadCompDate() != 0 && this.getReadRating() != null) {
            return super.toString() + "( " + Integer.toString(this.getReadCompDate()) + " " + this.getReadRating() + " " + this.getReadGenre() + ")";
        }

        return super.toString();
    }

}
