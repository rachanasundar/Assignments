package com.greatlearning.movie.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DatabaseResourceTest.class, MovieFactoryTest.class, MoviesComingSoonTest.class, MoviesDaoTest.class,
		MoviesInTheatersTest.class, MyFavoriteTest.class, TopRatedIndianMoviesTest.class, TopRatedMoviesTest.class })
public class AllTests {

}
