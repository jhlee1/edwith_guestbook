package lee.joohan.guestbook.dao;

import lee.joohan.guestbook.config.ApplicationConfig;
import lee.joohan.guestbook.dto.Guestbook;
import lee.joohan.guestbook.dto.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class GuestbookDaoTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestbookDao guestbookDao = applicationContext.getBean(GuestbookDao.class);
        Guestbook guestbook = new Guestbook();

        guestbook.setName("Joohan");
        guestbook.setContent("Hello");
        guestbook.setRegdate(new Date());

        Long id = guestbookDao.insert(guestbook);
        System.out.println(id);

        LogDao logDao = applicationContext.getBean(LogDao.class);
        Log log = new Log();

        log.setIp("127.0.0.1");
        log.setMethod("insert");
        log.setRegdate(new Date());
        logDao.insert(log);
    }
}
