package common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import common.data.Membership;

@RepositoryRestResource
public interface MembershipRepository extends JpaRepository<Membership, String> {

}
