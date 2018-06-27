/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klepra.polls.repository;

import com.klepra.polls.entity.Role;
import com.klepra.polls.entity.User;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 *
 * @author klemen
 */
@RunWith(SpringRunner.class)
@DataJpaTest()
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsernameAndFetchRoles() {
        User user1 = new User("test1", "test1");
        User user2 = new User("test2", "test2");

        Role role1 = new Role("admin");
        Role role2 = new Role("user");

        em.persist(role1);
        em.persist(role2);
        user1.setRoles(Arrays.asList(role2));
        user2.setRoles(Arrays.asList(role1, role2));

        em.persist(user1);
        em.persist(user2);

        em.flush();

        User u1 = userRepository.findByUsernameAndFetchRoles("test1");
        User u2 = userRepository.findByUsernameAndFetchRoles("test2");

        Assert.notNull(u1.getRoles(), "Roles not empty");
        Assert.notNull(u2.getRoles(), "Roles not empty");

    }

}
