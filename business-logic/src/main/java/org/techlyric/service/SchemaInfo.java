package org.techlyric.service;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Service;

@Service
public class SchemaInfo {
	private final static Logger LOGGER = Logger.getLogger(RegisterUserService.class.getName());
	@PersistenceContext(unitName="demodb")
	private EntityManager entityManager;
	
	public Object[] getEntities(){
		return entityManager.getMetamodel().getEntities().toArray();
	}
}
