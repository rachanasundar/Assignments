package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.CompositeKeys;
import com.bean.Likedbooks;



@Repository
public interface UserLikedBooksDao extends JpaRepository<Likedbooks, CompositeKeys> {

	@Query("select u from Likedbooks u where u.keys.emailId=:email")
	public List<Likedbooks> getLikedBook(@Param("email") String email);
}
