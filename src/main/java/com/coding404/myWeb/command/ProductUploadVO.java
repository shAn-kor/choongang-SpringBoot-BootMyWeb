package com.coding404.myWeb.command;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductUploadVO {
    private int uploadNo;
    private String filename;
    private String filepath;
    private String uuid;
    private LocalDateTime regdate;
    private int prodId;
    private String prodWriter;
}
