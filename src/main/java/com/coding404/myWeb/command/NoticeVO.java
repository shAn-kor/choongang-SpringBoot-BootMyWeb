package com.coding404.myWeb.command;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NoticeVO {
    private Integer noticeId;
    private LocalDateTime noticeRegDate;
    private Character noticeDisplayYn;
    private String noticeWriterId;
    private String noticeWriterNick;
    private String prodName;
    private String noticeTitle;
    private String noticeContent;
}
