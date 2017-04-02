package common.data;

import java.util.Properties;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.InputStream;

public class Utility {
	private final static Logger LOGGER = Logger.getLogger(Utility.class.getName());
	private final static Properties ConnectionProperties = new Properties();

	public static void main(String[] args) throws Exception {

		InputStream is = ClassLoader.getSystemResourceAsStream("META-INF/connection.properties");
		ConnectionProperties.load(is);
		is.close();
		is = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demodb", ConnectionProperties);
		EntityManager em = emf.createEntityManager();

		// Query q = em.createQuery("SELECT grp, u FROM GroupMember grp JOIN
		// User u ON grp.member = u.name ");
		// q.setFirstResult(1).setMaxResults(1).getResultList();
		try {
			em.getTransaction().begin();

			Query q = em.createQuery("SELECT m FROM Membership m");
			q.setFirstResult(1).setMaxResults(1).getResultList();

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {

			em.close();
			emf.close();
			emf = null;
		}
	}
}
