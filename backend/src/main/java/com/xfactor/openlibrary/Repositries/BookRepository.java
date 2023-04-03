package com.xfactor.openlibrary.Repositries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Book;
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByIsbn(String isbn);

    List<Book> findByTitleAndIsbn(String title, String isbn);

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByPublicationDate(String publicationDate);

    List<Book> findByPublisher(String publisher);

    List<Book> findByCopies(String copies);

    List<Book> findByCategory(String category);

    List<Book> findByGenre(String genre);

    List<Book> findBySubgenre(String subgenre);

}
