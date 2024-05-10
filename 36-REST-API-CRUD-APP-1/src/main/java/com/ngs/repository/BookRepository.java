package com.ngs.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngs.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Serializable> {

}
