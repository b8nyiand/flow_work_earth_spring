package hu.flowacademy.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Page {

    @Id
    @GeneratedValue
    private Long id;

    private Integer pageNumber;

    @ManyToOne
    @JoinColumn(name="book_id", nullable = false)
    @JsonIgnore
    private Book book;

    public Page() {

    }

    public Page(Integer pageNumber, Book book) {
        this.pageNumber = pageNumber;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
