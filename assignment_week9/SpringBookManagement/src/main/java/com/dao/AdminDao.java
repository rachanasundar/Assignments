package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.AdminLogIn;

@Repository
public interface AdminDao extends JpaRepository<AdminLogIn, String> {

}
