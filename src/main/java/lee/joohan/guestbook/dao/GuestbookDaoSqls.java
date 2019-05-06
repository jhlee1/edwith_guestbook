package lee.joohan.guestbook.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class GuestbookDaoSqls {
    public static final String SELECT_PAGING = "SELECT id, name, content, regdate FROM guestbook ORDER BY id DESC limit :start, :limit";
    public static final String DELETE_BY_ID = "DELETE FROM guestbook WHERE id = :id";
    public static final String SELECT_COUNT = "SELECT count(*) FROM guestbook";
}
