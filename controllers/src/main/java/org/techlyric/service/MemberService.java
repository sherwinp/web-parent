package org.techlyric.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techlyric.dto.RegisterDTO;

import common.data.GroupMember;
import common.data.Membership;
import common.data.User;
import common.repository.MembershipRepository;
import common.repository.UserRepository;

@Service
public class MemberService {
	private final static Logger LOGGER = Logger.getLogger(MemberService.class.getName());
	@PersistenceContext(unitName="demodb")
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	public Membership findOne(String uname) {
		MembershipRepository membershipRepository=null;
		membershipRepository = new JpaRepositoryFactory(entityManager).getRepository(MembershipRepository.class);
		return membershipRepository.findOne(uname);
	}
	
	@Transactional
	public void Register(RegisterDTO dto){
		UserRepository userRepository = new JpaRepositoryFactory(entityManager).getRepository(UserRepository.class);
			
		List<User> users = new ArrayList<User>();
	
		users.add(User.newInstance(dto.getEmail_address(), dto.getPhone_number(), dto.getPostal_code()));
		userRepository.save(users);
		
		entityManager.persist(new GroupMember("Operators", dto.getEmail_address()));
	}
}
