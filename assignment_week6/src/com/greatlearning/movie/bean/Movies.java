package com.greatlearning.movie.bean;


//Movie interface with all required function
public interface Movies {

	public int getId();
	public void setId(int id) ;
	public String getTitle();
	public void setTitle(String title);
	public int getYear() ;
	public void setYear(int year);
	public String[] getGenres();
	public void setGenres(String[] genres);
	public String getDuration();
	public void setDuration(String duration);
	public String getReleaseDate();
	public void setReleaseDate(String releaseDate); 
	public String[] getActors();
	public void setActors(String[] actors);
	public float getImdbRating();
	public void setImdbRating(float imdbRating);
	public String getPosterUrl();
	public void setPosterUrl(String posterUrl);
}
