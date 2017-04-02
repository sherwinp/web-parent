package org.techlyric.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.techlyric.RegisterDTO;

import common.data.GroupMember;
import common.data.Membership;
import common.data.User;
import common.repository.MembershipRepository;
import common.repository.UserRepository;

@Component
public class MemberService {
	private final static Logger LOGGER = Logger.getLogger(MemberService.class.getName());
	@PersistenceContext(unitName="demodb")
	private EntityManager entityManager;
	
	private MembershipRepository membershipRepository;

	@Transactional(readOnly = true)
	public Membership findOne(String uname) {
		if( membershipRepository == null ){
			membershipRepository = new JpaRepositoryFactory(entityManager).getRepository(MembershipRepository.class);
			return membershipRepository.findOne(uname);
		} else {
			return null;
		}
	}
	
	@Transactional
	public void Register(RegisterDTO dto){
		UserRepository userRepository = null;
	
		if( userRepository == null ){
			userRepository = new JpaRepositoryFactory(entityManager).getRepository(UserRepository.class);
			
		}
		List users = new ArrayList<User>();
	
		users.add(User.newInstance(dto.getEmail_address(), dto.getPhone_number(), dto.getPostal_code()));
		userRepository.save(users);
		
		entityManager.persist(new GroupMember("Operators", dto.getEmail_address()));
	}
}
