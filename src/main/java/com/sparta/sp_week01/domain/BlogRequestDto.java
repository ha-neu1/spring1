package com.sparta.sp_week01.domain;

import lombok.Getter;
import lombok.Setter;

//@Data @getter,@setter 대신 쓸 수 있음
@Setter
@Getter
public class BlogRequestDto {
    private String title;
    private String name;
    private String password;
    private String comment;
}
