package com.greatlearning.movie.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.greatlearning.movie.bean.Movies;
import com.greatlearning.movie.factory.MovieFactory;
import com.greatlearning.movie.resourse.MoviesDao;

public class MoviesDaoTest {

	@Test
	public void testSelectMoviesComingSoon() {
		//fail("Not yet implemented");
		
		MoviesDao mov= MoviesDao.getInstance();
		List<Movies> movieList= new ArrayList<Movies>();
		Movies movie = MovieFactory.getInstance("Movies Coming Soon");
		movie.setId(1002);
		movie.setTitle("The Lodgers");
		movie.setYear(2017);
		movie.setImdbRating(5.8f);
		movieList.add(movie);
		List<Movies> movieListSelected= new ArrayList<Movies>();
		movieListSelected.addAll(mov.selectMoviesComingSoon(1001));
		assertEquals(movieList,movieListSelected );
	}

	@Test
	public void testSelectMovieInTheaters() {
		//fail("Not yet implemented");
		MoviesDao mov= MoviesDao.getInstance();
		List<Movies> movieList= new ArrayList<Movies>();
		Movies movie = MovieFactory.getInstance("Movies In Theaters");
		movie.setId(2001);
		movie.setTitle("Black Panther");
		movie.setYear(2018);
		movie.setImdbRating(7.0f);
		movieList.add(movie);
		List<Movies> movieListSelected= new ArrayList<Movies>();
		movieListSelected.addAll(mov.selectMovieInTheaters(2001));
		assertEquals(movieList,movieListSelected);

	}

@Test
	public void testSelectTopRatedMovies() {
	//	fail("Not yet implemented");
		MoviesDao mov= MoviesDao.getInstance();
		List<Movies> movieList= new ArrayList<Movies>();
		Movies movie = MovieFactory.getInstance("Top Rated Movies");
		movie.setId(4001);
		movie.setTitle("Hacksaw Ridge");
		movie.setYear(2016);
		movie.setImdbRating(8.3f);
		movieList.add(movie);
		List<Movies> movieListSelected= new ArrayList<Movies>();
		movieListSelected.addAll(mov.selectTopRatedMovies(4001));
		assertEquals(movieList,movieListSelected);
	}

	@Test
	public void testSelectTopRatedIndianMovies() {
	//	fail("Not yet implemented");
		MoviesDao mov= MoviesDao.getInstance();
		List<Movies> movieList= new ArrayList<Movies>();
		Movies movie = MovieFactory.getInstance("Top Rated Indian Movies");
		movie.setId(3004);
		movie.setTitle("Black Friday");
		movie.setYear(2004);
		movie.setImdbRating(8.6f);
		movieList.add(movie);
		List<Movies> movieListSelected= new ArrayList<Movies>();
		movieListSelected.addAll(mov.selectTopRatedIndianMovies(3004));
		assertEquals(movieList,movieListSelected);
	}

	@Test
	public void testGetInstance() {
	MoviesDao mov= MoviesDao.getInstance();
	assertNotNull(mov);
		
	}


}
