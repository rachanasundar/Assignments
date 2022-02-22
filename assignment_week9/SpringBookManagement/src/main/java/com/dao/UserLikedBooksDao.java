package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.CompositeKeys;
import com.bean.UserLikedBooks;


@Repository
public interface UserLikedBooksDao extends JpaRepository<UserLikedBooks, CompositeKeys> {

	@Query("select bookName from UserLikedBooks u where u.keys.emailId=:email")
	public List<String> getLikedBook(@Param("email") String email);
}
