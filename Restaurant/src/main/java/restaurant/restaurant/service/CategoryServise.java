package restaurant.restaurant.service;

import java.util.List;

import restaurant.restaurant.model.Category;

public interface CategoryServise {

	public List<Category> findAll();
	public Category findOne(Long id);
	
	
}
