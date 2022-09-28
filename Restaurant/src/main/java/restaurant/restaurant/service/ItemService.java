package restaurant.restaurant.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import restaurant.restaurant.model.Item;

public interface ItemService {

	public List<Item> findAll();
	public Page<Item> search(String name, int pageNo);
	public Item findOne(Long id);
	public Item save(Item item);
	public void delete(Long id);

}
