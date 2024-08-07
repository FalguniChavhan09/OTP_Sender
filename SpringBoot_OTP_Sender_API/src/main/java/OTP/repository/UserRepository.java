package OTP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import OTP.com.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}