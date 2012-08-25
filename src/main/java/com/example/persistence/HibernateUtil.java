package com.example.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static final SessionFactory sessionFact;
	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFact = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			System.out.println("SessionFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	public static final ThreadLocal session = new ThreadLocal();

	public static Session currentSession() throws HibernateException {
		Session sess = (Session) session.get();
		// Open a new Session, if this thread has none yet
		if (sess == null) {
			sess = sessionFact.openSession();
			// Store it in the ThreadLocal variable
			session.set(sess);
		}
		return sess;
	}

	public static void SessionClose() throws Exception {
		Session s = (Session) session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
}
