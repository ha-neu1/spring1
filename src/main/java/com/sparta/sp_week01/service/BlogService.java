package com.sparta.sp_week01.service;

import com.sparta.sp_week01.domain.Blog;
import com.sparta.sp_week01.domain.BlogRepository;
import com.sparta.sp_week01.domain.BlogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class BlogService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final BlogRepository blogRepository;


    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, BlogRequestDto requestDto) {
        Blog blog1 = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        if (!blog1.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("일치하지 않습니다.");
        }
        blog1.update(requestDto);
        return blog1.getId();
    }
}
