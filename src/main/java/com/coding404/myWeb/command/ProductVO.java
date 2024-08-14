package com.coding404.myWeb.command;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
//@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ProductVO {
    private Integer prodId;
    private LocalDateTime prodRegDate;
    private String prodEndDate;
    private String prodCategory;
    private String prodWriter;
    private String prodName;
    private String prodPrice;
    private String prodCount;
    private String prodDiscount;
    private String prodPurchaseYn;
    private String prodContent;
    private String prodComment;
    private String categoryKey;
    private String categoryNav;
}
