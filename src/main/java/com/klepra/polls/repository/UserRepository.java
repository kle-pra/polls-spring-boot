/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klepra.polls.repository;

import com.klepra.polls.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author klemen
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByUsername(String username);

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = (:username)")
    User findByUsernameAndFetchRoles(@Param("username") String username);
}
