package com.spring.mvc;

import com.spring.service.*;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.pojo_beans.Login_bean;
import com.spring.pojo_beans.Movie_bean;
import com.spring.pojo_beans.Register_bean;
import com.spring.pojo_beans.UserDetails_bean;
import com.spring.pojo_beans.Usermovie_bean;



@Controller
public class PojoController 
{
	@Autowired
	AppService as;
	UserDetails_bean ub;
	public PojoController()
	{
		System.out.println("in no wrgument constructor of PojoController ");
	}
	
	
	@RequestMapping({"/","/home"})
	public String showhome()
	{
		System.out.println("in showhome method of POJOcontroller class");
	 return "Home";
	}
	
	@RequestMapping("/openRegisterView")
	public String showregisterpage(Model m)
	{
		System.out.println("in showregisterpage method of POJOcontroller class");
		Register_bean reg = new Register_bean();
		m.addAttribute("reg",reg);
		return "Register";
	}
	
	@RequestMapping("/openLoginView")
	public String showloginpage(Model m)
	{
		System.out.println("in show login method of POJOcontroller class");
		Login_bean log_bean = new Login_bean();
		m.addAttribute("log_bean",log_bean);
		return "Login";
	}
	
	@RequestMapping("/openuserhomeview")
	public String openuserhome(HttpSession ses,Model m)
	{
		System.out.println("in open user home view");
		ub = (UserDetails_bean)ses.getAttribute("user_bean");
		
		
		if(ub==null)
		{
			m.addAttribute("loginerror_message","Please Login!");
			m.addAttribute("log_bean",new Login_bean());
			return "Login";
		}
		System.out.println(ub.getMovies()+" movie list in user home page");
		System.out.println(ses);
		
		m.addAttribute("user",ub.getName());
	//	System.out.println("initiating request from login post processing method to get user movie list from app service class");
		List<Movie_bean> movie_list = ub.getMovies();
		if(movie_list.size()==0)
		{
			String movie_empty = "is Empty!";
			m.addAttribute("movie_empty",movie_empty);
		}
		m.addAttribute("movie_list",movie_list);
		return "UserHome";
	}
	
	@RequestMapping(value = "/getdp")
	public void getStudentPhoto(HttpServletResponse response, HttpSession ses,Model m) throws Exception 
	{
		ub = (UserDetails_bean)ses.getAttribute("user_bean");
		response.setContentType("image/jpeg");
		if(ub==null)
		{
			m.addAttribute("loginerror_message","Please Login!");
			m.addAttribute("log_bean",new Login_bean());
			return;
		}

		byte[] bytes = ub.getPic() ;
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
	
	@RequestMapping("/openAddMovieView")
	public String showAddmovieView(HttpSession ses,Model m)
	{
		ub = (UserDetails_bean)ses.getAttribute("user_bean");
		if(ub==null)
		{
			m.addAttribute("loginerror_message","Please Login!");
			m.addAttribute("log_bean",new Login_bean());
			return "Login";
		}
		System.out.println("in show add movie view of pojo controller");
		Movie_bean mb = new Movie_bean();
		m.addAttribute("movie_bean",mb);
		return "Addmovie";
	}
	@RequestMapping("/editmovieview")
	public String editmovieview(@ModelAttribute("movie_bean") Movie_bean mb,HttpSession ses,Model m)
	{
		ub = (UserDetails_bean)ses.getAttribute("user_bean");
		if(ub==null)
		{
			m.addAttribute("loginerror_message","Please Login!");
			m.addAttribute("log_bean",new Login_bean());
			return "Login";
		}
		return "EditMovie";
	}
	@RequestMapping("/deletemovieview")
	public String deletemovieview(@ModelAttribute("movie_bean") Movie_bean mb,HttpSession ses,Model m)
	{
		ub = (UserDetails_bean)ses.getAttribute("user_bean");
		if(ub==null)
		{
			m.addAttribute("loginerror_message","Please Login!");
			m.addAttribute("log_bean",new Login_bean());
			return "Login";
		}
		return "DeleteMovie";
	}
	
	
	
	@RequestMapping("/register")
	public String register_postprocessing(@ModelAttribute("reg") @Valid Register_bean b,BindingResult br,Model m)
	{
		System.out.println("in register post processing method of POJOcontroller class");

		if(br.hasErrors())
		{
			return "Register";
		}
		else
		{
			if(b.getPass().equals(b.getRpass()))
			{
				byte barr[] =  null;
				try
				{  	
			        barr= b.getPic().getBytes();     
		        }
				catch(Exception e)
				{System.out.println(e);}  
				if(barr.length<=0)
				{
					System.out.println("in pojocontrolloer register method for checking pic less than 0");
					m.addAttribute("pic_message","Please upload pic");
					return "Register";
				}
				
				String message = as.register(b,barr);
				if(message.equals("success"))
				{
					System.out.println("in pojocontrolloer register method "+message);
					message = "Registered Successfully Please login!";
					m.addAttribute("register_message",message);
					m.addAttribute("log_bean",new Login_bean());
					return "Login";
				}
				else
				{
					System.out.println("in pojocontrolloer register method "+message);
					m.addAttribute("register_message",message);
					return "Register";
				}
			}
			else
			{
				String str = "Password doesnt match";
				m.addAttribute("pass_error_msg",str);
				return "Register";
			}
		}
	}
	
	@RequestMapping("/login")
	public String login_postprocessing(@ModelAttribute("log_bean") @Valid Login_bean lb,BindingResult br,Model m,HttpSession ses,HttpServletResponse response)
	{
		System.out.println("in login postprocessing method of pojocontroller");
		if(br.hasErrors())
		{
			return "Login";
		}
		else
		{
			as.login(lb,ses);
			if(ses.getAttribute("status").equals("success"))
			{
					System.out.println("returne from app service login" );
					ub = (UserDetails_bean)ses.getAttribute("user_bean");
					
					
					if(ub==null)
					{
						m.addAttribute("loginerror_message","Please Login!");
						m.addAttribute("log_bean",new Login_bean());
						return "Login";
					}
				m.addAttribute("user",ub.getName());
				//	System.out.println("initiating request from login post processing method to get user movie list from app service class");
	
				List<Movie_bean> movie_list = ub.getMovies();
					if(movie_list.size()==0)
					{
						String movie_empty = "is Empty!";
						m.addAttribute("movie_empty",movie_empty);
					}
					m.addAttribute("movie_list",movie_list);
				System.out.println("returne from app service login hju78");
				return "UserHome";
			}
			else
			{
				m.addAttribute("loginerror_message",ses.getAttribute("status"));
				return "Login";
			}
		}
	}
	
	
	
	@RequestMapping("/addmovie")
	public String addMovie_postprocessing(@ModelAttribute("movie_bean") @Valid Movie_bean mb,BindingResult br,Model m,HttpSession ses,HttpServletResponse response)
	{
		
		UserDetails_bean ub = (UserDetails_bean)ses.getAttribute("user_bean");
		mb.setUser(ub);
		if(ub==null)
		{
			m.addAttribute("loginerror_message","Please Login!");
			m.addAttribute("log_bean",new Login_bean());
			return "Login";
		}
		System.out.println("in add post processing method of pojo controller");
		if(br.hasErrors())
		{
			return "Addmovie";
		}
		else
		{
			ub.getMovies().add(mb);
			System.out.println(ub);
			String message = as.addmovie(ub);
			System.out.println("in add movie method pojocontroller class after using database "+message);
			if(message.equals("success"))
			{
				m.addAttribute("successfully_added","Movie was successfully added to your movie base");
				System.out.println(ub);
				
					System.out.println("returne from app service login" );
		
ub = (UserDetails_bean)ses.getAttribute("user_bean");
					
					
					if(ub==null)
					{
						m.addAttribute("loginerror_message","Please Login!");
						m.addAttribute("log_bean",new Login_bean());
						return "Login";
					}
				m.addAttribute("user",ub.getName());
				//	System.out.println("initiating request from login post processing method to get user movie list from app service class");
	
				List<Movie_bean> movie_list = ub.getMovies();
					if(movie_list.size()==0)
					{
						String movie_empty = "is Empty!";
						m.addAttribute("movie_empty",movie_empty);
					}
					m.addAttribute("movie_list",movie_list);
				System.out.println("returne from app service login hju78");
				return "UserHome";
				
			}
			else
			{
				m.addAttribute("error_adding","Movie already exists in your movie base");
				return "Addmovie";
			}
		}
	}
	
	
	
	@RequestMapping("/editmovieinfo")
	public String updatemovieinfo(Movie_bean mb,Model m,HttpSession ses)
	{
		UserDetails_bean ub = (UserDetails_bean)ses.getAttribute("user_bean");
		if(ub==null)
		{
			m.addAttribute("loginerror_message","Please Login!");
			m.addAttribute("log_bean",new Login_bean());
			return "Login";
		}
		mb.setUser(ub);
		String message = as.updatemovieinfo(mb);
		m.addAttribute("update_message",message);
		as.getUserMovieList(ses);
		return "UserHome";
	}
	
	@RequestMapping("/deletemovie")
	public String deletemoviefrommoviebase(Movie_bean mb,Model m,HttpSession ses)
	{
		UserDetails_bean ub = (UserDetails_bean)ses.getAttribute("user_bean");
		if(ub==null)
		{
			m.addAttribute("loginerror_message","Please Login!");
			m.addAttribute("log_bean",new Login_bean());
			return "Login";
		}
		mb.setUser(ub);
		String message = as.deletemovie(mb);
		m.addAttribute("delete_message",message);
		as.getUserMovieList(ses);
		return "UserHome";
	}
	
	@RequestMapping("movie_base_view")
	public String moviebaseview(HttpSession ses,Model m)
	{
		UserDetails_bean ub = (UserDetails_bean)ses.getAttribute("user_bean");
		if(ub==null)
		{
			m.addAttribute("loginerror_message","Please Login!");
			m.addAttribute("log_bean",new Login_bean());
			return "Login";
		}
		as.getAllUserMovieList(ses);
		List<Usermovie_bean> movie_list = (ArrayList<Usermovie_bean>)ses.getAttribute("movie_list");
		if(movie_list.size()==0)
		{
			String movie_empty = "is Empty!";
			m.addAttribute("movie_empty",movie_empty);
		}
		return "Viewmoviebase";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession ses)
	{
		System.out.println("in logging out method of pojo controller class");
		ses.invalidate();
		return "Home";
	}
	
}
