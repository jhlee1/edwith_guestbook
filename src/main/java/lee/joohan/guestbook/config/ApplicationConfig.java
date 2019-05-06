package lee.joohan.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"lee.joohan.guestbook.dao", "lee.joohan.guestbook.service"})
@Import({DBConfig.class})
public class ApplicationConfig {
}
