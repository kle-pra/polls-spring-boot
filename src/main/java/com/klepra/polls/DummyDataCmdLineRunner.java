/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klepra.polls;

import com.klepra.polls.entity.Option;
import com.klepra.polls.entity.Poll;
import com.klepra.polls.entity.Role;
import com.klepra.polls.entity.RoleEnum;
import com.klepra.polls.entity.User;
import com.klepra.polls.repository.OptionRepository;
import com.klepra.polls.repository.PollRepository;
import com.klepra.polls.repository.RoleRepository;
import com.klepra.polls.repository.UserRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author klemen
 */
@Component
public class DummyDataCmdLineRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Override
    public void run(String... strings) throws Exception {

        Role userRole = new Role(RoleEnum.ROLE_USER.toString());
        roleRepository.save(userRole);
        Role adminRole = new Role(RoleEnum.ROLE_ADMIN.toString());
        roleRepository.save(adminRole);

        String password = bcryptEncoder.encode("password");

        //insert normal test user
        User u1 = new User("user", password);
        u1.setRoles(Arrays.asList(userRole));
        userRepository.save(u1);

        //insert admin test user
        User u2 = new User("admin", password);
        u2.setRoles(Arrays.asList(adminRole, userRole));
        userRepository.save(u2);
        Poll poll = new Poll("What do you preffer to code backend in?");
        poll.setVisible(Boolean.TRUE);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        poll.setEndDate(Date.from(tomorrow.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        poll.setIpAdresses(Arrays.asList("192.1.2.164"));
        poll.setUser(u1);
        pollRepository.save(poll);

        Option option1 = new Option("Java");
        Option option2 = new Option("Node");
        option1.setPoll(poll);
        option2.setPoll(poll);
        optionRepository.save(option1);
        optionRepository.save(option2);

        Poll poll2 = new Poll("What do frontend framework do you preffer?");
        poll2.setVisible(Boolean.TRUE);
        poll2.setEndDate(new Date());
        poll2.setIpAdresses(Arrays.asList("192.1.2.164"));
        poll2.setUser(u1);

        option1 = new Option("Angular");
        option2 = new Option("React");
        option1.setPoll(poll2);
        option2.setPoll(poll2);
        pollRepository.save(poll2);
        optionRepository.save(option1);
        optionRepository.save(option2);

    }

}
