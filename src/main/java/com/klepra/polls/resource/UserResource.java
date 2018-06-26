/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klepra.polls.resource;

import com.klepra.polls.entity.User;
import com.klepra.polls.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author klemen
 */
@RestController
@RequestMapping("/api/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(@RequestParam(defaultValue = "false") Boolean includeAdmins) {
        return userService.getAllUsers(includeAdmins);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(204).build();
    }

}
