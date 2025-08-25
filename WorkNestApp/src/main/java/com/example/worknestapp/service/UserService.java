package com.example.worknestapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.worknestapp.dao.UserDao;
import com.example.worknestapp.model.User;

@Service
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
    
    /*public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }*/

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
