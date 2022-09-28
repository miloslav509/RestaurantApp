package restaurant.restaurant.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import restaurant.restaurant.dto.ItemDTO;
import restaurant.restaurant.model.Item;

@Component
public class ItemToItemDto implements Converter<Item, ItemDTO> {
	
	@Autowired
	private CategoryToCategoryDto toCategoryDto;

	@Override
	public ItemDTO convert(Item s) {
		ItemDTO dto = new ItemDTO();
		
		dto.setId(s.getId());
		dto.setName(s.getName());
		dto.setPrice(s.getPrice());
		dto.setCategory(toCategoryDto.convert(s.getCategory()));
		
		return dto;
	}
	
	public List<ItemDTO> convert(List<Item> items) {
		List<ItemDTO> dto = new ArrayList<>();
		
		for (Item item : items) {
			dto.add(convert(item));
		}
		
		return dto;
	}

	
}
