package restaurant.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import restaurant.restaurant.dto.CategoryDTO;
import restaurant.restaurant.model.Category;
import restaurant.restaurant.service.impl.CategoryServiceImpl;
import restaurant.restaurant.support.CategoryToCategoryDto;

@RestController
@RequestMapping(value = "/api/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryService;
	
	@Autowired
	private CategoryToCategoryDto toCategoryDto;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoryDTO>> getAll() {
		List<Category> categories = categoryService.findAll();
		
		return new ResponseEntity<>(toCategoryDto.convert(categories), HttpStatus.OK);
	}
}
