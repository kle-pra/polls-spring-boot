/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klepra.polls.repository;

import com.klepra.polls.entity.Poll;
import com.klepra.polls.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author klemen
 */
public interface PollRepository extends JpaRepository<Poll, Long> {

    List<Poll> findAllByUser(User user);

}
