package com.example.demorest.controllers;

import com.example.demorest.domeins.Message;
import com.example.demorest.domeins.Views;
import com.example.demorest.repo.MessageRepo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {

    private final MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list() {
        return messageRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.IdDate.class)
    public Message getOne(@PathVariable("id") Message messageFromDB) {
        return messageFromDB;
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        message.setCreatTime(LocalDateTime.now());
        return messageRepo.save(message);
    }

    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageFromDB
            , @RequestBody Message message) {
        BeanUtils.copyProperties(message,messageFromDB, "id");
        return messageRepo.save(messageFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message messageFromDB) {
        messageRepo.delete(messageFromDB);
    }
}
