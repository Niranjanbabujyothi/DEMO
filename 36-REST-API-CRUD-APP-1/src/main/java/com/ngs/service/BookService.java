package com.ngs.service;

import java.util.List;

import com.ngs.entity.BookEntity;

public interface BookService {
   public String upsetBook(BookEntity bookEntity);
   public  List<BookEntity> getAllBookEntities();
   public String deleteBook(Integer book_Id);
   public BookEntity getRecord(Integer book_NamInteger);
}
