package restaurant.restaurant.service;

import restaurant.restaurant.model.User;

public interface UserService {

	User findOne(String name, String password);
}
