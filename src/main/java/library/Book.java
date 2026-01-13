public class Book {

    private int id;
    private String title;
    private String author;
    private int year;
    private String isbn;
    private boolean available;

    public Book (int id, String title, String author, int year, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.setAvailable(true);
    }

    public void setAvailable(boolean is_available) {
        this.available = is_available;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean getAvailable() {
        return available;
    }

    public String getStatus() {
        return available ? "Free" : "Taken";
    }

    public String toString() {
        return String.format("[ID: %d] \"%s\" -  %s (%d)\nISBN: %s | Status: %s", id, title, author, year, isbn, getStatus());
    }
}