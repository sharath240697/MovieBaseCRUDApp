package com.spring.pojo_beans;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Usermovie_bean 
{
	
	
	@NotBlank
	private String name;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	private String movie_name;
	@NotBlank
	private String user_comments;
	@Range(min=0,max=5)
	private double movie_rating;
	
	
	
	public Usermovie_bean()
	{
		System.out.println("in no argument constructor of movie bean");
	}
	
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getUser_comments() {
		return user_comments;
	}
	public void setUser_comments(String user_comments) {
		this.user_comments = user_comments;
	}
	public double getMovie_rating() {
		return movie_rating;
	}
	public void setMovie_rating(double movie_rating) {
		this.movie_rating = movie_rating;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movie_name == null) ? 0 : movie_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(movie_rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		
		result = prime * result + ((user_comments == null) ? 0 : user_comments.hashCode());
		
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usermovie_bean other = (Usermovie_bean) obj;
		if (movie_name == null) {
			if (other.movie_name != null)
				return false;
		} else if (!movie_name.equals(other.movie_name))
			return false;
		if (Double.doubleToLongBits(movie_rating) != Double.doubleToLongBits(other.movie_rating))
			return false;
		
		if (user_comments == null) {
			if (other.user_comments != null)
				return false;
		} else if (!user_comments.equals(other.user_comments))
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "Movie_bean [sl_no=" + ", user_slno=" + ", movie_name=" + movie_name
				+ ", user_comments=" + user_comments + ", movie_rating=" + movie_rating + "]";
	}
	
	

}
