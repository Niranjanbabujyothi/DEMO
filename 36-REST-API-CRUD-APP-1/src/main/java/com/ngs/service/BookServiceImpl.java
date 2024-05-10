package com.ngs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ngs.entity.BookEntity;
import com.ngs.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	private BookRepository bookrepo;

	public BookServiceImpl(BookRepository bookrepo) {
		this.bookrepo = bookrepo;
	}

	@Override
	public String upsetBook(BookEntity bookEntity) {
		Integer book_Id2 = bookEntity.getBook_Id();
		BookEntity book_Id = bookrepo.save(bookEntity);
		if (book_Id2 == null) {
			return "Record Inserted";
		} else {
			return "Record Updated";
		}

	}

	@Override
	public List<BookEntity> getAllBookEntities() {
		return bookrepo.findAll();
	}

	@Override
	public String deleteBook(Integer book_Id) {
		bookrepo.deleteById(book_Id);
		return "Book Deleted";	
	}

	@Override
	public BookEntity getRecord(Integer book_Id) {
		Optional<BookEntity> byId = bookrepo.findById(book_Id);
		if(byId.isPresent()) {
			BookEntity bookEntity = byId.get();
		return bookEntity;
		}else {
			return null;
		}
	} 

}
