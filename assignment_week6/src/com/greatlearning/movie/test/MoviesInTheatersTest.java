package com.greatlearning.movie.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.greatlearning.movie.bean.Movies;
import com.greatlearning.movie.factory.MovieFactory;

public class MoviesInTheatersTest {

	@Test
	public void testSetYear() {
		//fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Movies In Theaters");
		movie.setYear(2017);
		assertEquals(2017,movie.getYear());
	}

@Test
	public void testGetGenres() {
		//fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Movies In Theaters");
		String[] genre = {"Action","Crime","Drama"};
		movie.setGenres(genre);
		String[] getGenre=movie.getGenres();
		assertArrayEquals(genre, getGenre);
		
		
	}

@Test
	public void testSetGenres() {
		//fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Movies In Theaters");
		String[] genre = {"Action","Crime","Drama"};
		movie.setGenres(genre);
		assertArrayEquals(genre,movie.getGenres());
	}

	@Test
	public void testGetDuration() {
		//fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Movies In Theaters");
		movie.setDuration("PT139M");
		String duration = movie.getDuration();
		assertEquals("PT139M",duration);
		
	}

	@Test
	public void testSetDuration() {
		//fail("Not yet implemented");
		Movies movie= MovieFactory.getInstance("Movies In Theaters");
		
		movie.setDuration("PT139M");
		assertEquals("PT139M",movie.getDuration());
	}

}
