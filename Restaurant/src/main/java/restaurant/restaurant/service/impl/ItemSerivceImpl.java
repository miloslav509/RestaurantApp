package restaurant.restaurant.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import restaurant.restaurant.model.Item;
import restaurant.restaurant.repository.ItemRepository;
import restaurant.restaurant.service.ItemService;

@Service
public class ItemSerivceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public List<Item> findAll() {
		
		return itemRepository.findAll();
	}

	@Override
	public Page<Item> search(String name, int pageNo) {
		
		return itemRepository.findByNameContains(name, PageRequest.of(pageNo, 3));
	}

	@Override
	public Item findOne(Long id) {
		
		return itemRepository.findById(id).get();
	}

	@Override
	public Item save(Item item) {
		
		return itemRepository.save(item);
	}

	@Override
	public void delete(Long id) {
		itemRepository.deleteById(id);
	}
	
}


