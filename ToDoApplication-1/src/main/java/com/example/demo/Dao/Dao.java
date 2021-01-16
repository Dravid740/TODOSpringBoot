package com.example.demo.Dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;





@Repository
public class Dao {
	@Autowired
	private SessionFactory sessfact;
	public void registerUser(User user1) {
		Session session = this.sessfact.getCurrentSession();
		session.save(user1);
		
	}
	
	public List<User> displayAllUser() {
		
		
		Session session = this.sessfact.getCurrentSession();
		Query qry = session.createQuery("from User p");

	    List<User> l =((org.hibernate.query.Query) qry).list();
	    System.out.println("Total Number Of Records : "+l.size());
	    Iterator<User> it = l.iterator();
	    while(it.hasNext())
	    {
	        Object o = (Object)it.next();
	        User p = (User)o;
	    }       
	    session.close();
	    return l;
		
	}
	public User searchById(int id1) {
		User p=null;
		Session session = this.sessfact.getCurrentSession();
//		System.out.println("id" + user.getUid());
//		 int id1= user.getUid();
		Query qry = session.createQuery("from User p where uid="+id1+"");
		List<User> m = ((org.hibernate.query.Query) qry).list();
		  Iterator<User> it = m.iterator();
		    while(it.hasNext())
		    {
		        Object o = (Object)it.next();
		        p = (User)o;
		    }  
		 session.close();
		  return p;
		
	}
	public int deleteById(int id) {
		int i;
		Session session = sessfact.getCurrentSession();
		Transaction transaction = session.beginTransaction();
	
		try {
		  // your code
		  String hql = "delete from User p where uid="+id+"";
		  Query query = session.createQuery(hql);
          i=query.executeUpdate();
		  transaction.commit();
		} catch (Throwable t) {
		  transaction.rollback();
		  throw t;
		}		
		 session.close();
		  return i;
		
	}
	
	public int updateById(User u) {
		int i;
		Session session = sessfact.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			  // your code
			  String hql = "update User set ufname=:fname, ulname=:lname, uage=:age, uemail=:email, upassword=:password, uphoneNumber=:phno  where uid=:i";
			  Query query = session.createQuery(hql);
			  query.setParameter("phno", u.getUphoneNumber());
			  query.setParameter("fname", u.getUfname());
			  query.setParameter("lname", u.getUlname());
			  query.setParameter("age", u.getUage());
			  query.setParameter("email", u.getUemail());
			  query.setParameter("password", u.getUpassword());
			  query.setParameter("i", u.getUid());
	          i=query.executeUpdate();
			  System.out.println(query.executeUpdate());
			  // your code end

			  transaction.commit();
			} catch (Throwable t) {
			  transaction.rollback();
			  throw t;
			}		
		 session.close();
		  return i;
		
	}
}
