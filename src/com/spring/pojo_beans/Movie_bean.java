package com.spring.pojo_beans;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "Movies")
public class Movie_bean 
{
	@Id  @GeneratedValue
	private long sl_no;
	
	
	@NotBlank
	private String movie_name;
	@NotBlank
	private String user_comments;
	@Range(min=0,max=5)
	@NumberFormat
	private double movie_rating;
	public long getSl_no() {
		return sl_no;
	} 
	@ManyToOne
	private UserDetails_bean user;
	
	public Movie_bean()
	{
		System.out.println("in no argument constructor of movie bean");
	}
	public void setSl_no(int sl_no) {
		this.sl_no = sl_no;
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
	public UserDetails_bean getUser() {
		return user;
	}
	public void setUser(UserDetails_bean user) {
		this.user = user;
	}
	private void setSl_no(long sl_no) {
		this.sl_no = sl_no;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movie_name == null) ? 0 : movie_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(movie_rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Movie_bean other = (Movie_bean) obj;
		if (movie_name == null) {
			if (other.movie_name != null)
				return false;
		} else if (!movie_name.equals(other.movie_name))
			return false;
		if (Double.doubleToLongBits(movie_rating) != Double.doubleToLongBits(other.movie_rating))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
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
		return "Movie_bean [movie_name=" + movie_name + ", user_comments=" + user_comments + ", movie_rating="
				+ movie_rating +  "]";
	}
	
	

}
