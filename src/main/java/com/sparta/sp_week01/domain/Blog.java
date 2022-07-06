package com.sparta.sp_week01.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Blog extends Timestamped{

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id; //아이디

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title; //제목

    @Column(nullable = false)
    private String name; //작성자

    @Column(nullable = false)
    private String password; //비밀번호

    @Column(nullable = false)
    private String comment; //내용

    public Blog(BlogRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.comment = requestDto.getComment();
    }

    public Blog (String title, String name, String password, String comment) {
        this.title = title;
        this.name = name;
        this.password = password;
        this.comment = comment;
    }

    public void update(BlogRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.comment = requestDto.getComment();
    }
}