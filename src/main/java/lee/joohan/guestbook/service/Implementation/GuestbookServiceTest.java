package lee.joohan.guestbook.service.Implementation;

import lee.joohan.guestbook.config.ApplicationConfig;
import lee.joohan.guestbook.dto.Guestbook;
import lee.joohan.guestbook.service.GuestbookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class GuestbookServiceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestbookService guestbookService = applicationContext.getBean(GuestbookService.class);

        Guestbook guestbook = new Guestbook();

        guestbook.setName("John Doe");
        guestbook.setContent("Hello world!");
        guestbook.setRegdate(new Date());
        Guestbook result = guestbookService.addGuestbook(guestbook, "127.0.0.0");

        System.out.println("result: " + result);
    }
}
