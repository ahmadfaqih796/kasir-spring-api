package pattern.kasir.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
// @PropertySource("classpath:other.properties")
public class OtherConfig {

  private static String flagLogging;

  public static String getFlagLogging() {
    return flagLogging;
  }

  @Value("${flag.logging}")
  private void setFlagLogging(String flagLogging) {
    OtherConfig.flagLogging = flagLogging;
  }
}
