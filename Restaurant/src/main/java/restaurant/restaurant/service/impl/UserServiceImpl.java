package restaurant.restaurant.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.restaurant.model.User;
import restaurant.restaurant.repository.UserRepository;
import restaurant.restaurant.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User findOne(String name, String password) {
		
		return repository.findByUsernameAndPassword(name, password);
	}

}
