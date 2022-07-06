package com.sparta.sp_week01.controller;

import com.sparta.sp_week01.domain.Blog;
import com.sparta.sp_week01.domain.BlogRepository;
import com.sparta.sp_week01.domain.BlogRequestDto;
import com.sparta.sp_week01.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BlogController {
    private final BlogRepository blogRepository;
    private final BlogService blogService;

    //게시글 작성
    @PostMapping("/api/blogs")
    public Blog createCourse(@RequestBody BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);
    }

    //게시글 조회
    @GetMapping("/api/blogs")
    public List<Blog> getBlogs() {
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }

    //개별 게시글 조회
    @GetMapping("/api/blogs/{id}")
    public Optional<Blog> findById(@PathVariable Long id) {
        return blogRepository.findById(id);
    }

    //게시글 수정
    @PutMapping("/api/blogs/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        return blogService.update(id, requestDto);
    }

    //게시글 삭제
    @DeleteMapping("api/blogs/{id}")
    public Long deleteBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        if (!blog.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("일치하지 않습니다.");
        }
        blogRepository.deleteById(id);
        return id;
    }
}