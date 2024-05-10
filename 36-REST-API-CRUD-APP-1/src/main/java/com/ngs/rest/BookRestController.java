package com.ngs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ngs.entity.BookEntity;
import com.ngs.service.BookService;



@RestController
public class BookRestController {

	@Autowired
	private BookService bookservice;

	@PostMapping("/book")
	public ResponseEntity<String> upsetBook(@RequestBody BookEntity bookEntity) {
		String msg = bookservice.upsetBook(bookEntity);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/book")
	public ResponseEntity<List<BookEntity>> getAllBooks() {
		List<BookEntity> allBookEntities = bookservice.getAllBookEntities();
		return new ResponseEntity<>(allBookEntities, HttpStatus.OK);
	}

	@PutMapping("/book")
	public ResponseEntity<String> updateBook(@RequestBody BookEntity bookentity) {
		String upsetBook = bookservice.upsetBook(bookentity);
		return new ResponseEntity<>(upsetBook, HttpStatus.OK);
	}

	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId) {
	    String deleteBook = bookservice.deleteBook(bookId);
	    return new ResponseEntity<String>(deleteBook, HttpStatus.OK);
	    //http://localhost:9093/book/here Book Id
	}
	@GetMapping("/book2")
	public ResponseEntity<BookEntity> getBook(@RequestParam("bookId") Integer bookId){
		BookEntity record = bookservice.getRecord(bookId);
		return new ResponseEntity<BookEntity>(record,HttpStatus.OK);
	}

}
