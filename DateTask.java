import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class DateTask {
    public static void main(String[] args) {
        Predicate<Integer> isLeapYear = year -> LocalDate.of(year, 1, 1).isLeapYear();

        BiFunction<LocalDate, LocalDate, Long> daysBetween = (d1, d2) -> 
            Math.abs(ChronoUnit.DAYS.between(d1, d2));

        BiFunction<LocalDate, LocalDate, Long> fullWeeksBetween = (d1, d2) -> 
            Math.abs(ChronoUnit.WEEKS.between(d1, d2));

        Function<LocalDate, DayOfWeek> dayOfWeek = LocalDate::getDayOfWeek;

        System.out.println("=== Завдання 1: Робота з датами ===");
        System.out.println("2024 рік високосний? " + isLeapYear.test(2024));
        System.out.println("2023 рік високосний? " + isLeapYear.test(2023));

        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 12, 31);
        System.out.println("Днів між " + date1 + " та " + date2 + ": " + daysBetween.apply(date1, date2));
        System.out.println("Повних неділь (тижнів) між датами: " + fullWeeksBetween.apply(date1, date2));

        LocalDate moonLanding = LocalDate.of(1969, 7, 20);
        System.out.println("20 липня 1969 року - це: " + dayOfWeek.apply(moonLanding));
    }
}