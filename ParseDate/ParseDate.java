import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
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
        try {
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("EEEE d MMMM yyyy")
                .toFormatter(Locale.FRENCH);
            return LocalDate.parse(stringDate, formatter);
        } catch (DateTimeParseException e) {
            try {
                DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .parseCaseInsensitive()
                    .appendPattern("EEEE d MMMM yyyy")
                    .toFormatter(Locale.ENGLISH);
                return LocalDate.parse(stringDate, formatter);
            } catch (DateTimeParseException ignored) {
                return null;
            }
        }
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh 'heures du' a, mm 'minutes et' ss 'secondes'", Locale.FRENCH);
            return LocalTime.parse(stringDate, formatter);
        } catch (DateTimeParseException e) {
            try {
                String normalized = stringDate
                    .replace("in the morning", "AM")
                    .replace("in the evening", "PM")
                    .replace("at night", "PM");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh 'hours' a, mm 'minutes and' ss 'seconds'", Locale.ENGLISH);
                return LocalTime.parse(normalized, formatter);
            } catch (DateTimeParseException ignored) {
                return null;
            }
        }
    }
}
