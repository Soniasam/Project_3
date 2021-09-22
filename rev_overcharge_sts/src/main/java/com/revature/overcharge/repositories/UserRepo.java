package com.revature.overcharge.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.overcharge.beans.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	public User findByUsername(String username);	
	
    public boolean existsByUsernameAndPassword(String username, String password);

}
