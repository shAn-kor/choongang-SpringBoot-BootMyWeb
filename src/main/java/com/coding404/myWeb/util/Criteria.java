package com.coding404.myWeb.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Criteria {
    // 화면에 전달할 값들을 가지고 다니는 클래스
    private int pageNum;
    private int amount; // 조회하는 데이터 개수

    public Criteria() {
        this.pageNum = 1;
        this.amount = 10;
    }

    // offset - limit 함수에 앞에 전달될 값
    public int getPageStart() {
        return (pageNum - 1) * amount;
    }
}
