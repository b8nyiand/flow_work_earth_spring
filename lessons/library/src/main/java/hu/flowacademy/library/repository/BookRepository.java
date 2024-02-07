package hu.flowacademy.library.repository;

import hu.flowacademy.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository  extends JpaRepository<Book, Long> {

    @Query(nativeQuery = true, value = "select * from book where title = ?1")
    public List<Book> findTitle(String title);

}
