package com.greatlearning.movie.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.greatlearning.movie.bean.Movies;
import com.greatlearning.movie.factory.MovieFactory;

public class TopRatedMoviesTest {

	@Test
	public void testGetTitle() {
		
		//fail("Not yet implemented");
		Movies movie = MovieFactory.getInstance("Top Rated Movies");
		movie.setTitle("Blade Runner");
		String movieName = movie.getTitle();
		assertEquals("Blade Runner", movieName);
	}

	@Test
	public void testGetImdbRating() {
		//fail("Not yet implemented");
		Movies movie = MovieFactory.getInstance("Top Rated Movies");
		movie.setImdbRating(8.3f);
		float rating = movie.getImdbRating();
		assertTrue(rating==8.3f); 
		
	}

	@Test
	public void testSetImdbRating() {
		//fail("Not yet implemented");
		Movies movie = MovieFactory.getInstance("Top Rated Movies");
		movie.setImdbRating(8.1f);
		
		assertTrue(movie.getImdbRating()==8.1f); 
	}

	@Test
	public void testGetPosterUrl() {
		//fail("Not yet implemented");
		Movies movie = MovieFactory.getInstance("Top Rated Movies");
		String url="https://images-na.ssl-images-amazon.com/images/M/MV5BMjQ1NjM3MTUxNV5BMl5BanBnXkFtZTgwMDc5MTY5OTE@._V1_SY500_CR0,0,323,500_AL_.jpg";
		movie.setPosterUrl(url);
		String getUrl= movie.getPosterUrl();
		assertEquals(url,getUrl);
		
	}

	@Test
	public void testSetPosterUrl() {
		//fail("Not yet implemented");
		Movies movie = MovieFactory.getInstance("Top Rated Movies");
		String url="https://images-na.ssl-images-amazon.com/images/M/MV5BMjQ1NjM3MTUxNV5BMl5BanBnXkFtZTgwMDc5MTY5OTE@._V1_SY500_CR0,0,323,500_AL_.jpg";
		movie.setPosterUrl(url);
		assertEquals(url,movie.getPosterUrl());
	}

}
