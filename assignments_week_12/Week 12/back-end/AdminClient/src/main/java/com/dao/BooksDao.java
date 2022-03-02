package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.Books;

public interface BooksDao extends JpaRepository<Books, Integer>{

}
