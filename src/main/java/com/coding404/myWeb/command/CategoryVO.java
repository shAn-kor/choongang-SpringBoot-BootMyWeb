package com.coding404.myWeb.command;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CategoryVO {
    private int category_id;
    private String group_id;
    private int category_lv;
    private String category_nm;
    private int category_detail_lv;
    private String category_detail_nm;
    private int category_parent_lv;
    private String category_detail_parent_lv;
}
