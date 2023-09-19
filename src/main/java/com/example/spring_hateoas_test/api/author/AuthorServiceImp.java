package com.example.spring_hateoas_test.api.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImp implements AuthorService{
    private final AuthorRepository authorRepository;
    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }
}
