package com.anu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.List;

public class LoginDao {
boolean status=false;
	public boolean validate(Login u){
   
		SessionFactory sf = HibernateUtility.getSessionFactory();
			Session s = sf.openSession();
			// before starting save(),update(), delete() operation we need to start
			// TX
			// starting tx mean con.setAutoCommit(false);
			Transaction tx = s.beginTransaction();

			Criteria cr = s.createCriteria(Login.class);
			cr.add(Restrictions.eq("email",u.getEmail()));
			List results = (List) cr.list();
			Iterator iterator = ((java.util.List) results).iterator();
			Login emp = (Login) iterator.next(); 
			if((emp.getUserpass()).equals(u.getUserpass())){
				
			}
			s.close();
		

		
		
		return status;
		
	}
}
