package com.greatlearning.movie.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.greatlearning.movie.resourse.DatabaseResource;

public class DatabaseResourceTest {

	@Test
	public void testGetDbConnection() {
	//fail("Not yet implemented");
		Connection con = DatabaseResource.getDbConnection();
		assertNotNull(con);
		
	}

	@Test
	public void testGetInstance() {
		//fail("Not yet implemented");
		DatabaseResource db = DatabaseResource.getInstance();
		assertNotNull(db);
	}

}
