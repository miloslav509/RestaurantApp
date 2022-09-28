package restaurant.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import restaurant.restaurant.model.Category;
@Component
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
