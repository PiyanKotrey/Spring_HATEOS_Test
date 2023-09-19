package com.example.spring_hateoas_test.api.book;

import com.example.spring_hateoas_test.api.author.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService{
    private final BookRepository bookRepository;
    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> getBookByAuthor(String authorName, Pageable pageable) {
        return bookRepository.findByAuthorName(authorName,pageable);
    }

    @Override
    public List<Book> getBookByAuthorId(Integer authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    @Override
    public List<Book> getBookByTitle(String title, Sort sort) {
        return bookRepository.findByTitle(title,sort);
    }

}
