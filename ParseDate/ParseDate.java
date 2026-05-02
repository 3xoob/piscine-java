import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        try {
            return LocalDateTime.parse(stringDate);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy", Locale.FRENCH);
        try {
            return LocalDate.parse(stringDate, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh 'heures du' a, mm 'minutes et' ss 'secondes'", Locale.FRENCH);
        try {
            return LocalTime.parse(stringDate, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
