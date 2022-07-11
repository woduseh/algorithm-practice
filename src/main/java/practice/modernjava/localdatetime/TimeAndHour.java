package practice.modernjava.localdatetime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TimeAndHour {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter zonedFormatter = DateTimeFormatter.ofPattern("VV E yyyy-MM-dd HH:mm:ss");
        System.out.println(now);

        LocalDateTime time = zonedDateTime.toLocalDateTime();

        ZonedDateTime zonedTime = now.atZone(ZoneId.of("Europe/Paris"));

        System.out.println(zonedDateTime.format(zonedFormatter));

        LocalDateTime before = now.minus(1, ChronoUnit.HOURS);
        System.out.println(before);

        LocalDateTime after = now.plus(1, ChronoUnit.HOURS)
                .plus(1, ChronoUnit.MINUTES)
                .plus(1, ChronoUnit.SECONDS);

        System.out.println(after);

        LocalDateTime nextNextTuesday = now.with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
                .with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println(
                nextNextTuesday.format(formatter));

        System.out.println(
                now.with(new NextWorkingDay()).with(new NextWorkingDay()).format(formatter));
    }
}
