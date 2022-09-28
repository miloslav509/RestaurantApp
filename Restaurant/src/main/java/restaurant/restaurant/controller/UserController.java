package restaurant.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import restaurant.restaurant.dto.ItemDTO;
import restaurant.restaurant.dto.UserDTO;
import restaurant.restaurant.model.Item;
import restaurant.restaurant.model.User;
import restaurant.restaurant.service.impl.UserServiceImpl;
import restaurant.restaurant.support.USerToUSerDto;

@RestController
@RequestMapping(value = "/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserServiceImpl service;
	
   @Autowired
   private USerToUSerDto toUSerDto;
   
   @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
	   
		User retVal = service.findOne(userDTO.getUsername(), userDTO.getPassword());
		
		if (retVal != null) {
			return new ResponseEntity<>(toUSerDto.convert(retVal), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }
}
