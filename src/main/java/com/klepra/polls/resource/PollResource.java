/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klepra.polls.resource;

import com.klepra.polls.entity.Poll;
import com.klepra.polls.services.PollService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author klemen
 */
@RestController
@RequestMapping("/api/polls")
public class PollResource {
    
    @Autowired
    private PollService pollService;
    
    @GetMapping()
    public List<Poll> list() {
        return pollService.getAll();
    }
    
    @GetMapping("/{id}")
    public Poll get(@PathVariable String id) {
        return pollService.getPollById(Long.parseLong(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Poll poll) {
        poll.setId(id);
        Poll updatePoll = pollService.updatePoll(poll);
        return ResponseEntity.ok(updatePoll);
    
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Poll poll) {
        Poll savedPoll = pollService.savePoll(poll);
        return ResponseEntity.status(201).body(savedPoll);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        pollService.deletePollById(id);
        return ResponseEntity.status(204).build();

    }
    
    @PostMapping("{id}/vote/{optionId}")
    public ResponseEntity<?> post(@PathVariable Long id, @PathVariable Long optionId) throws Exception {
        pollService.vote(id, optionId);
        return ResponseEntity.ok().build();
    }
}
