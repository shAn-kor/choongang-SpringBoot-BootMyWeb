package com.coding404.myWeb.command;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MemoVO {
    private int mno;
    private String writer;
    private String memo;

    // N : 1 로 조인할 컬럼
    private String name;
    private String pw;
}
