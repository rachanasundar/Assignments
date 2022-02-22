package com.greatlearning.movie.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.greatlearning.movie.bean.Movies;
import com.greatlearning.movie.factory.MovieFactory;

public class MovieFactoryTest {

	@Test
	public void testGetInstance() {
		//fail("Not yet implemented");
		
		Movies fromFactory = MovieFactory.getInstance("Top Rated Movies");
		assertNotNull(fromFactory);
		
		
	}

}
