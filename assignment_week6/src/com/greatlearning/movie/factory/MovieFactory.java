package com.greatlearning.movie.factory;

import com.greatlearning.movie.bean.*;

//Factory design pattern 
public class MovieFactory {

	//to return the instance of the class
	public static Movies getInstance(String type) {
		
		//returns the instance of MoviesComingSoon class
		if(type.equalsIgnoreCase("Movies Coming Soon")) {
			return MoviesComingSoon.getInstance();
		}
		
		//returns the instance of MoviesInTheaters class
		else if(type.equalsIgnoreCase("Movies In Theaters")) {
			return  MoviesInTheaters.getInstance();
		}
		
		//returns the instance of TopRatedMovies class
		else if(type.equalsIgnoreCase("Top Rated Movies")) {
			return  TopRatedMovies.getInstance();
		}
		
		//returns the instance of TopRatedIndianMovies class
		else if(type.equalsIgnoreCase("Top Rated Indian Movies")) {
			return  TopRatedIndianMovies.getInstance();
		}
		
		//returns the instance of MyFavorite class
		else if(type.equalsIgnoreCase("My Favorite")) {
			return  MyFavorite.getInstance();
		}
		
		//return null if the given type is mismatched 
		else {
			return null;
		}
		
	}
	

}
