package com.sri.mvc.DAO;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sri.mvc.Entity.SignuEntity;

@Component
public class SignupDAOImpl implements SignupDAO {
	private static  Logger logger = Logger.getLogger(SignupDAOImpl.class);
	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public void save(SignuEntity ent) {
		System.out.println("entered save");
		logger.info("enter saving");

		try {
			// Session session = Factory.openSession();
			/*
			 * System.out.println("dao implement start"); System.out.println(ent);
			 * Configuration cfg = new Configuration(); cfg.configure();
			 * cfg.addAnnotatedClass(SignuEntity.class); SessionFactory fsc =
			 * cfg.buildSessionFactory();
			 */
			Session session = factory.openSession();
			session.beginTransaction();
			System.out.println("tx begin");
			logger.info("tx begin");
			System.out.println("data saving");
			logger.info("data saving");
			if (Objects.nonNull(ent)) {
				session.save(ent);
			} else {
				System.out.println("cannot save");
				logger.info("cannot save");
			}

			session.getTransaction().commit();
			System.out.println("commited");
			logger.info("commited");

			System.out.println("all resource closed");
			logger.info("all resources closed");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

	}

	public SignuEntity fetch(String email) {
		Session session = factory.openSession();
		try {
			System.out.println("invoked mail " + email);
			logger.info("invoked mail "+email);
			Query query = session.getNamedQuery("fetchbyemail");
			query.setParameter("mail", email);
			System.out.println("query " + query);
			logger.info("query "+query);
			Object str = query.uniqueResult();
			if (Objects.nonNull(str)) {
				System.out.println("email exists");
				logger.info("email exist");
				SignuEntity ent = (SignuEntity) str;
				return ent;
			}

			else {
				System.out.println("email not exixt");
				logger.info("email not exist");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			session.close();

		}
		return null;
	}

	public SignuEntity fetchbymailandpassword(String mail, String password) {
		Session session = factory.openSession();
		try {
			System.out.println("invoked signin fromIMPL");
			logger.info("invoked signoin from impl");
			Query query = session.getNamedQuery("fetchbyemailandpassword");
			query.setParameter("mail", mail);
			query.setParameter("pwd", password);
			System.out.println("query " + query);
			logger.info("query "+query);
			Object out = query.uniqueResult();
			if (Objects.nonNull(out)) {
				SignuEntity ent = (SignuEntity) out;
				return ent;
			}

			else {
				System.out.println("not available");
				logger.info("not available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			session.close();

		}
		return null;
	}

	public String updatepassword(String mail, String password) {
		Session session = factory.openSession();
		try {
			System.out.println("invoked mail " + mail);
			logger.info("invoked mail "+mail);
			Query query = session.getNamedQuery("fetchbyemail");

			query.setParameter("mail", mail);
			System.out.println("query " + query);
			logger.info("query "+query);
			String out = (String) query.uniqueResult();
			if (Objects.nonNull(out)) {
				System.out.println("entering update 2nd loop");
				logger.info("entering update second loop");
				String ent = (String) out;
				Transaction tx = session.beginTransaction();
				Query query1 = session.getNamedQuery("updatepasswordbyemail");
				query1.setParameter("mail", out);

				query1.setParameter("pwd", password);
				query1.executeUpdate();
				tx.commit();
				return (String) out;
			}

			else {
				System.out.println("not available");
				logger.info("not availablle");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			session.close();

		}
		return password;

	}

}
