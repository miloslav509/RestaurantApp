package restaurant.restaurant.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import restaurant.restaurant.model.User;


@Component
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsernameAndPassword(String username,String password);
}
