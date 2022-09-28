package restaurant.restaurant.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


import restaurant.restaurant.model.Item;
@Component
public interface ItemRepository extends JpaRepository<Item, Long> {

	Page<Item> findByNameContains(String name, Pageable page);
	
	
}
