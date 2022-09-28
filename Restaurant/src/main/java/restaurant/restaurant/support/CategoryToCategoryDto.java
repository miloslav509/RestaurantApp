package restaurant.restaurant.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import restaurant.restaurant.dto.CategoryDTO;
import restaurant.restaurant.model.Category;

@Component
public class CategoryToCategoryDto implements Converter<Category, CategoryDTO> {

	@Override
	public CategoryDTO convert(Category s) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(s.getId());
		dto.setName(s.getName());
		
		return dto;
	}

	public List<CategoryDTO> convert(List<Category> categories) {
		List<CategoryDTO> dto = new ArrayList<>();
		
		for (Category category : categories) {
			dto.add(convert(category));
		}
		
		return dto;
	}
}
