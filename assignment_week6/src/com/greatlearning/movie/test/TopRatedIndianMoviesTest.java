package com.greatlearning.movie.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.greatlearning.movie.bean.Movies;
import com.greatlearning.movie.factory.MovieFactory;

public class TopRatedIndianMoviesTest {

	@Test
	public void testSetYear() {
		//fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Top Rated Indian Movies");
		movie.setYear(2016);
		assertEquals(2016,movie.getYear());
	}

	@Test
	public void testGetReleaseDate() {
		//fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Top Rated Indian Movies");
		movie.setReleaseDate("2007-02-09");
		String date= movie.getReleaseDate();
		assertEquals("2007-02-09",date);
		
	}

	@Test
	public void testSetReleaseDate() {
		//fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Top Rated Indian Movies");
			movie.setReleaseDate("1987-07-31");
			assertEquals("1987-07-31",movie.getReleaseDate());
	}

	@Test
	public void testGetActors() {
//		fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Top Rated Indian Movies");
		String[] actorsNames= { "Kamal Haasan","Saranya Ponvannan","Delhi Ganesh"};
		movie.setActors(actorsNames);
		String[] getActorsNames= movie.getActors();
		assertArrayEquals(actorsNames, getActorsNames);
	}

	@Test
	public void testSetActors() {
		//fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Top Rated Indian Movies");
		String[] actorsNames= { "Kay Kay Menon","Pavan Malhotra","Aditya Srivastava"};
		movie.setActors(actorsNames);
		assertArrayEquals(actorsNames, movie.getActors());
	}

}
