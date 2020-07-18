package com.spring.pojo_beans;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.Type;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Entity
@Table(name = "Registered_Users")
public class UserDetails_bean 
{
	@Id 
	@GeneratedValue
	private long sl_no;
	@Column(nullable = false)
	private String name;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable=false, columnDefinition="MEDIUMBLOB")
	private byte[] pic;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.EAGER)
	private List<Movie_bean> movies = new ArrayList<Movie_bean>();
	public List<Movie_bean> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie_bean> movies) {
		this.movies = movies;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] blob) {
		this.pic = blob;
	}
	
	public UserDetails_bean()
	{
		System.out.println("in no argument constructor of user details bean used for login n other things");
	}


	public long getSl_no() {
		return sl_no;
	}


	private void setSl_no(long sl_no) {
		this.sl_no = sl_no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((movies == null) ? 0 : movies.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + Arrays.hashCode(pic);
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
		UserDetails_bean other = (UserDetails_bean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (movies == null) {
			if (other.movies != null)
				return false;
		} else if (!movies.equals(other.movies))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (!Arrays.equals(pic, other.pic))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserDetails_bean [sl_no=" + sl_no + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", pic="  + ", movies=" + movies + "]";
	}


	


	
	
	
	
}
