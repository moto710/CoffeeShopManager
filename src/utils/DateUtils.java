package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final String PATTERN_FORMAT_DATE = "dd-MM-yyy HH:mm:ss";
    static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy HH:mm:ss");

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN_FORMAT_DATE);

    public static String formatDateToString(Date date) {
        return dateFormat.format(date);
    }

    public static Date parseStringToDate(String date) {
        try {
            return new SimpleDateFormat(PATTERN_FORMAT_DATE).parse(date);
        } catch (ParseException p) {
            throw new RuntimeException(p);
        }
    }
}
