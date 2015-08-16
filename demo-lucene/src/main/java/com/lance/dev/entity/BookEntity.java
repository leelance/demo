package com.lance.dev.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by lance
 *
 * @since 2015-08-16 21:50
 */
@Entity
@Table(name = "t_book")
public class BookEntity extends BaseEntity{
    private String bookName;
    private String author;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
