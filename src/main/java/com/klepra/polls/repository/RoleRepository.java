/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klepra.polls.repository;

import com.klepra.polls.entity.Role;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author klemen
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    
}
