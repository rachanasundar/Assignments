package com.greatlearning.movie.bean;

import java.util.Arrays;

//Class implements Movies and override all the methods 
public class MoviesInTheaters implements Movies{
	
	private int id;
	private String title;
	private int year;
	private String[] genres;
	private String duration;
	private String releaseDate;
	private String[] actors;
	private float imdbRating;
	private String posterUrl;

	
	//to avoid creation of object through class
	private MoviesInTheaters() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private static MoviesInTheaters movie = new MoviesInTheaters();
	
	//to return the instance of the class
	public static  MoviesInTheaters getInstance() {
		return movie;
	}
	


	
	@Override
	public int getId() {
		return id;
	}




	@Override
	public void setId(int id) {
		this.id = id;
	}




	@Override
	public String getTitle() {
		return title;
	}




	@Override
	public void setTitle(String title) {
		this.title = title;
	}




	@Override
	public int getYear() {
		return year;
	}




	@Override
	public void setYear(int year) {
		this.year = year;
	}




	@Override
	public String[] getGenres() {
		return genres;
	}




	@Override
	public void setGenres(String[] genres) {
		this.genres = genres;
	}




	@Override
	public String getDuration() {
		return duration;
	}




	@Override
	public void setDuration(String duration) {
		this.duration = duration;
	}




	@Override
	public String getReleaseDate() {
		return releaseDate;
	}




	@Override
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}




	@Override
	public String[] getActors() {
		return actors;
	}




	@Override
	public void setActors(String[] actors) {
		this.actors = actors;
	}




	@Override
	public float getImdbRating() {
		return imdbRating;
	}




	@Override
	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}




	@Override
	public String getPosterUrl() {
		return posterUrl;
	}




	@Override
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
	@Override
	public String toString() {
		return "MoviesInTheaters [id=" + id + ", title=" + title + ", year=" + year + ", genres="
				+ Arrays.toString(genres) + ", duration=" + duration + ", releaseDate=" + releaseDate + ", actors="
				+ Arrays.toString(actors) + ", imdbRating=" + imdbRating + ", posterUrl=" + posterUrl + "]";
	}




}
