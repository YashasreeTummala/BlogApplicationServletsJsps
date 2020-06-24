package dao;

import model.User;

public interface UserDaoInterface {
	int signup(User user) throws Exception;
	boolean loginUser(User user) throws Exception;
	
}
