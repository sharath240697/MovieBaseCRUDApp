package com.spring.dao;

import com.spring.helper.*;
import com.spring.pojo_beans.Login_bean;
import com.spring.pojo_beans.Movie_bean;
import com.spring.pojo_beans.Register_bean;
import com.spring.pojo_beans.UserDetails_bean;
import com.spring.pojo_beans.Usermovie_bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Fetch;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAO 
{
	@Autowired
	SessionFactory sessionfactory;
	Session session;
	JDBChelper jb;
	Connection con=null;
	PreparedStatement ps_ins = null;
	PreparedStatement ps_select = null;
	PreparedStatement ps_update = null;
	PreparedStatement ps_delete = null;
	
	public DAO()
	{
		System.out.println("in no argument constructor of DAO class");
	}
	
	private void establishconnection()
	{
		try 
		{
			con = jb.getConnection();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private void closeconnection()
	{
		if(con!=null)
		{
			jb.close(ps_ins);
			jb.close(con);
		}
	}
	
	
	
	public String Register(UserDetails_bean ub)
	{
		System.out.println("in Register method of DAO class");
			session = sessionfactory.openSession();
			session.beginTransaction();
			session.save(ub);
			session.getTransaction().commit();
			session.close();
			return "success";

	}
	
	
	public List<UserDetails_bean> Login(Login_bean lb)
	{
		
		ArrayList<UserDetails_bean> Userdetails_list = new ArrayList<UserDetails_bean>();
		
		System.out.println("in Login method of DAO class");
		
		String hql = "FROM com.spring.pojo_beans.UserDetails_bean where email = :email";
		session = sessionfactory.openSession();
		session.beginTransaction();
		Query q = session.createQuery(hql);
		System.out.println("before getting eresult set in login dao method");
		q.setParameter("email",lb.getEmail());
		
		Userdetails_list = (ArrayList<UserDetails_bean>) q.getResultList();
		//System.out.println(Userdetails_list+ "user details list in login");
		session.getTransaction().commit();
		session.close();
		return Userdetails_list;
	}
	
	
	public List<Movie_bean> getUserMovieList(long user_sl_no)
	{
		System.out.println("in get user movie list method of DAO class");
		System.out.println("in Login method of DAO class");
		session = sessionfactory.openSession();
		session.beginTransaction();
		System.out.println("before getting eresult set in get user movie list dao method");
		UserDetails_bean ub = session.get(UserDetails_bean.class, user_sl_no);
		
		session.getTransaction().commit();
		session.close();
		
		return ub.getMovies();
	}
	
	public String addmovie(UserDetails_bean ub)
	{
		System.out.println("in add movie method of DAO class");
		session = sessionfactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(ub);
		
		session.getTransaction().commit();
		session.close();
		
		return "success";
		
	}
	
		
	public String updatemovieinfo(Movie_bean mb)
	{
		System.out.println("in update movie method of DAO class");
		System.out.println("in add movie method of DAO class");
		session = sessionfactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(mb);
		session.getTransaction().commit();
		session.close();
		
		return "success";

	}
	
	public String deletemovie(Movie_bean mb)
	{
		System.out.println("in delete movie method of DAO class");
		
		System.out.println("in update movie method of DAO class");
		System.out.println("in add movie method of DAO class");
		session = sessionfactory.openSession();
		session.beginTransaction();
		session.delete(mb);
		session.getTransaction().commit();
		session.close();
		
		return "success";
	}
	
	
	public List<Usermovie_bean> getAllUserMovieList()
	{
		List<Object[]> obj_list = new ArrayList();
		List<Usermovie_bean> movie_list = new ArrayList<Usermovie_bean>();
		System.out.println("in get all user movie list method of DAO class");
		String sql = "Select name,movie_name,user_comments,movie_rating from Movies join Registered_users on Movies.user_sl_no=Registered_users.sl_no";
		session = sessionfactory.openSession();
		session.beginTransaction();
		Query q = session.createSQLQuery(sql);
	//	q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		obj_list = q.list();
		for (Object obj[] : obj_list) 
		{  
			// Map row = (Map)obj;
			
			Usermovie_bean mb = new Usermovie_bean();
			//mb.setName((String)row.get("name"));
			//mb.setMovie_name((String)row.get("movie_name"));
			//mb.setUser_comments((String)row.get("user_comments"));
			//mb.setMovie_rating((double)row.get("movie_rating"));
			
			mb.setName((String)obj[0]);
			mb.setMovie_name((String)obj[1]);
			mb.setUser_comments((String)obj[2]);
			mb.setMovie_rating((double)obj[3]);
			movie_list.add(mb);		}
 		session.getTransaction().commit();
		session.close();
		
		return movie_list;

	}


}
