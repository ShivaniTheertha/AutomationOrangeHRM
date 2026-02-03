package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDataUtils {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private static String getTimestamp() {
        return LocalDateTime.now().format(FORMATTER);
    }

    public static String generateFirstName() {
        return "John";
    }

    public static String generateLastName() {
        return "Brown" + getTimestamp();
    }
}
