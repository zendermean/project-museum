package services;

import java.sql.Timestamp;

public class TimeService {
    public static Timestamp convert(String time) {
        time += ":00";
        time = time.replace("T", " ");
        return Timestamp.valueOf(time);
    }

    public static boolean isCorrect(Timestamp from, Timestamp to) {
        return from.before(to);
    }
}
