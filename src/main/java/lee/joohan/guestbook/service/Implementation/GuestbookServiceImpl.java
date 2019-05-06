package lee.joohan.guestbook.service.Implementation;

import lee.joohan.guestbook.dao.GuestbookDao;
import lee.joohan.guestbook.dao.LogDao;
import lee.joohan.guestbook.dto.Guestbook;
import lee.joohan.guestbook.dto.Log;
import lee.joohan.guestbook.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class GuestbookServiceImpl implements GuestbookService {
    @Autowired
    GuestbookDao guestbookDao;

    @Autowired
    LogDao logDao;

    @Override
    @Transactional //Readonly 설정됨
    public List<Guestbook> getGuestbooks(Integer start) {
        List<Guestbook> guestbooks = guestbookDao.selectAll(start, LIMIT);

        return guestbooks;
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteGuestbook(Long id, String ip) {
        int deleteCount = guestbookDao.deleteById(id);
        Log log = new Log();

        log.setIp(ip);
        log.setMethod("delete");
        log.setRegdate(new Date());
        logDao.insert(log);

        return deleteCount;
    }

    @Override
    @Transactional(readOnly = false)
    public Guestbook addGuestbook(Guestbook guestbook, String ip) {
        guestbook.setRegdate(new Date());
        Long id = guestbookDao.insert(guestbook);
        guestbook.setId(id);

        Log log = new Log();
        log.setIp(ip);
        log.setMethod("insert");
        log.setRegdate(new Date());
        logDao.insert(log);


        return guestbook;
    }

    @Override
    @Transactional
    public int getCount() {
        return guestbookDao.selectCount();
    }
}
