package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bean.CompositeKey;
import com.bean.ReadLaterBooks;

public interface ReadLaterBooksDao extends JpaRepository<ReadLaterBooks, CompositeKey>{

	@Query("select books from ReadLaterBooks books where books.key.emailId=:email")
	public List<ReadLaterBooks> getReadLaterBooks(@Param("email") String email);
}
