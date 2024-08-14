package com.coding404.myWeb.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter

public class PageVO {
    // 화면에 그려질 pageNation을 계산하는 클래스
    private int start; // 시작페이지 번호
    private int end; // 마지막페이지 번호
    private boolean prev; // 이전 버튼 활성 여부
    private boolean next; // 다음 버튼 활성 여부

    private int page; // 현재 조회 페이지 번호
    private int amount; // 현재 조회하는 데이터 개수

    private int total; // 전체 게시글 수
    private int realEnd; // 맨 마지막 페이지 도달 시 재 계산 들어가는 실제 끝번호
    private List<Integer> pageList; // 타임리프는 향상된 for 문 밖에 없기 때문에 리스트 만든다.

    private Criteria cri;

    private int pageSize = 5; // 페이지네이션 크기

    // 생성자 - 생성 시 criteria객체, 전체게시글 수 받는다.
    public PageVO(Criteria cri, int total) {
        this.cri = cri;
        this.total = total;
        this.page = cri.getPage();
        this.amount = cri.getAmount();

        // 끝페이지 번호 계산 (페이지 네이션에서 끝 번호)
        this.end = (int)(Math.ceil(this.page / (double)this.pageSize)) * this.pageSize;

        // 시작페이지 = 끝번호 - 페이지네이션 개수 + 1
        this.start = end - this.pageSize + 1;

        // 전체끝페이지 = 올림 (총 페이지 / 한 페이지 당 행 개수 )
        this.realEnd = (int) (Math.ceil(total / (double) this.amount));

        // end 재계산
        // 112개 게시물 -> 1~10 페이지 번호 볼때는 end = 10, realEnd = 12
        if (this.end > this.realEnd) {
            this.end = this.realEnd;
        }

        this.prev = this.page > 1;
        this.next = this.end < this.realEnd;
        this.pageList = IntStream.rangeClosed(this.start, this.end).boxed().collect(Collectors.toList());
    }
}
