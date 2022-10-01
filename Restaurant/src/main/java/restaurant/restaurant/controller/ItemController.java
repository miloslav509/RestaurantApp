package restaurant.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restaurant.restaurant.dto.ItemDTO;
import restaurant.restaurant.model.Item;
import restaurant.restaurant.service.impl.ItemSerivceImpl;
import restaurant.restaurant.support.ItemDtoToItem;
import restaurant.restaurant.support.ItemToItemDto;

@RestController
@RequestMapping(value = "/api/items")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {

	@Autowired
	private ItemSerivceImpl itemSerivce;
	
	@Autowired
	private ItemToItemDto toDto;
	
	@Autowired
	private ItemDtoToItem toItem;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ItemDTO>> getAllSearch(
			@RequestParam(required = false)  String name,
			@RequestParam(defaultValue = "0") int pageNo) {
		Page<Item> items = itemSerivce.search(name, pageNo);
		
		List<ItemDTO> itemsDto = toDto.convert(items.toList());
		
		Page<ItemDTO> itemsPage = new PageImpl<>(itemsDto, items.getPageable(), items.getTotalElements());
		
		return new ResponseEntity<>(itemsPage, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ItemDTO> getOne(@PathVariable Long id) {
		Item item = itemSerivce.findOne(id);
		
		if (item != null) {
			return new ResponseEntity<>(toDto.convert(item), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Item item = itemSerivce.findOne(id);
		
		if (item != null) {
			itemSerivce.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping
	public ResponseEntity<ItemDTO> create(@RequestBody ItemDTO itemDTO) {
		Item item = toItem.convert(itemDTO);
		System.out.println(item);
		Item retVal = itemSerivce.save(item);
		
		if (retVal != null) {
			return new ResponseEntity<>(toDto.convert(retVal), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}
