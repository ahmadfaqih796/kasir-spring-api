package pattern.kasir.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

  @Bean
  public Cloudinary cloudinary() {
    return new Cloudinary(
      ObjectUtils.asMap(
        "cloud_name",
        CloudinaryConfig.getCloudName(),
        "api_key",
        CloudinaryConfig.getApiKey(),
        "api_secret",
        CloudinaryConfig.getApiSecret()
      )
    );
  }
}
