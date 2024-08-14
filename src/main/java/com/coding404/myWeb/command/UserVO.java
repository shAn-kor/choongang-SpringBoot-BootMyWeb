package com.coding404.myWeb.command;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserVO {
    private String id;
    private String pw;
    private String name;

    // 1:N 로 조인할 컬럼
    // N쪽 데이터를 list로 담는다.
    private List<MemoVO> memoList;
}
