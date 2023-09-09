package com.web.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.bookstore.entity.MyBookCollection;

@Repository
public interface MyBookCollectionRepository extends JpaRepository<MyBookCollection, Integer>{

}
