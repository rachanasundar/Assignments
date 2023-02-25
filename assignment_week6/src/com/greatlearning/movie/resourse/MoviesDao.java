package com.greatlearning.movie.resourse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.greatlearning.movie.bean.*;
import com.greatlearning.movie.factory.MovieFactory;

public class MoviesDao {

	
	private MoviesDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	//to return the singleton instance of class
	private static final MoviesDao  movieDao = new MoviesDao();
	
	public static MoviesDao getInstance() {
		return movieDao;
	
	}
	
	
	//to select a movie from Movies_Coming_Soon table of the given id 
	public List<Movies> selectMoviesComingSoon(int id){
		List<Movies> listOfMovies = new ArrayList<>();
		try {
			Connection con = DatabaseResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from Movies_Coming_Soon where id =?");
			pstmt.setInt(1, id); 
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Movies movie =MovieFactory.getInstance("Movies Coming Soon");
				movie.setId(rs.getInt(1));
				movie.setTitle(rs.getNString(2));
				movie.setYear(rs.getInt(3));
				movie.setImdbRating(rs.getFloat(8));
				listOfMovies.add(movie);
			}
			
		}catch(Exception e) {
			return null;
		}
		
		return listOfMovies;
	}
	
	//to select a movie from Movies_In_Theaters table of the given id 
	public List<Movies> selectMovieInTheaters(int id){
		List<Movies> listOfMovies = new ArrayList<>();
		try {
			Connection con = DatabaseResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from Movies_In_Theaters where id =?");
			pstmt.setInt(1, id); 
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Movies movie =MovieFactory.getInstance("Movies In Theaters");
				movie.setId(rs.getInt(1));
				movie.setTitle(rs.getNString(2));
				movie.setYear(rs.getInt(3));
				movie.setImdbRating(rs.getFloat(8));
				listOfMovies.add(movie);
			}
			
		}catch(Exception e) {
			return null;
		}
		
		return listOfMovies;
	}
	
	
	//to select a movie from Top_Rated_Movies table of the given id 
	public List<Movies> selectTopRatedMovies(int id){
		List<Movies> listOfMovies = new ArrayList<>();
		try {
			Connection con = DatabaseResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from Top_Rated_Movies where id =?");
			pstmt.setInt(1, id); 
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Movies movie =MovieFactory.getInstance("Top Rated Movies");
				movie.setId(rs.getInt(1));
				movie.setTitle(rs.getNString(2));
				movie.setYear(rs.getInt(3));
				movie.setImdbRating(rs.getFloat(8));
				listOfMovies.add(movie);
			}
			
		}catch(Exception e) {
			return null;
		}
		
		return listOfMovies;
	}
	
	//to select a movie from Top_Rated_Indian_Movies table of the given id 
	public List<Movies> selectTopRatedIndianMovies(int id){
		List<Movies> listOfMovies = new ArrayList<>();
		try {
			Connection con = DatabaseResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from Top_Rated_Indian_Movies where id =?");
			pstmt.setInt(1, id); 
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Movies movie =MovieFactory.getInstance("Top Rated Indian Movies");
				movie.setId(rs.getInt(1));
				movie.setTitle(rs.getNString(2));
				movie.setYear(rs.getInt(3));
				movie.setImdbRating(rs.getFloat(8));
				listOfMovies.add(movie);
			}
			
		}catch(Exception e) {
			return null;
		}
		
		return listOfMovies;
	}
	
}
