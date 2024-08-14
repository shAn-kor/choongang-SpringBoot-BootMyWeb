package com.coding404.myWeb;

import com.coding404.myWeb.command.MemoVO;
import com.coding404.myWeb.command.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//CREATE TABLE EX_MEMO(
//        MNO INT PRIMARY KEY AUTO_INCREMENT,
//        WRITER VARCHAR(50) NOT NULL,
//MEMO VARCHAR(200) NOT NULL
//);
//insert into EX_MEMO(writer, memo) values('aaa', 'aaa');
//insert into EX_MEMO(writer, memo) values('aaa', 'bbb');
//
//CREATE TABLE EX_USERS(
//        ID VARCHAR(50) PRIMARY KEY,
//PW VARCHAR(50) NOT NULL,
//NAME VARCHAR(50)
//);
//insert into EX_USERS(ID, pw, name) values('aaa', '1234', '홍길동');
@Mapper
public interface TestMapper {
    // EX_MEMO : N
    // EX_USER : 1

    // N:1 조인
    List<MemoVO> joinOne();
    UserVO joinN();
}
