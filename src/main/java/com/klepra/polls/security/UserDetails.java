/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klepra.polls.security;

import com.klepra.polls.entity.User;
import com.klepra.polls.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author klemen
 */
public class UserDetails extends User {
    
    private UserRepository userRepository;

    @Autowired
    public UserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public String getUsername() { 
        return super.getUsername();
    }
    
}
