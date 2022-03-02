package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.CompositeKeys;
import com.bean.Likedbooks;
import com.bean.Readlater;



@Repository
public interface ReadLaterDao extends JpaRepository<Readlater, CompositeKeys> {

	@Query("select u from Readlater u where u.keys.emailId=:email")
	public List<Readlater> getLikedBook(@Param("email") String email);
}
