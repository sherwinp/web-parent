package common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import common.data.Membership;
import common.data.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
