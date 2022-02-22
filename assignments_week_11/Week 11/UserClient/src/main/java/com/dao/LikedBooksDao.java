package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bean.CompositeKey;
import com.bean.LikedBooks;

public interface LikedBooksDao extends JpaRepository<LikedBooks, CompositeKey>  {

	@Query("select books from LikedBooks books where books.key.emailId=:email")
	public List<LikedBooks> getLikedBooks(@Param("email") String email);

}
