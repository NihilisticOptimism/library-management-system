public class main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book(1, "War and Peace",
                "Lev Tolstoy", 1869, "978-5-17-090335-2"));
        library.addBook(new Book(2, "Crime and Punishement",
                "Fyodor Dostoevsky", 1866, "978-5-17-090336-9"));
        library.addBook(new Book(3, "Anna Karenina",
                "Lev Tolstoy", 1877, "978-5-17-090337-6"));

        System.out.println(library.findBookById(1).getTitle());
        for(Book book : library.getAvailableBooks()) {
            System.out.println(book.toString());
        }
        library.borrowBook(2);
        library.returnBook(2);
        library.printOperationLog();
    }
}