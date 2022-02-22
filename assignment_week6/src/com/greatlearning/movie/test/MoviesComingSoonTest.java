package com.greatlearning.movie.test;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;


import org.junit.Test;

import com.greatlearning.movie.bean.Movies;
import com.greatlearning.movie.factory.MovieFactory;

public class MoviesComingSoonTest {

	
	@Test
	public void testGetId() {
		//fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Movies Coming Soon");
		movie.setId(1001);
		int id = movie.getId();
		assertEquals(1001,id);
		
	}

	@Test
	public void testSetId() {
		//fail("Not yet implemented");
		
		Movies movie= MovieFactory.getInstance("Movies Coming Soon");
		movie.setId(1002);
		assertTrue( movie.getId()==1002);
	}

	@Test
	public void testGetTitle() {
		//fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Movies Coming Soon");
		movie.setTitle("Game Night");
		String title = movie.getTitle();
		assertEquals("Game Night",title);
		
	}

	@Test
	public void testSetTitle() {
		//fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Movies Coming Soon");
		movie.setTitle("Game Night");
		assertEquals( "Game Night",movie.getTitle());
	}

	@Test
	public void testGetYear() {
		//fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Movies Coming Soon");
		movie.setYear(2018);
		int year = movie.getYear();
		assertEquals(2018,year);
		
		
	}

}
