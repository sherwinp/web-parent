package common.data;

import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;

import java.io.InputStream;

public class Utility {
	private final static Logger LOGGER = Logger.getLogger(Utility.class.getName());
	private final static Properties ConnectionProperties = new Properties();
	public static void main(String[] args) throws Exception{
		
		InputStream is = ClassLoader.getSystemResourceAsStream( "META-INF/connection.properties" );
		ConnectionProperties.load( is );
		is.close();

			EntityManagerFactory emf = Persistence.createEntityManagerFactory( "demodb", ConnectionProperties );
			EntityManager em = emf.createEntityManager();

			Query q = em.createQuery("SELECT grp, u FROM GroupMember grp JOIN User u ON grp.member = u.name ");
			q.setFirstResult(1 * 1)
	           .setMaxResults(1)
	           .getResultList();
			
			
			em.close();
			emf.close();
		
		
	}	
}
