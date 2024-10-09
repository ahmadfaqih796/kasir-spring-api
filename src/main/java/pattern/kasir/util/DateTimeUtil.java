package pattern.kasir.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.springframework.stereotype.Component;

@Component
public class DateTimeUtil {

  private static final String DEFAULT_ZONE = "Asia/Jakarta";
  private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

  public static Date getCurrentTime() {
    return new Date();
  }

  public static String format(Date dateTime) {
    if (dateTime == null) {
      return null;
    }
    SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_PATTERN);
    formatter.setTimeZone(TimeZone.getTimeZone(DEFAULT_ZONE));
    return formatter.format(dateTime);
  }

  public static String format(Date dateTime, String pattern) {
    if (dateTime == null) {
      return null;
    }
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    formatter.setTimeZone(TimeZone.getTimeZone(DEFAULT_ZONE));
    return formatter.format(dateTime);
  }
  // public static void main(String[] args) {
  //   Date now = getCurrentTime();
  //   String formatted = format(now, "yyyy-MM-dd HH:mm:ss");
  //   System.out.println("Current time in Asia/Jakarta: " + formatted);
  // }
}
