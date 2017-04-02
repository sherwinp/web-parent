package org.techlyric.service;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import common.data.Membership;
import common.repository.MembershipRepository;

@Component
public class MemberService {
	private final static Logger LOGGER = Logger.getLogger(MemberService.class.getName());
	@PersistenceContext(unitName="demodb")
	private EntityManager entityManager;
	
	private MembershipRepository membershipRepository;

	@Transactional(readOnly = true)
	public Membership findOne() {
		if( membershipRepository == null ){
			membershipRepository = new JpaRepositoryFactory(entityManager).getRepository(MembershipRepository.class);
			return membershipRepository.findOne("system");
		} else {
			return null;
		}
	}
}
