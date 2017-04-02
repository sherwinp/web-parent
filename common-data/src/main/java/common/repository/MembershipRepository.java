package common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import common.data.Membership;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, String> {

}
