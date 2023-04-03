package com.xfactor.openlibrary.controllers;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.domain.Book;

import com.xfactor.openlibrary.Repositries.BookRepository;

@RestController
@RequestMapping("book")

public class BookController {
    private BookRepository bookRepository;
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //ArrayList<Book> lBooks = new ArrayList<>();
    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) {
        if (book.getId() == null) {
            Book book2 = bookRepository.save(book);
            return book2;
        }
        return null;

    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book) {
        if (book.getId() != null) {
            Book book2 = bookRepository.save(book);
            return book2;
        }
        return null;

    }

    @GetMapping("/getALl")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    
    @GetMapping("findById/{id}")
    public Book findById(@PathVariable Long id) {
        Optional<Book> optionalOfBook = bookRepository.findById(id);
        if (optionalOfBook.isPresent()) {
            return optionalOfBook.get();
        }
        return null;
    }

    @GetMapping("/findTotal")
    public Long findTotal(){
        return bookRepository.count();
    }
    
    @DeleteMapping("deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        bookRepository.deleteById(id);
    }

    @GetMapping("findByIsbn/{isbn}")
    public List<Book> findByisbn(@PathVariable String isbn) {
        List<Book> books = bookRepository.findByIsbn(isbn);
        return books;
    } 

    @GetMapping("findByNameAndIsbn/{title}/{isbn}")
    public List<Book> findByTitleAndIsbn(@PathVariable String title, @PathVariable String isbn){
        List<Book> books = bookRepository.findByTitleAndIsbn(title,isbn);
        return books;
    }
    @GetMapping("findByTitle/{title}")
    public List<Book> findByTitle(@PathVariable String title) {
        List<Book> books = bookRepository.findByTitle(title);
        return books;
    } 
    @GetMapping("findByAuthor/{author}")
    public List<Book> findByAuthor(@PathVariable String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        return books;
    }
    @GetMapping("findByPublicationDate/{publicationDate}")
    public List<Book> findByPublicationDate(@PathVariable String publicationDate) {
        List<Book> books = bookRepository.findByPublicationDate(publicationDate);
        return books;
    } 
    @GetMapping("findByPublisher/{publisher}")
    public List<Book> findByPublisher(@PathVariable String publisher) {
        List<Book> books = bookRepository.findByPublisher(publisher);
        return books;
    } 
    @GetMapping("findByCopies/{copies}")
    public List<Book> findByCopies(@PathVariable String copies) {
        List<Book> books = bookRepository.findByCopies(copies);
        return books;
    }
    @GetMapping("findByCategory/{category}")
    public List<Book> findByCategory(@PathVariable String category) {
        List<Book> books = bookRepository.findByCategory(category);
        return books;
    }
    @GetMapping("findByGenre/{genre}")
    public List<Book> findByGenre(@PathVariable String genre) {
        List<Book> books = bookRepository.findByGenre(genre);
        return books;
    }
    @GetMapping("findBySubgenre/{subgenre}")
    public List<Book> findBySubgenre(@PathVariable String subgenre) {
        List<Book> books = bookRepository.findBySubgenre(subgenre);
        return books;
    }
}
