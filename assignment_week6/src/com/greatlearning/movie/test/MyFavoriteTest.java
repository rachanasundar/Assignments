package com.greatlearning.movie.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.greatlearning.movie.bean.Movies;
import com.greatlearning.movie.factory.MovieFactory;

public class MyFavoriteTest {

	@Test
	public void testGetId() {
		//fail("Not yet implemented");
		Movies movie = MovieFactory.getInstance("My Favorite");
		movie.setId(4001);
		int getId = movie.getId();
		assertEquals(4001,getId);
	}

	@Test
	public void testGetTitle() {
		//fail("Not yet implemented");
		Movies movie = MovieFactory.getInstance("My Favorite");
		movie.setTitle("Nawals hemlighet");
		String movieName=movie.getTitle();
		assertTrue(movieName.equals("Nawals hemlighet"));
	}

	@Test
	public void testGetYear() {
		//fail("Not yet implemented");
		Movies movie = MovieFactory.getInstance("My Favorite");
		movie.setYear(2016);
		int year = movie.getYear();
		assertTrue(year==2016);
	}

	
	@Test
	public void testSetReleaseDate() {
		//fail("Not yet implemented");
		Movies movie = MovieFactory.getInstance("My Favorite");
		movie.setReleaseDate("2011-08-12");
		assertEquals("2011-08-12", movie.getReleaseDate());
	}

	@Test
	public void testSetImdbRating() {
		//fail("Not yet implemented");
		Movies movie = MovieFactory.getInstance("My Favorite");
		movie.setImdbRating(8.5f);
		assertTrue(movie.getImdbRating()==8.5f);
	}

}
