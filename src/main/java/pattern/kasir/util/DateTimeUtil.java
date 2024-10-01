package pattern.kasir.util;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class DateTimeUtil {

  private static final ZoneId DEFAULT_ZONE = ZoneId.of("Asia/Jakarta");

  public static OffsetDateTime getCurrentTime() {
    return OffsetDateTime.now(DEFAULT_ZONE);
  }

  public static OffsetDateTime convertZone(OffsetDateTime dateTime) {
    return dateTime.atZoneSameInstant(DEFAULT_ZONE).toOffsetDateTime();
  }

  public static String format(OffsetDateTime dateTime, String pattern) {
    return dateTime.format(DateTimeFormatter.ofPattern(pattern));
  }
}
