package restaurant.restaurant.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import restaurant.restaurant.dto.ItemDTO;
import restaurant.restaurant.model.Item;
import restaurant.restaurant.service.CategoryServise;
import restaurant.restaurant.service.impl.ItemSerivceImpl;

@Component
public class ItemDtoToItem implements Converter<ItemDTO, Item> {

	@Autowired
	private ItemSerivceImpl itemService;
	
	@Autowired
	private CategoryServise categoryServise;

	@Override
	public Item convert(ItemDTO dto) {
		Item item;
		
		if (dto.getId() != null) {
			item = itemService.findOne(dto.getId());
		} else {
			item = new Item();
		}
		
		if (item != null) {
			
			item.setName(dto.getName());
			item.setPrice(dto.getPrice());
			item.setCategory(categoryServise.findOne(dto.getCategory().getId()));
		}
		
		return item;
	}
	
	
}
