package com.example.spring_hateoas_test.api.book;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookRestController {
    private final BookService bookService;
    @GetMapping
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }
    @GetMapping("/byAuthor")
    public Page<Book> getBookByAuthor(@RequestParam String authorName,
                                      @RequestParam int page,
                                      @RequestParam int limit){
        Pageable pageable = PageRequest.of(page,limit);
        return bookService.getBookByAuthor(authorName,pageable);
    }
    @GetMapping("/atId/{authorId}")
    public List<Book> getBookByAuthorId(@PathVariable Integer authorId){
        return bookService.getBookByAuthorId(authorId);
    }
    @GetMapping("/byTitle")
    public List<Book> getBookByTitle(@RequestParam String title,
                                     @SortDefault(sort = "title",direction = Sort.Direction.ASC)
                                     Sort sort){
        return bookService.getBookByTitle(title,sort);
    }
}
