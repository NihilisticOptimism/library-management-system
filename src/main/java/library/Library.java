import java.util.List;
import java.time.LocalDateTime;

public class Library {
    private List<Book> books;
    private OperationLog operationLog;

    // Вложенный статический класс
    public static class OperationLog {
        // Внутренний класс для записи операции
        public class LogEntry {
            private OperationType type;
            private LocalDateTime timestamp;
            private String description;
            // конструктор, геттеры, toString()
        }

        public enum OperationType {
            ADD_BOOK, BORROW, RETURN
        }

        private List<LogEntry> entries;
        // методы: addEntry(), getEntries(), printLog()
    }
}