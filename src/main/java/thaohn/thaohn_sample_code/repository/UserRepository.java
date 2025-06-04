package thaohn.thaohn_sample_code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thaohn.thaohn_sample_code.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
