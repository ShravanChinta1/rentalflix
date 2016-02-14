package io.egen.rentalflix;

/**
 * Entity representing a movie.
 * Fields: id, title, year, language
 */
public class Movie {
	
	//POJO IMPLEMENTATION GOES HERE
	private int id;
	private String title;
	private int year;
	private String language;
	private boolean rented=false;
	private String user=null;
	
	public Movie(int id,String title,int year,String language){
		this.id=id;
		this.title=title;
		this.year=year;
		this.language=language;
	}
	
	// Getters and Setters
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title=title;
	}
	
	public int getYear(){
		return this.year;
	}
	public void setYear(int year){
		this.year=year;
	}
	
	public String getLanguage(){
		return this.language;
	}
	public void setLanguage(String language){
		this.language=language;
	}
	
	public boolean getRented(){
		return rented;
	}
	public void setRented(boolean rented){
		this.rented=rented;
	}
	
	public String getUser(){
		return this.user;
	}
	public void setUser(String user){
		this.user=user;
	}
	
	
}
