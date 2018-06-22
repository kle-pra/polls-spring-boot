package com.klepra.polls.security;


import com.klepra.polls.entity.Role;
import com.klepra.polls.entity.RoleEnum;
import com.klepra.polls.entity.User;
import com.klepra.polls.repository.RoleRepository;
import com.klepra.polls.repository.UserRepository;
import java.util.Arrays;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author klemen
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {

        Role userRole = new Role(RoleEnum.ROLE_USER.toString());
        roleRepository.save(userRole);
        Role adminRole = new Role(RoleEnum.ROLE_ADMIN.toString());
        roleRepository.save(adminRole);

        String password = bcryptEncoder.encode("password");

        User u1 = new User("user", password);
        u1.setRoles(Arrays.asList(userRole));
        userRepository.save(u1);

        User u2 = new User("admin", password);
        u2.setRoles(Arrays.asList(adminRole, userRole));
        userRepository.save(u2);
    }

}
