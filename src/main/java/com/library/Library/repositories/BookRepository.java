package com.library.Library.repositories;

import com.library.Library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("SELECT l FROM  Book l WHERE l.publisher.publisherId= :publisherId")
    List<Book> getBookByPublisher(@Param("publisherId") Long publisherId);
}
