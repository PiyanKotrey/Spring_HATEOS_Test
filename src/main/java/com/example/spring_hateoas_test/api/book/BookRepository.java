package com.example.spring_hateoas_test.api.book;

import com.example.spring_hateoas_test.api.author.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Page<Book> findByAuthorName(String authorName, Pageable pageable);
    List<Book> findByAuthorId(Integer authorId);
    List<Book> findByTitle(String title, Sort sort);
}
