package com.example.spring_hateoas_test.api.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();
    Page<Book> getBookByAuthor(String authorName, Pageable pageable);
    List<Book> getBookByAuthorId(Integer authorId);
    List<Book> getBookByTitle(String title, Sort sort);
}
