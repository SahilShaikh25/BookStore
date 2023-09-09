package com.web.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	@Query(value = "SELECT * FROM book WHERE name LIKE %:k%", nativeQuery = true)
	public List<Book> findByName(@Param("k") String key);
}


















































