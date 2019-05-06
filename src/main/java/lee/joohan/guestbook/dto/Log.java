package lee.joohan.guestbook.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Log {
    private Long id;
    private String ip;
    private String method;
    private Date regdate;
}
