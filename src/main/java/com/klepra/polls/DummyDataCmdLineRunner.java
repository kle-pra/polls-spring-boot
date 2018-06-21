/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klepra.polls;

import com.klepra.polls.entity.Option;
import com.klepra.polls.entity.Poll;
import com.klepra.polls.repository.OptionRepository;
import com.klepra.polls.repository.PollRepository;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author klemen
 */
@Component
public class DummyDataCmdLineRunner implements CommandLineRunner {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Override
    public void run(String... strings) throws Exception {
        Poll poll = new Poll("What do you preffer to code backend in?");
        poll.setVisible(Boolean.TRUE);
        poll.setEndDate(new Date());
        poll.setIpAdresses(Arrays.asList("192.1.2.164"));
        pollRepository.save(poll);

        Option option1 = new Option("Java");
        Option option2 = new Option("Node");
        option1.setPoll(poll);
        option2.setPoll(poll);
        optionRepository.save(option1);
        optionRepository.save(option2);

//        pollRepository.deleteById(poll.getId());

        Poll poll2 = new Poll("What do frontend framework do you preffer?");
        poll2.setVisible(Boolean.TRUE);
        poll2.setEndDate(new Date());
        poll2.setIpAdresses(Arrays.asList("192.1.2.164"));

        option1 = new Option("Angular");
        option2 = new Option("React");
        option1.setPoll(poll2);
        option2.setPoll(poll2);
        pollRepository.save(poll2);
        optionRepository.save(option1);
        optionRepository.save(option2);

    }

}
