package restaurant.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.restaurant.model.Category;
import restaurant.restaurant.repository.CategoryRepository;
import restaurant.restaurant.service.CategoryServise;

@Service
public class CategoryServiceImpl implements CategoryServise {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		
		return categoryRepository.findAll();
	}

	@Override
	public Category findOne(Long id) {
		
		return categoryRepository.findById(id).get();
	}

}
