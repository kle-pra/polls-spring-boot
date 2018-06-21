/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klepra.polls.services;

import com.klepra.polls.entity.User;
import com.klepra.polls.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author klemen
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {

        User existingUser = userRepository.findOneByUsername(user.getUsername());
        if (existingUser != null) {
            throw new IllegalArgumentException("Username already exists exception");
        }
        return userRepository.save(user);
    }

}
