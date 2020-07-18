package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.spring.dao.DAO;
import com.spring.pojo_beans.Login_bean;
import com.spring.pojo_beans.Movie_bean;
import com.spring.pojo_beans.Register_bean;
import com.spring.pojo_beans.UserDetails_bean;
import com.spring.pojo_beans.Usermovie_bean;

@Service
public class AppService 
{
	@Autowired
	DAO dao;
	
	public AppService()
	{
		System.out.println("in no argument constructor of App Service class");
	}
	
	
	public String register(Register_bean rb,byte[] barr)
	{
		System.out.println("in Register method of AppService class");
		UserDetails_bean ub = new UserDetails_bean();
		ub.setEmail(rb.getEmail());
		ub.setName(rb.getUname());
		ub.setPassword(rb.getPass());
		ub.setPic(barr);
		String message = dao.Register(ub);
		if(!message.equals("success"))
			{
				System.out.println("in app_service and registration failed due to some error "+message);
				return message;
			}
		else
		{ 
			System.out.println("in app service and Registration success");
			
			return message;
		}
	}
	
	
	
	public void login(Login_bean lb,HttpSession ses)
	{
		List<UserDetails_bean> Userdetails_list = dao.Login(lb);
		System.out.println(Userdetails_list);
		if(Userdetails_list.size()==0)
		{
			ses.setAttribute("status","email id not found! please register");
			
		}
		else
		{
			if(lb.getPassword().equals(Userdetails_list.get(0).getPassword()))
			{
				ses.setAttribute("status","success");
				ses.setAttribute("user_bean", Userdetails_list.get(0));
				System.out.println(ses.getAttribute("user_bean")+"   simply printing");
				System.out.println("retorened from login dao");
				
			}
			else
			{
				ses.setAttribute("status","password incorrect");
			}
		}
		
	}
	
	public void getUserMovieList(HttpSession ses)
	{
		System.out.println("in get user movie list method of app service class");
		UserDetails_bean ub = (UserDetails_bean)ses.getAttribute("user_bean");
		List<Movie_bean> movie_list = dao.getUserMovieList(ub.getSl_no());
		ses.setAttribute("movie_list", movie_list);
		System.out.println(movie_list);
	}
	
	public String addmovie(UserDetails_bean ub)
	{
		System.out.println("in add movie method of Appservice");
		String message  = dao.addmovie(ub);
		System.out.println("in apps ervice class add movie method "+message);
		return message;
	}
	
	public String updatemovieinfo(Movie_bean mb)
	{
		
		System.out.println("in update movie method of Appservice");
		String message  = dao.updatemovieinfo(mb);
		System.out.println("in app service class update movie method "+message);
		return message;
	}
	
	public String deletemovie(Movie_bean mb)
	{
		
		System.out.println("in delete movie method of Appservice");
		String message  = dao.deletemovie(mb);
		System.out.println("in app service class delete movie method "+message);
		return message;
	}
	
	public void getAllUserMovieList(HttpSession ses)
	{
		System.out.println("in get All user movie list method of app service class");
		List<Usermovie_bean> movie_list = dao.getAllUserMovieList();
		ses.setAttribute("movie_list", movie_list);
		System.out.println(movie_list);
	}
	
}
