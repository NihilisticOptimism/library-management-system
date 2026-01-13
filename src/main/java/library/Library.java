import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private OperationLog operationLog;
    public static class OperationLog {
        public class LogEntry {
            private OperationType type;
            private LocalDateTime timestamp;
            private String description;
            public LogEntry (OperationType type, LocalDateTime timestamp, String description) {
                this.type = type;
                this.timestamp = timestamp;
                this.description = description;
            }
            public OperationType getType() {
                return type;
            }

            public LocalDateTime getTimestamp() {
                return timestamp;
            }

            public String getDescription() {
                return description;
            }

            @Override
            public String toString() {
                return String.format("Operation %s completed: %s, description: %s", type, timestamp, description);
            }
        }

        public enum OperationType {
            ADD_BOOK, BORROW, RETURN
        }

        private List<LogEntry> entries;

        public OperationLog() {
            this.entries = new ArrayList<>();
        }

        public void addEntry(LogEntry log) {
            entries.add(log);
        }

        public List<LogEntry> getEntries() {
            return entries;
        }

        public void printLog() {
            for(LogEntry log : entries) {
                System.out.println(log.toString());
            }
        }
    }

    public Library () {
        this.books = new ArrayList<>();
        this.operationLog = new OperationLog();
    }

    public void addBook(Book book) {
        books.add(book);
        OperationLog.LogEntry entry = operationLog.new LogEntry(
                OperationLog.OperationType.ADD_BOOK,
                LocalDateTime.now(),
                "Added book: " + book.getTitle() + " (id=" + book.getId() + ")"
        );
        operationLog.addEntry(entry);
    }

    public Book findBookById(int id) {
        for(Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for(Book book : books) {
            if (author != null && author.equals(book.getAuthor())) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public void borrowBook(int id) {
        Book book = findBookById(id);
        if(book != null) {
            if (!book.getAvailable()) {
                System.out.println("Book is already taken");
                return;
            }

            OperationLog.LogEntry entry = operationLog.new LogEntry(
                    OperationLog.OperationType.BORROW,
                    LocalDateTime.now(),
                    "Book " + "(id=" + book.getId() + ") is taken"
            );

            operationLog.addEntry(entry);

            book.setAvailable(false);

            return;
        }
        else {
            System.out.println("Book " + "(id=" + book.getId() + ") is not found");
        }
    }

    public void returnBook(int id) {
        Book book = findBookById(id);
        if(book != null) {
            if (book.getAvailable()) {
                System.out.println("Book has been returned already");
                return;
            }

            OperationLog.LogEntry entry = operationLog.new LogEntry(
                    OperationLog.OperationType.RETURN,
                    LocalDateTime.now(),
                    "Book " + "(id=" + book.getId() + ") is returned"
            );

            operationLog.addEntry(entry);

            book.setAvailable(true);

            return;
        }
        else {
            System.out.println("Book " + "(id=" + book.getId() + ") is not found");
        }

    }
public List<Book> getAvailableBooks() {
        List<Book> booksAvailable = new ArrayList<>();
        for(Book book : books) {
            if (book.getAvailable()) {
                booksAvailable.add(book);
            }
        }
        return booksAvailable;
    }

    public void printOperationLog() {
        operationLog.printLog();
    }
}