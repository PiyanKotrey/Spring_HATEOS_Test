package com.example.spring_hateoas_test.api.author;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authors")
public class AuthorRestController {
    private final AuthorService authorService;
    @GetMapping
    public List<Author> getAllAuthor(){
        return authorService.getAllAuthor();
    }
}
