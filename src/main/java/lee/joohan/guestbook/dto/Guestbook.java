package lee.joohan.guestbook.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Guestbook {
    private Long id;
    private String name;
    private String content;
    private Date regdate;
}
